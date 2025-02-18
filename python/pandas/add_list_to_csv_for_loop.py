import pandas as pd

# Make an empty list to hold the filepaths
filepaths = []

# Create a new item in the list for each subject number from 116 to 134 inclusive
for i in range(116, 135):
    filepaths.append(f"first_part{i}second_part")

# Create a dictionary of list(s)
dict = {'PETfilepath': filepaths}

df = pd.DataFrame(dict)

# Save the dataframe
df.to_csv('new_yc_pet.csv')
