# -*- coding: utf-8 -*-

#所用模型bert-bilstm-crf的定义

import time

import torch
import torch.nn as nn
from transformers import BertModel
from torchcrf import CRF


class Bert_BiLSTM_CRF(nn.Module):

    def __init__(self, tag_to_ix, embedding_dim=768, hidden_dim=256):
        super(Bert_BiLSTM_CRF, self).__init__()
        self.tag_to_ix = tag_to_ix
        self.tagset_size = len(tag_to_ix)
        self.hidden_dim = hidden_dim
        self.embedding_dim = embedding_dim

        name='./models--bert-base-chinese'
        self.bert = BertModel.from_pretrained(name)

        self.lstm = nn.LSTM(input_size=embedding_dim, hidden_size=hidden_dim // 2,
                            num_layers=2, bidirectional=True, batch_first=True)
        self.dropout = nn.Dropout(p=0.1)
        self.linear = nn.Linear(hidden_dim, self.tagset_size)
        self.crf = CRF(self.tagset_size, batch_first=True)

    def _get_features(self, sentence):
        #t_1 = time.time()
        with torch.no_grad():
            embeds, _ = self.bert(sentence)

        enc, _ = self.lstm(embeds)
        enc = self.dropout(enc)
        feats = self.linear(enc)
        #print(f"get feature cost {time.time() - t_1}")
        return feats

    def forward(self, sentence, tags, mask, is_test=False):
        emissions = self._get_features(sentence)
        if not is_test:  # Training，return loss
            #t_1 = time.time()
            loss = -self.crf.forward(emissions, tags, mask, reduction='mean')
            #print(f"get feature cost {time.time() - t_1}")
            return loss
        else:  # Testing，return decoding
            decode = self.crf.decode(emissions, mask)
            return decode

