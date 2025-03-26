# From MIT Course 6.006 Introduction to Algorithms:
# Instructors: Erik Demaine, Jason Ku, and Justin Solomon
# MIT OpenCourseWare
# https://ocw.mit.edu

# Problem 0-6. An increasing subarray of an integer array is any consecutive sequence of array integers whose values strictly increase. 
# Write Python function count long subarrays(A) which accepts Python Tuple A=(a0,a1,...,an−1) of n> 0 positive integers, 
# and returns the number of longest increasing subarrays of A, i.e., the number of increasing subarrays with length at least as large as every other increasing subarray. 
# For example, if A = (1,3,4,2,7,5,6,9,8), your program should return 2 since the maximum length of any increasing subarray of A is three and there are two increasing subarrays with that length: specifically, subarrays (1,3,4) and (5,6,9). 

def count_long_subarrays(A):
    # define variables: 
        # the length of A, a list to store the first sequence, a temp list to store subsequent values, the number of subarrays, and the size of that first subarray
    n = len(A)
    first_sequence = []
    temp = []
    num_subarrays = 0
    # start by appending the first element to temp
    first_sequence.append(A[0])
    temp.append(A[0])

    # THIS IS THE FIRST ITERATION OF THE CODE TO FIND THE LENGTH OF THE FIRST SEQUENCE
    # add elements to the temp array one by one
    # but first check if the next number is greater than the previous number
    # if it is, store it in temp
    # going from 0 to the length of A
    for i in range(0, n - 1):
        if i == 0:
            pass
        # if the number following the previous one is bigger, append it to temp and increment num_subarrays
        elif A[i] > A[i - 1]:
            first_sequence.append(A[i])
        # if not
        elif A[i] <= A[i - 1]:            
            size_first_sequence = len(first_sequence)
            # no need to clear the first_sequence array because we will not be using it again
            # exit the for loop
            break
    
    # THIS IS FOR EVERY OTHER ITERATION OF THE CODE EXCEPT THE LAST
    for i in range(0, n - 1):
        if i == 0:
            pass
        # if the number following the previous one is bigger, append it to temp and increment num_subarrays
        elif A[i] > A[i - 1]:
            temp.append(A[i])
        # if not
        elif A[i] <= A[i - 1]:
            # if len(temp) > size_subarray one, store that size for future reference so that all future subarrays are that length or longer
            if len(temp) >= size_first_sequence:
                num_subarrays+=1
            else:
                pass
            # clear the temp list
            temp.clear()
            # add the index that we were just working with so it's present for the next iteration of the for loop
            temp.append(A[i])

        
    # THIS IS FOR THE LAST ITERATION OF THE CODE: need to account for if the last item in the tuple has been reached
    for i in range(n - 2, n - 1):
        if A[i + 1] > A[i]:
            temp.append(A[i + 1])
            # now we count here if the length of temp is >= size_first_sequence and increment num_subarrays
            if len(temp) >= size_first_sequence:
                num_subarrays+=1
            else:
                pass
        elif A[i + 1] <= A[i]:
            # if len(temp) > size_subarray one, store that size for future reference so that all future subarrays are that length or longer
            if len(temp) >= size_first_sequence:
                num_subarrays+=1
            else:
                pass
    
    return(num_subarrays)
    
def main():
    A = (1,3,4,2,7,5,6,9,8)
    print(count_long_subarrays(A))

if __name__ == "__main__":
    main()
