# A document to create and populate a csv using os

import os
import pandas as pd
import pathlib
from pathlib import Path
import random


insert_filepath_here = # For user to fill in
folder = pathlib.Path(insert_filepath_here)
print(folder)


### Get filepaths from the insert_filepath_here folder

filepaths = [os.path.join(folder, file) for file in os.listdir(folder)]
print(filepaths)


# Randomly select 15 more files from another folder
insert_second_filepath_here = # For user to fill in
random_folder = pathlib.Path(insert_second_filepath_here)
print(random_folder)


random_filepaths = []
for path in Path(insert_second_filepath_here).rglob('*'):
    if path.is_dir():
        folder_files = [os.path.join(path, file) for file in os.listdir(path)]
        random_filepaths.extend(folder_files)

        
filtered_random_filepaths = [path for path in random_filepaths if "doc" in path]


n = 5
num_random = random.sample(filtered_random_filepaths, n)
print(num_random)


final_list = filtered_filepaths + num_random


list = [path for path in filepaths if "doc" in path]
dict = {'filepath': final_list}
df = pd.DataFrame(dict)
df.drop_duplicates(inplace=True)
df.to_csv('name.csv')


print(len(df))


len_df = int(len(df))
if len(df) > 10:
    num_to_remove = len_df - 10
    df.drop(df.tail(num_to_remove).index,
        inplace = True)
print(len(df))


new_columns = ["add extra columns here", "etc"]
for column in new_columns:
    df[column] = ""
df.to_csv('name.csv', index=False, sep=',')
