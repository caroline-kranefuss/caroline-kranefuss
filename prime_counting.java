// Write a program called PrimeCounter.java that accepts n (int) as command-line argument
// and writes to standard output the number of primes less than or equal to n.

import stdlib.StdOut;

public class PrimeCounter {
    public static void main(String[] args) {
        // Accept n (int) as a command-line argument
        int n = Integer.parseInt(args[0]);
        // Create a boolean array
        boolean[] isPrime = new boolean[n + 1];
        // In a for loop, set everything equal to true instead of false; start at first prime 2
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        // Another for loop to set each multiple of the ith element as false, since those aren't prime
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                // Class said to do n/1 but that didn't make sense to me, so I just said n
                for (int j = 2; i * j <= n ; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        // Create a count variable and count the number of times
        int count = 0;
        // Start at 2, the first prime number
        for (int i = 2; i <= n; i++) {
            // If isPrime is true, return 1, which increments the counter
            count += isPrime[i] ? 1 : 0;
        }
        StdOut.println(count);
    }
}

