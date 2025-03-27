# From MIT Course 6.006 Introduction to Algorithms:
# Instructors: Erik Demaine, Jason Ku, and Justin Solomon
# MIT OpenCourseWare
# https://ocw.mit.edu

# Problem 0-6. An increasing subarray of an integer array is any consecutive sequence of array integers whose values strictly increase. 
# Write Python function count long subarrays(A) which accepts Python Tuple A=(a0,a1,...,an−1) of n> 0 positive integers, 
# and returns the number of longest increasing subarrays of A, i.e., the number of increasing subarrays with length at least as large as every other increasing subarray. 
# For example, if A = (1,3,4,2,7,4,5,6,9,8,3), your program should return 2 since the maximum length of any increasing subarray of A is three and there are two increasing subarrays with that length: specifically, subarrays (1,3,4) and (5,6,9). 

def count_long_subarrays(A):
    # define variables: 
        # the length of A, a temp list to store  values, the number of subarrays, and the length of the previous longest array (start at 1)
    n = len(A)
    temp = []
    num_subarrays = 0
    # start by appending the first element to temp
    temp.append(A[0])
    # the current longest length is 1
    length = 1

    for i in range(1, n - 1):
        # if the number following the previous one is bigger, append it to temp and increment num_subarrays
        if A[i] > A[i - 1]:
            temp.append(A[i])
            # if this is longer than the length of the longest array so far, update the length of the longest array so far
            if len(temp) > length:
                length = len(temp)
            print("length is", length, "and temp is", temp)
        # if not
        else:
            # if len(temp) > length, store that size for future reference so that all future subarrays are that length or longer
            if len(temp) > length:
                length = len(temp)
                # start over on the number of subarrays
                num_subarrays = 1
            if len(temp) == length:
                # add to the number of subarrays
                num_subarrays+=1
                print("num_subarrays is", num_subarrays)
            # clear the temp list
            temp.clear()
            # add the index that we were just working with so it's present for the next iteration of the for loop
            temp.append(A[i])
    
    return(num_subarrays)
    
def main():
    A = (1,3,4,2,7,4,5,6,9,8,3)
    print(count_long_subarrays(A))

if __name__ == "__main__":
    main()
