#利用职业信息数据集进行知识图谱的构建

import csv

import pandas
import re

# 打开CSV文件并读取内容
df=pandas.read_csv("data_all.csv",encoding='utf-8')
#print(df)

#pattern1 = re.compile(r'初级([\u4e00-\u9fa5]*)')
#pattern2 = re.compile(r'高级([\u4e00-\u9fa5]*)')
#print(row[2],row[3],row[4],row[5])


from py2neo import Graph, Node, Relationship, NodeMatcher

# 连接数据库
graph = Graph("bolt://localhost:7687", auth=("neo4j", "weiyizhaopin"))
graph.delete_all()
matcher = NodeMatcher(graph)
num=1
for index,row in df.iterrows():
    matcher = NodeMatcher(graph)
    # 创建一个Person节点
    if not matcher.match("company", name=row[1]).first():
        company = Node("company", name=row[1])
        # 将节点添加到数据库
        graph.create(company)
    else:
        company=matcher.match("company", name=row[1]).first()


    #job = Node("Job", name=row[2])
    if row[2][0:2]=='初级':
        job=Node("Job", name=row[2], salary=row[3], education=row[4],description=row[5],level='初级')
    elif row[2][0:2]=='中级':
        job = Node("Job", name=row[2], salary=row[3], education=row[4], description=row[5], level='中级')
    elif row[2][0:2]=='高级':
        job = Node("Job", name=row[2], salary=row[3], education=row[4], description=row[5], level='高级')
    elif '实习'in row[2]:
        job = Node("Job", name=row[2], salary=row[3], education=row[4], description=row[5], level='实习')
    else:
        job = Node("Job", name=row[2], salary=row[3], education=row[4], description=row[5], level='不限')

    # 将节点添加到数据库
    graph.create(job)


    # 创建一个Movie节点
    hr = Node("HR", name=row[6],time=row[7])
    # 将节点添加到数据库
    graph.create(hr)

    money=re.findall(r"\d+\.?\d*",row[3])
    if len(money)==2:
        money.append('12')
    if len(money)==0:
        money.append('None')
        money.append('None')
        money.append('None')


    if not matcher.match("salary", name=row[3],begin=row[3][0:1],end=row[3][2:3]).first():
        salary = Node("salary", name=row[3], begin=money[0],end=money[1],month=money[2])
        # 将节点添加到数据库
        graph.create(salary)
    else:
        salary = matcher.match("salary", begin=money[0],end=money[1],month=money[2]).first()


    if not matcher.match("education", name=row[4]).first():
        education = Node("education", name=row[4])
        # 将节点添加到数据库
        graph.create(education)
    else:
        education = matcher.match("education", name=row[4]).first()


    location=Node("location",name=row[8])
    graph.create(location)

    link = Node("link", name=row[9])
    graph.create(link)

    # 添加节点之间的关系
    graph.create(Relationship(company, "REQUIRE", job))
    #graph.create(Relationship(job, "CORRESPOND_SALARY", salary))
    #graph.create(Relationship(job, "REQUIRE_EDUCATION", education))
    graph.create(Relationship(job, "MANAGER", hr))
    graph.create(Relationship(job, "LOCATE", location))
    graph.create(Relationship(job, "LINK", link))
    graph.create(Relationship(job, "SALARY", salary))
    graph.create(Relationship(job, "EDUCATION", education))


    label = ['JN', 'JR', 'JS', 'PS']
    filepath = f'./description/bioprocesspro/{num}.txt'
    with open(filepath, 'r', encoding='utf-8') as f:
        i = 0
        line=f.readlines()[:4]
        #print(line)
        for li in line:
            lines = li.split('\t')
            #print(lines)
            if lines[0]=='\n':
                i+=1
                continue
            for lin in lines:
                if lin!='' and lin!='\n' and lin!='\t':
                    if not matcher.match(label[i], name=lin).first():
                        J = Node(label[i], name=lin)
                        # 将节点添加到数据库
                        graph.create(J)
                    else:
                        J=matcher.match(label[i],name=lin).first()

                    graph.create(Relationship(job, label[i], J))
            i += 1
    print(num)
    num += 1



