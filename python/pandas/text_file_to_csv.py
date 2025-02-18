import pandas as pd

# Read the text file using read_csv
df = pd.read_csv('klunk_yc.txt', sep=' ')
# View df; will do twice more ie after each step
df

# Drop columns I don't want
df = df.drop(columns=df.loc[:, 'a':'d'].columns)
df

# Convert the text file to csv
df = df.drop(columns=df.loc[:, 'a':'d'].columns)
df
