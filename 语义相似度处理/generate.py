import pandas as pd
import numpy as np
import random
import re

path = './to_change.csv'

df = pd.read_csv(path)

jobs_id = list(range(0, 48))

items_id = df['item_id'].tolist()

items_id = list(set(items_id))

items2jobs = {}

for index, _ in enumerate(items_id):
    replacement_index = random.randint(0, len(jobs_id) - 1)
    items2jobs[items_id[index]] = jobs_id[replacement_index]

df.replace(items2jobs, inplace=True)
df = df.drop_duplicates(subset=['item_id', 'user_id'], keep='first')
df = df.drop(columns='vtime')

action = {'click': 'clicked', 'collect': 'collected', 'cart': 'delivered', 'alipay': 'satisfy'}
df.replace(action, inplace=True)

df.to_csv('ori_u_i_action.csv', index=False, sep='\t')

# Convert four behaviors into explicit ratings
df.action = df.action.replace(
    ['clicked', 'collected', 'delivered', 'satisfy'],
    [1.25, 2.5, 3.75, 5])
df = df[['user_id', 'item_id', 'action']].rename({'action': 'rating'}, axis=1)

# Save to ratings.csv
df.to_csv('ratings.csv', index=False, sep='\t')

