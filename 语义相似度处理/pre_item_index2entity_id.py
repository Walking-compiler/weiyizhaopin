import pandas as pd
import numpy as np


kg = pd.read_csv('./kg.csv', sep='\t')
ratings = pd.read_csv('./jianli_ratings.csv')

npkg = np.array(kg)
items_in_kg = npkg[:, 0::2].flatten().tolist()
items_of_user = ratings.user_id.tolist()
items = items_in_kg + items_of_user
items = list(set(items))  # Move duplicates
i2e = [[item, entity] for entity, item in enumerate(items)]

i2e = dict(i2e)

ratings = ratings.replace(i2e)
ratings.to_csv('completed_ratings.csv', index=False, sep='\t')

kg = pd.DataFrame(kg)
kg = kg.replace(i2e)
kg.to_csv('completed_kg.txt', header=False, index=False, sep='\t')

i2e = [[entity, entity] for entity, item in enumerate(items)]
np.savetxt('item_index2entity_id.txt', i2e, fmt='%s', delimiter='\t')
