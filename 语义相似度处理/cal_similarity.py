import pandas as pd
import numpy as np
import sys

sys.path.append('..')
from text2vec import Similarity


def compute_similarity(texts, rate):

    sim_model = Similarity()

    all_similarity_single_text = []
    all_similarity_text = []

    # 两两计算文本相似度
    for text in texts:
        query = text
        similarity_text = [text]
        for text2 in texts:
            if text2 != query:
                similarity_rate = sim_model.get_score(query, text2)
                if similarity_rate >= rate:
                    # 相似的文本，从列表中去除，避免生成两个包含了高度相似的文本的列表
                    similarity_text.append(text2)
                    texts.remove(text2)

        all_similarity_text.append(similarity_text)
        # 从每一个相似的文本的列表中拿出一个作为代表
        all_similarity_single_text.append(text)
    id2single_entities = [[entity, idx] for idx, entity in enumerate(all_similarity_single_text)]
    id2groupby_entities = [[entity, idx] for idx, entity in enumerate(all_similarity_text)]

    return all_similarity_single_text, all_similarity_text, id2single_entities, id2groupby_entities
