 ## **Word Pattern**
# 
# Given a pattern and a string s, find if s follows the same pattern.
# 
# Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
# 
# (Optional) Analyze the complexity of your algorithm and compare it with your classmates'
# ---
# 
# **Example 1:**
# 
# *   Input: pattern = "abba", s = "dog cat cat dog"
# *   Output: true
# 
# Example 2:
# 
# *   pattern = "abba", s = "dog cat cat fish"
# *   false
# 
# Example 3:
# 
# *   pattern = "aaaa", s = "dog cat cat dog"
# *   false

# Text above from zybooks.com, my work through the problem is below

pattern = 'abba'
s = 'dog cat cat dog'

def calc_ords(arr):
    """ 
    A function to calculate the ordinal values of ascii characters and words
    Words' values equal all the ordinal values of the characters summed together
    """
    # Start with i = 0
    i = 0
    # For each word in the string
    for word in arr:
        # Start with an ord value of 0
        ord_val = 0
        # For each character in that word
        for char in word:
            # Add to the ord value of that word
            ord_val += ord(char)
        # For each word, reassign itself with the ord value by taking the ith item in s
        arr[i] = ord_val
        # Add 1 to i
        i +=1
    return arr

def chaining_function(arr):
    """
    A hash function to assign values in an array 
    """
    # Make an array the length of the  input array to serve as the hash table
    chaining = [[] for _ in range (0,len(arr))]
    # Start by filling the first empty bucket
    chaining[0].append(arr[0])
    # Then, for every item in the array starting at the 2nd item and going to the last
    for i in range(1,len(arr)):
        # Track if the item is placed
        placed = False
        # For every array in chaining 
        for j in range(0,len(chaining)):
            # As long as the array is not empty
            if chaining[j]:
            # If the item in question equals an element already in chaining (including the first)
                if arr[i] == chaining[j][0]:
                    # Put the ith element in that bucket of chaining
                    chaining[j].append(arr[i])
                    placed = True
                    break
        # If not placed in an existing chain, put into the next empty bucket
        if not placed:
            for j in range(len(chaining)):
                if not chaining[j]:
                    chaining[j].append(arr[i])
                    break
    return chaining

def word_pattern(pattern, s):
    """
    Return True if `s` follows the same bijective mapping as `pattern`.
    """
    s = s.split(" ")
    pattern = list(pattern)
    # From the very beginning, if the length of the pattern and the string don't match, they cannot be equivalent
    if len(pattern) != len(s):
        return False
    # Calculate ordinal values
    calc_ords(pattern)
    calc_ords(s)
    # Run each array through the hash function that uses chaining (not probing)
    pattern = chaining_function(pattern)
    s = chaining_function(s)
    # If the shapes of the arrays match, the pattern and string follow the same bijective mapping
    return (len(pattern) == len(s)) and ([len(sublist) for sublist in pattern] == [len(sublist) for sublist in s])
    


print(word_pattern(pattern, s))
