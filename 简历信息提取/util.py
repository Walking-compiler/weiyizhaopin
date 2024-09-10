# -*- coding: utf-8 -*-

#对需要预测的8762个职业description逐一处理
#当遇到分隔符时，如果没有超过MAX_LEN，我们直接对word和tag首尾分别加上[CLS][SEP];如果超过了MAX_LEN我们只截取MAX_LEN长度并首尾分别加上[CLS][SEP]

import torch
from torch.utils.data import Dataset
from transformers import BertTokenizer

bert_model = './models--bert-base-chinese'
tokenizer = BertTokenizer.from_pretrained(bert_model,return_dict=False)
VOCAB = ('<PAD>', '[CLS]', '[SEP]', 'O', 'B-JN', 'I-JN', 'I-JS',
         'I-JR', 'B-JS', 'B-JR', 'I-PS', 'B-PS')

tag2idx = {tag: idx for idx, tag in enumerate(VOCAB)}
idx2tag = {idx: tag for idx, tag in enumerate(VOCAB)}
MAX_LEN = 302 - 2


class NerDataset(Dataset):
    ''' Generate our dataset '''

    def __init__(self, f_path,bio_path2):
        self.sents = []
        self.tags_li = []

        with open(f_path, 'r', encoding='utf-8') as f:
            lines = [line.split('\n')[0] for line in f.readlines() if len(line.strip()) != 0]
            # print(lines)

        tags = [line.split('\t')[1] for line in lines]
        words = [line.split('\t')[0] for line in lines]

        word, tag = [], []
        for char, t in zip(words, tags):
            if char != '，' and char!='.' and char !='、' :
                word.append(char)
                tag.append(t)
            else:
                if len(word) > MAX_LEN:
                    self.sents.append(['[CLS]'] + word[:MAX_LEN] + ['[SEP]'])
                    self.tags_li.append(['[CLS]'] + tag[:MAX_LEN] + ['[SEP]'])
                else:
                    self.sents.append(['[CLS]'] + word + ['[SEP]'])
                    self.tags_li.append(['[CLS]'] + tag + ['[SEP]'])
                word, tag = [], []
        if len(word) > MAX_LEN:
            self.sents.append(['[CLS]'] + word[:MAX_LEN] + ['[SEP]'])
            self.tags_li.append(['[CLS]'] + tag[:MAX_LEN] + ['[SEP]'])
        else:
            self.sents.append(['[CLS]'] + word + ['[SEP]'])
            self.tags_li.append(['[CLS]'] + tag + ['[SEP]'])
        #print(self.sents)
        #print(len(self.sents))
        #print(self.tags_li)
        #print(len(self.tags_li))
        with open(bio_path2, 'w', encoding='utf-8') as f:
            for i in self.sents:
                for j in i:
                    if j=='[CLS]' or j=='[SEP]':
                        pass
                    else:
                        f.write(j)
                        f.write('\n')

    def __getitem__(self, idx):
        words, tags = self.sents[idx], self.tags_li[idx]
        token_ids = tokenizer.convert_tokens_to_ids(words)
        laebl_ids = [tag2idx[tag] for tag in tags]
        seqlen = len(laebl_ids)
        return token_ids, laebl_ids, seqlen

    def __len__(self):
        return len(self.sents)


def PadBatch(batch):
    maxlen = max([i[2] for i in batch])
    token_tensors = torch.LongTensor([i[0] + [0] * (maxlen - len(i[0])) for i in batch])
    label_tensors = torch.LongTensor([i[1] + [0] * (maxlen - len(i[1])) for i in batch])
    mask = (token_tensors > 0)
    return token_tensors, label_tensors, mask
