#针对用户上传简历和对应职位后第二次匹配，直接提取./company.txt已保存的用户简历信息，进行查询匹配，同时可支持personpredictpro进行选择对应公司
from py2neo import Graph, Node, Relationship, NodeMatcher
import jieba
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity
import warnings
import ast

def tokenize_zh(text):
    """
    使用jieba进行中文分词
    """
    return jieba.lcut(text)

def compute_similarity(text1, text2):
    """
    计算两段文本的相似度
    """
    # 创建一个TF-IDF Vectorizer对象，使用jieba进行分词
    vectorizer = TfidfVectorizer(tokenizer=tokenize_zh, stop_words=[])

    # 将文本转换为TF-IDF向量
    tfidf_matrix = vectorizer.fit_transform([text1, text2])

    # 计算余弦相似度
    similarity = cosine_similarity(tfidf_matrix[0:1], tfidf_matrix[1:2])

    return similarity[0][0]


def personpredictpropro(person_path,company_desire,job_desire):
    #company_desire = ''
    #job_desire = 'IT运维工程师'

    text = ''
    person_information_path=person_path+'/company.txt'
    warnings.filterwarnings('ignore',
                            message="The parameter 'token_pattern' will not be used since 'tokenizer' is not None")

    with open(person_information_path, 'r', encoding='utf-8') as f:
        i = 0
        line = f.readlines()[:]
        # print(line)
        for li in line:
            if i==0:
                li = li.split('\n')[0]
                company = ast.literal_eval(li)
                i+=1
            elif i==1:
                li = li.split('\n')[0]
                JN=ast.literal_eval(li)
                i+=1
            elif i==2:
                li = li.split('\n')[0]
                JR = ast.literal_eval(li)
                i+=1
            elif i==3:
                li = li.split('\n')[0]
                JS = ast.literal_eval(li)
                i+=1
            elif i==4:
                li = li.split('\n')[0]
                PS = ast.literal_eval(li)
                i+=1
            else:
                text=text+li
            '''            
            elif i==5:
                li = li.split('\n')[0]
                matchtphone = li
                i += 1
            elif i==6:
                li = li.split('\n')[0]
                matchemail = li
                i += 1
            elif i==7:
                li = li.split('\n')[0]
                matches = ast.literal_eval(li)
                i += 1
            '''





    if '博士' in text:
        education='博士'
    elif '研究生' in text or '硕士' in text:
        education='硕士'
    elif '本科' in text:
        education='本科'
    elif '专科' in text:
        education='专科'
    else:
        education='暂无'

        # graph query知识图谱查询

        # 连接数据库
    graph = Graph("bolt://localhost:7687", auth=("neo4j", "weiyizhaopin"))
    matcher = NodeMatcher(graph)



    # 构建目标职位查询的字典
    # 查询关系
    query = "MATCH (m)-->(n:Job)  " \
            "WHERE n.name ='{}' and m.name='{}' RETURN m,n".format(job_desire,company_desire)
    df = graph.run(query).to_data_frame()
    company = {}
    for index, row in df.iterrows():
        if row[0]['name'] not in company:
            company[row[0]['name']] = {}
        if row[1]['name'] not in company[row[0]['name']]:
            company[row[0]['name']][row[1]['name']] = {}
            company[row[0]['name']][row[1]['name']]['JN'] = []
            company[row[0]['name']][row[1]['name']]['JR'] = []
            company[row[0]['name']][row[1]['name']]['PS'] = []
            company[row[0]['name']][row[1]['name']]['JS'] = []
            company[row[0]['name']][row[1]['name']]['education'] = []
            company[row[0]['name']][row[1]['name']]['salary'] = []
            company[row[0]['name']][row[1]['name']]['description'] = []
            company[row[0]['name']][row[1]['name']]['location'] = []
            company[row[0]['name']][row[1]['name']]['hr'] = []
            company[row[0]['name']][row[1]['name']]['link'] = []
            company[row[0]['name']][row[1]['name']]['education'].append(row[1]['education'])
            company[row[0]['name']][row[1]['name']]['salary'].append(row[1]['salary'])
            company[row[0]['name']][row[1]['name']]['description'].append(row[1]['description'])

    # location
    query = "MATCH (m)-->(n:Job)-->(local:location)  " \
            "WHERE n.name ='{}' and m.name='{}' RETURN m,n,local".format(job_desire,company_desire)
    df = graph.run(query).to_data_frame()
    for index, row in df.iterrows():
        company[row[0]['name']][row[1]['name']]['location'].append(row[2]['name'])

    # hr
    query = "MATCH (m)-->(n:Job)-->(hr:HR)  " \
            "WHERE n.name ='{}' and m.name='{}' RETURN m,n,hr".format(job_desire,company_desire)
    df = graph.run(query).to_data_frame()
    for index, row in df.iterrows():
        company[row[0]['name']][row[1]['name']]['hr'].append(row[2]['name'])

    # location
    query = "MATCH (m)-->(n:Job)-->(link:link)  " \
            "WHERE n.name ='{}' and m.name='{}' RETURN m,n,link".format(job_desire,company_desire)
    df = graph.run(query).to_data_frame()
    for index, row in df.iterrows():
        company[row[0]['name']][row[1]['name']]['link'].append(row[2]['name'])

    # JN
    query = "MATCH (m)-->(n:Job)-->(jn:JN)  " \
            "WHERE n.name ='{}' and m.name='{}' RETURN m,n,jn".format(job_desire,company_desire)
    df = graph.run(query).to_data_frame()
    for index, row in df.iterrows():
        company[row[0]['name']][row[1]['name']]['JN'].append(row[2]['name'])

    # JR
    query = "MATCH (m)-->(n:Job)-->(jr:JR)  " \
            "WHERE n.name ='{}' and m.name='{}' RETURN m,n,jr".format(job_desire,company_desire)
    df = graph.run(query).to_data_frame()
    for index, row in df.iterrows():
        company[row[0]['name']][row[1]['name']]['JR'].append(row[2]['name'])

    # JS
    query = "MATCH (m)-->(n:Job)-->(js:JS)  " \
            "WHERE n.name ='{}' and m.name='{}' RETURN m,n,js".format(job_desire,company_desire)
    df = graph.run(query).to_data_frame()
    for index, row in df.iterrows():
        company[row[0]['name']][row[1]['name']]['JS'].append(row[2]['name'])

    # PS
    query = "MATCH (m)-->(n:Job)-->(ps:PS)  " \
            "WHERE n.name ='{}' and m.name='{}' RETURN m,n,ps".format(job_desire,company_desire)
    df = graph.run(query).to_data_frame()
    for index, row in df.iterrows():
        company[row[0]['name']][row[1]['name']]['PS'].append(row[2]['name'])

    # print(company)
    with open(person_information_path, 'w', encoding='utf-8') as f2:
        f2.write(repr(company))
        f2.write('\n')
        f2.write(repr(JN))
        f2.write('\n')
        f2.write(repr(JR))
        f2.write('\n')
        f2.write(repr(JS))
        f2.write('\n')
        f2.write(repr(PS))
        f2.write('\n')
        f2.write(text)
    message=""
    # 输出简历与目标职位差距
    for i in company:

        print(f'对于{i}的职位:', end='')
        message=message+f'对于{i}的职位:'
        for j in company[i]:
            # JN
            print(j, end=',')
            message = message +j
            similarity = compute_similarity(text, ''.join(map(str, company[i][j]['description'])))
            similarity_JN = compute_similarity(''.join(map(str,JN)), ''.join(map(str, company[i][j]['JN'])))
            similarity_PS = compute_similarity(''.join(map(str,PS)), ''.join(map(str, company[i][j]['PS'])))
            similarity_ED=compute_similarity(''.join(map(str,education)), ''.join(map(str, company[i][j]['education'])))

            print('契合度可达{:.2f}%'.format((similarity*0.4+similarity_JN*0.3+similarity_PS*0.2+similarity_ED*0.1) * 100+80))
            print('职业技能方面：')
            message = message +',契合度可达{:.2f}%'.format((similarity*0.4+similarity_JN*0.3+similarity_PS*0.2+similarity_ED*0.1) * 100+90)+'\n'+'职业技能方面：'+'\n'
            flag = 0
            for k in company[i][j]['JN']:
                if k.lower() not in JN and flag == 0:
                    print('你还需要提高下自己哦，可以针对性的学习些以下技能：', end='')
                    message=message+'你还需要提高下自己哦，可以针对性的学习些以下技能：'+' '
                    flag = 1
                    print(k.split('\n')[0], end=' ')
                    message = message +k.split('\n')[0]+' '
                    continue
                if k.lower() not in JN and flag == 1:
                    print(k.split('\n')[0], end=' ')
                    message = message + k.split('\n')[0] + ' '
            if flag == 0:
                print('技能方面，你已经做的很棒了，非常符合该职位要求，快去递交简历应聘吧！', end=' ')
                message = message +'技能方面，你已经做的很棒了，非常符合该职位要求，快去递交简历应聘吧！'+' '
            print()
            message = message +'\n'

            # JR
            print('职业要求方面：')
            message = message + '职业要求方面：'+'\n'
            flag = 0
            for k in company[i][j]['JR']:
                if k not in JR and flag == 0:
                    print('该公司针对该职位有一些要求，比如：', end='')
                    message = message +'该公司针对该职位有一些要求，比如：'+' '
                    flag = 1
                    print(k.split('\n')[0], end=' ')
                    message = message + k.split('\n')[0]+' '
                    continue
                if k not in JR and flag == 1:
                    print(k.split('\n')[0], end=' ')
                    message = message + k.split('\n')[0] + ' '
            if flag == 0:
                print('你的各方面很符合公司的职位要求！', end=' ')
                message = message + '你的各方面很符合公司的职位要求！'+ ' '
            '''JR1 = []
            for k in JR:
                if k not in company[i][j]['JR']:
                    JR1.append(k)
            if flag == 0 and len(JR1) > 0:
                print('并且你还可以做到：', end='')
                for m in JR1:
                    print(m.split('\n')[0], end=' ')
            if flag == 1 and len(JR1) > 0:
                print()
                print('虽然对公司职位要求你并不能完全满足，但你还具备这些额外的能力：', end='')
                for m in JR1:
                    print(m.split('\n')[0], end=' ')'''
            print()
            message = message + '\n'

            # PS
            print('个人素养方面：')
            message = message + '个人素养方面：' + '\n'
            flag = 0
            for k in company[i][j]['PS']:
                if k not in PS and flag == 0:
                    print('该公司针还希望你有以下的个人素养，比如：', end='')
                    message = message + '该公司针还希望你有以下的个人素养，比如：' + ' '
                    flag = 1
                    print(k.split('\n')[0], end=' ')
                    message = message + k.split('\n')[0] + ' '
                    continue
                if k not in PS and flag == 1:
                    print(k.split('\n')[0], end=' ')
                    message = message + k.split('\n')[0] + ' '
            if flag == 0:
                print('你的个人素养非常突出，该公司很满意！', end=' ')
                message = message + '你的个人素养非常突出，该公司很满意！' + ' '
            PS1 = []
            for k in PS:
                if k not in company[i][j]['PS']:
                    PS1.append(k)
            if flag == 0 and len(PS1) > 0:
                print('同时你还具备这些额外的品质：', end='')
                message = message + '同时你还具备这些额外的品质：'+ ' '
                for m in PS1:
                    print(m.split('\n')[0], end=' ')
                    message = message + m.split('\n')[0] + ' '
            if flag == 1 and len(PS1) > 0:
                print()
                message = message + '\n'
                print('虽然还有些品质等待你发掘，但可贵的是，你还具备这些宝贵的品质：', end='')
                message = message + '虽然还有些品质等待你发掘，但可贵的是，你还具备这些宝贵的品质：' + ' '
                for m in PS1:
                    print(m.split('\n')[0], end=' ')
                    message = message + m.split('\n')[0] + ' '
            print()
            message = message + '\n'

            # JS
            flag = 0
            for k in company[i][j]['JS']:
                if k not in PS and flag == 0:
                    print('公司职业待遇方面：')
                    message = message + '公司职业待遇方面：'+'\n'
                    print('该公司还有丰厚的职业待遇，比如：', end='')
                    message = message + '该公司还有丰厚的职业待遇，比如：'+' '
                    flag = 1
                    print(k.split('\n')[0], end=' ')
                    message = message + k.split('\n')[0] + ' '
                    continue
                if k not in PS and flag == 1:
                    print(k.split('\n')[0], end=' ')
                    message = message + k.split('\n')[0] + ' '

            k = ''.join(map(str, company[i][j]['salary']))
            print()
            message = message + '\n'
            print(f'tips:该公司岗位的预期工资为:{k}', end=',')
            message = message + f'tips:该公司岗位的预期工资为:{k}'+','
            k = ''.join(map(str, company[i][j]['location']))
            print(f'该岗位就职地点为：{k}')
            message = message + f'该岗位就职地点为：{k}' + '\n'

            # 学历
            k = ''.join(map(str, education))
            print(f'tips:你的最高学历为：{k}', end='\t')
            message = message +f'tips:你的最高学历为：{k}' + '\t'
            k = ''.join(map(str, company[i][j]['education']))
            print(f'该公司期待的最低学历为：{k}')
            message = message + f'该公司期待的最低学历为：{k}' + '\n'

            k = ''.join(map(str, company[i][j]['hr']))
            print(f'公司招聘负责人HR：{k}', end=',')
            message = message + f'公司招聘负责人HR：{k}' + ','
            k = ''.join(map(str, company[i][j]['link']))
            print(f'联系方式为：{k}（点击链接跳转到公司招聘界面）')
            message = message + f'联系方式为：{k}（点击链接跳转到公司招聘界面）' + '\n'
            print(
                '心动不如行动，赶快根据以上内容，对简历进行适当修改，补充相应的技能知识，赶快来求职吧，大家都很期待你的加入！')
            message = message + '心动不如行动，赶快根据以上内容，对简历进行适当修改，补充相应的技能知识，赶快来求职吧，大家都很期待你的加入！'+ '\n'
            print()
            print('_______________________________________________________________________________________')
    print(message)
    return message

if __name__ == '__main__':
    personpredictpropro('./person1','广东倾云科技有限公司','【初级】web前端开发工程师')