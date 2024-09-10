import csv


def write_1dlist_txt(path, my_list):
    with open(path, 'w') as file:
        # 将列表的每个元素写入文件，每个元素占一行
        for item in my_list:
            file.write(item + '\n')


# 将all_similarity_text写入文件
def write_2dlist_txt(path, my_list):
    # 打开 txt 文件并写入数据
    with open(path, 'w', encoding='utf-8') as file:
        # 将多维列表中的每个子列表写入 txt 文件的一行
        for row in my_list:
            # 将子列表中的元素以制表符分隔，形成一行文本
            line = '\t'.join(row)
            # 将该行文本写入文件
            file.write(line + '\n')


def write_entity2id_csv(path, my_list):
    # 打开 CSV 文件并写入数据
    with open(path, 'w', newline='', encoding='utf-8') as file:
        writer = csv.writer(file)

        # 将多维列表中的每个子列表写入 CSV 文件的一行
        for row in my_list:
            writer.writerow(row)


def write_entities2id_csv(path, my_list):
    # 打开 CSV 文件并写入数据
    with open(path, 'w', newline='', encoding='utf-8') as file:
        writer = csv.writer(file)

        # 遍历每个子列表，并将其转换为一行写入 CSV 文件
        for item in my_list:
            # 将子列表中的城市名称用逗号连接成字符串
            entities = ', '.join(item[0])
            # 获取第二个元素作为标签
            idx = item[1]
            # 将城市列表和标签写入 CSV 文件的一行
            writer.writerow([entities, idx])


'''
a = [['成都', '重庆', '广州', '1'], ['北京', '天津', '1']]
write_2dlist_txt('./2dlist.txt', a)
b = ['成都', '工程师', '科学家']
write_1dlist_txt('./1dlist.txt', b)
c = [['成都', 1], ['重庆', 2]]
write_entity2id_csv('./entity2id.csv', c)
d = [[['成都', '重庆', '广州'], '1'], [['北京', '天津'], '1']]
write_entities2id_csv('./entities2id.csv', d)
'''
