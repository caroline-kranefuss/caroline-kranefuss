// Write a program called Fibonacci.java that accepts n (int) as command-line argument,
// and writes to standard output the nth number from the Fibonacci sequence (0,1,1,2,3,5,8,13,...).

import stdlib.StdOut;

public class Factorial {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // Start with result at zero
        long result = 1;
        // Create a for loop to set result to result * 1
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        // Print answer outside the for loop
        StdOut.println(result);
    }
}
