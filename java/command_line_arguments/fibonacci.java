// Write a program called Fibonacci.java that accepts n (int) as command-line argument,
// and writes to standard output the nth number from the Fibonacci sequence (0,1,1,2,3,5,8,13,...)

import stdlib.StdOut;

public class Fibonacci {
    public static void main(String[] args) {
        // Parse input as an integer
        int n = Integer.parseInt(args[0]);
        // Create two variables that add to one so that they sum to the first term in the Fib function
        // I know the discussion said -1 and 1 but this didn't make sense to me since that would sum to zero
        long a  = 0;
        long b = 1;
        // Create a variable i for a for loop
        int i = 0;
        // Repeat as long as i < n
        // Discussion said i <= to n but I want the nth variable
        // Exchange a with b and b with a + b, using a temp variable to store a
        // increment i by 1
        for (i = 1; i < n; i++) {
            long temp = 0;
            temp = a;
            a = b;
            b = temp + b;
        }
        StdOut.println(b);
    }
}

//
