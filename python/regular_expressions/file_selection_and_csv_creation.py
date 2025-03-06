# ADDS-ABCDS File Selection and CSV Creation

# The goal of this program is to choose one file from each subject folder to analyze based on criteria such as which file is merged (ie has a time dimension of one) and which file starts with a digit instead of an underscore.

# Then, I want to create a csv matching the csv that goes into the Centiloid_Pipeline_April_matlab.m script, ie testfile.xlsx (need to confirm this is what the file is called), that has the filename and filepath for each file I chose.

# You can do this for either a set of PET filepaths or MR filepaths. You can then manually combine the csv's generated to create a single csv containing PET and MR values.

import pandas as pd
import re

# Import all the Cycle1 PET filepaths
# df = pd.read_csv("pet_filepaths.csv")

# OR

# Import all the Cycle1 MR filepaths
# df = pd.read_csv("mr_filepaths.csv")


# Turn df into a list so we can perform operations on it
def turn_to_list():
    files = df.values.tolist()
    files = [' '.join(file) for file in files]
    return(files)


# Take only the nifti files
def nifti():
    nii_files = []
    for i in files2:
        if ".nii" in i:
            nii_files.append(i)
    return nii_files


# Group subjects by subject id
def first_four():
    # Dictionary to hold lists of files grouped by the first 4 digits
    grouped_subjects = {}
    
    # Regex pattern to extract 'Cycle1/' and the first 4 digits
    m = r'(Cycle1\/)(\d{4})'

    # Loop through each file in the list
    for i in nii_files:
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
    
    return(grouped_subjects)


# For each subject, if a file starts with a digit, take only the file(s) that start with a digit, otherwise keep all the files for a given subject

def take_digits():
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
    return(grouped_subjects_d)


# Remove duplicate values that got added; I can't figure out why they're being added

def remove_duplicates():
    for key, value in grouped_subjects_d.items():
        # Remove duplicates by converting to a set, then back to a list
        grouped_subjects_d[key] = list(set(value))
    
    # Display the dictionary after removing duplicates
    return(grouped_subjects_d)


# Take out anything that doesn't say merge if a merge file is in the folder

def remove_no_merge():
    # create a dict to represent nii merge
    nii_m = {}
    # for every subject in grouped_subjects_d
    for key in grouped_subjects_d:
        # for every value in that key
        for value in grouped_subjects_d[key]:
            # if there is a merge in the subject
            if "merge" in value:
                # add it to the new dict
                nii_m[key] = value
    
    # For every key, value pair that is in nii_m, replace that key, value pair in grouped_subjects_d
    for key, value in nii_m.items():
        # If that key is in grouped_subjects_d
        if key in grouped_subjects_d:
            # Replace the values for that key with the value from nii_m
            grouped_subjects_d[key] = [value]  # Ensures each value becomes its own list
    
    return(grouped_subjects_d)


# Split the dict into key-value pairs that have one value, and key-value pairs that have multiple values so I can tease out which ones I have more work to do on

def gss_gsm():
    # dict for key-value pairs that have one value
    gss = {}
    
    # dict for key-value pairs that have multiple values
    gsm = {}
    
    for key, value in grouped_subjects_d.items():
        if len(value) == 1:
            gss[key] = value
        if len(value) > 1:
            gsm[key] = value

    return(gss, gsm)


# Make a third dictionary - pull out 6006 6053 6054 6072 6078 (since I can't figure out which of those to use) and put them in their own dict, leaving the rest in gsm

def remove_strange():
    # Define the subjects to remove
    remove = {'6006', '6053', '6054', '6072', '6078'}
    
    # u for unknown
    gsu = {}
    
    # check
    # print(gsu)
    
    # gsm.items() returns an iterator instead of a list, which leads to the RuntimeError "dictionary changed size during iteration;" convert to a list to solve this
    for key, value in list(grouped_subjects_d.items()):
        if key in remove:
    
            print(f"Match found for key {key}, adding to gsu")
            
            # iterate over the files in the list that comprises each value, put each key I can't figure out in gsu
            for file in value:
                gsu.update({key: value})
                
            # take the keys I can't figure out out of the gsm dict
            del grouped_subjects_d[key]
    
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
    
    return(folder_matches)


# Make a df with the columns required for the Centiloid pipeline, either with PET values or MR values. PET frame number can be added manually
def make_df():
    data_final = {'sID': [],
                'fulldirectory of ___ files': [],
                '___ file': []
                 }
    
    df_final = pd.DataFrame(data_final)

    return(df_final)


# Convert the items in the gss dict to full directory and pet files

def convert():
    
    # Import os to split the paths
    import os
    
    # Loop through the dictionary: for each key-value pair (subject and its file)
    for key, value in gss.items():
        
        # Iterate through each file path in the list for the subject
        for file_path in value:
    
            # Split into full directory and pet file and convert into a string
            dir_part, file_part = os.path.split(file_path)
            dir_part = str(dir_part)
            file_part = str(file_part)
    
            # Print as a check
            print(f"Directory part: {dir_part}")
            print(f"File part: {file_part}")
    
            # Use .loc to add the data as a new row to the DataFrame
            df_final.loc[len(df_final)] = [key, dir_part, file_part]
    
    return(df_final)


def main():
    turn_to_list(df)
    nifti(files)
    first_four(nii_files)
    take_digits(grouped_subjects)
    remove_duplicates(grouped_subjects_d)
    remove_no_merge(grouped_subjects_d)
    gss_gsm(grouped_subjects_d)
    remove_strange(grouped_subjects_d, gss, gsm)
    make_df(folder_matches)
    convert(df_final)


main()
