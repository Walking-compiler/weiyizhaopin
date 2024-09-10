import pandas as pd


# 读取保存all_similarity_single_text的文件
def read_1d(path):
    # 用于存储读取的一维列表数据
    read_list = []
    # 打开 txt 文件并读取数据
    with open(path, 'r', encoding='gbk') as file:
        # 逐行读取文件内容
        for line in file:
            # 移除行末的换行符，并将该行添加到读取的列表中
            read_list.append(line.strip())
    return read_list


# 读取保存all_similarity_text的文件
def read_2d(path):
    read_2d_list = []
    # 打开 txt 文件并读取数据
    with open(path, 'r', encoding='utf-8') as file:
        # 逐行读取文件内容
        for line in file:
            # 移除行末的换行符，并将该行以制表符分隔为列表元素
            row = line.strip().split('\t')
            # 将该行列表添加到读取的多维列表中
            read_2d_list.append(row)

    return read_2d_list


# 读取保存id2single_entities的csv文件
def read_entity2id_csv(path):
    return pd.read_csv(path, sep=',', encoding='utf-8', names=['entity', 'index'])

'''
a = read_1d('./1dlist.txt')
print(a)
print('-------------------------')
b = read_2d('./2dlist.txt')
print(b)
print('-------------------------')
'''
c = read_entity2id_csv('./data/JOB/idx2single_job.csv')
print(c)
'''
d = read_entity2id_csv('./entities2id.csv')
print(d)
'''
