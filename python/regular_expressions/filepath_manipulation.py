# This is a script to handle a set of filepaths in a csv and manipulate them in certain ways as explained below; the end goal is to select only the folders that have a certain set of conditions and create a list of those folders. The process has many sub-goals and is best explained by reading the comments.

import pandas as pd
import re
# import all the files within Cycle1 as filepaths starting at Cycle1
df = pd.read_csv("folders_filenames.csv")
print(df)


# turn into a list so we can perform operations on it
PETs = df.values.tolist()
PETs = [' '.join(PET) for PET in PETs]
print(PETs[:20])


# add the beginning part of the filepath to each file
start = '/autofs/vast/pricelab/cnk/adds_abcds_data/data/PET'
PETs2 = [start + '/' + i for i in PETs]
print(PETs2[:20])


# take only the nifti files and convert back to a df so we can view them as columns
nii = []
for i in PETs2:
    if ".nii" in i:
        nii.append(i)
df2 = nii
df2


# take out any file that says merged or merge, since I am supposed to merge it myself
# create a list to represent nii no merge
nii_nom = []
# for every file in the nii list
for i in nii:
    # take out any file that says merge and append the rest to nii_nom
    if "merge" not in i:
        nii_nom.append(i)
# convert to a df (just for the moment) so i can view as columns
#df3 = nii_nom
#df3


# Dictionary to hold lists of files grouped by the first 4 digits
grouped_subjects = {}

# Regex pattern to extract 'example_parent_folder/' and the first 4 digits
m = r'(example_parent_folder\/)(\d{4})'

# Loop through each file in the list
for i in nii_nom:
    # Search for the first 4 digits
    match = re.search(m, i)
    if match:
        # Get the first 4 digits
        subject_id = match.group(2)
        
        # Initialize the list if the subject_id doesn't exist
        if subject_id not in grouped_subjects:
            grouped_subjects[subject_id] = []
        
        # Add the file to the corresponding subject_id group
        grouped_subjects[subject_id].append(i)

# Display the grouped files
for subject, files in grouped_subjects.items():
    print(f"Subject {subject}: {files}")


# Dictionary to hold lists of files grouped by the first 4 digits
grouped_subjects = {} 

# Regex pattern to extract 'example_parent_folder/' and the first 4 digits
m = r'(example_parent_folder\/)(\d{4})'

# Loop through each file in the list
for i in nii_nom:
    # Search for the first 4 digits
    match = re.search(m, i)
    if match:
        # Get the first 4 digits
        subject_id = match.group(2)
        
        # Initialize the list if the subject_id doesn't exist
        if subject_id not in grouped_subjects:
            grouped_subjects[subject_id] = []
        
        # Add the file to the corresponding subject_id group
        grouped_subjects[subject_id].append(i)

# Display the grouped files
for subject, files in grouped_subjects.items():
    print(f"Subject {subject}: {files}")


# if there is a file starting with a number for a given subject, take only the file(s) that start(s) with a number
# i.e., for each subject, if a file(s) starts with a digit, take only the file with the digit, otherwise keep all the files for a given subject

# create the regex to search for a file starting with a digit
m = r'^\d'

# create a new dictionary
grouped_subjects_d = {}

# then loop through the dictionary: for each key value pair in the dictionary i.e. for each subject and its files
for key, value in grouped_subjects.items():
    # iterate through each string in the list contained within the value part of the key value pair
    for file_path in value:
        # find the last occurrence of '/'
        last_slash_index = file_path.rfind('/')
        # find the index of the first char that comes after the last slash, "last slash plus one"
        lspo = last_slash_index + 1
        # temporary checks 
        # print(lspo)
        # print(file_path[lspo])
        # for a given subject, if the lspo is a digit, append only that filepath to the new list
        if file_path[lspo].isdigit():
            # another check
            # print(file_path[lspo])
            grouped_subjects_d.update({subject: file_path})
        # otherwise, append all filepaths from a given subject
        #else:
           # grouped_subjects_d[subject] = file_path

print(grouped_subjects_d)




# If there is a file starting with a number for a given subject, take all the file(s) that start(s) with a number
# i.e., for each subject, if a file(s) starts with a digit, take all the files that start with a digit, otherwise keep all the files for a given subject

# Create the regex to search for a file starting with a digit
m = r'^\d'

# Create a new dictionary to hold the grouped subjects
grouped_subjects_d = {}

# Loop through the dictionary: for each key-value pair (subject and its files)
for key, value in grouped_subjects.items():
    # Create a list for each subject to store files that start with a digit
    digit_files = []

    # Iterate through each file path in the list for the subject
    for file_path in value:
        # Find the last occurrence of '/'
        last_slash_index = file_path.rfind('/')

        # Find the index of the first char that comes after the last slash ("last slash plus one")
        lspo = last_slash_index + 1

        # Check if the character after the last slash is a digit
        if file_path[lspo].isdigit():
            # If a file starts with a digit, add it to the digit_files list
            digit_files.append(file_path)

    # Now check if any files start with a digit:
    if digit_files:
        # If there are files that start with a digit, we only keep those files for the subject
        grouped_subjects_d[key] = digit_files
    else:
        # Otherwise, if no files start with a digit, keep all the files for the subject
        grouped_subjects_d[key] = value

# Display the grouped files
print(grouped_subjects_d)


# remove duplicate values that got added; I can't figure out why they're being added
for key, value in grouped_subjects_d.items():
    # Remove duplicates by converting to a set, then back to a list
    grouped_subjects_d[key] = list(set(value))

# Display the dictionary after removing duplicates
print(grouped_subjects_d)


# now split the dict into key-value pairs that have one value, and key-value pairs that have multiple values, so that I can merge nifti files as needed

# dict for key-value pairs that have one value
gss = {}

# dict for key-value pairs that have multiple values
gsm = {}

for key, value in grouped_subjects_d.items():
    if len(value) == 1:
        gss[key] = value
    if len(value) > 1:
        gsm[key] = value


print(gss)
print(len(gss))
for key in gss:
    print(key)


print(len(gsm))
print("\n")

for key, value in gsm.items():
    print(f"Subject: {key}")
    for file in value:
        print(file)  # print each file on a new line
    print() 


# now make my third and final dictionary - pull out <example folders> (since I can't figure out which of those to use) and put them in their own dict, leaving the rest in gsm

remove = {'<example folders>'}

# u for unknown
gsu = {}

# check
# print(gsu)

# gsm.items() returns an iterator instead of a list, which leads to the RuntimeError "dictionary changed size during iteration;" convert to a list to solve this
for key, value in list(gsm.items()):
    if key in remove:

        print(f"Match found for key {key}, adding to gsu")
        
        # iterate over the files in the list that comprises each value, put each key I can't figure out in gsu
        for file in value:
            gsu.update({key: value})
            
        # take the keys I can't figure out out of the gsm dict
        del gsm[key]

# check
# print("gsm:")
# for key, value in gsm.items():
#     print(f"Subject: {key}")
#     for file in value:
#         print(file)  # print each file on a new line
#     print() 

# check
# print()
# print("gsu:")
# for key, value in gsu.items():
#     print(f"Subject: {key}")
#     for file in value:
#         print(file)  # print each file on a new line
#     print() 

print("The subjects for which we want to combine all the nifti files within the subject's folder into a single nifti file are", end = " ") 
for key, value in gsm.items():
    print(f"\"{key}\"", sep = " ", end = " ")
print(".\n") 
print("The folders in which these subjects are located are as follows:", end = " ")

m = r'(Cycle1\/)(.*)(\/)'

# create a list to store matches in
folder_matches = []

for key, value in gsm.items():
    for file in value:
        match = re.search(m, file)
        if match:
            if match.group(2) not in folder_matches:
                folder_matches.append(match.group(2))

for f in folder_matches:
    print(f"\"{f}\"", sep=" ", end=" ")

print("\n")
print(len(folder_matches))



