// Write a program called PerfectNumbers.java that accepts n (int) as command-line argument,
// and writes to standard output the perfect numbers that are less than or equal to n.

import stdlib.StdOut;

public class PerfectNumbers {
    public static void main(String[] args) {
        // Get input
        int n = Integer.parseInt(args[0]);
        // For loop for each int within 2 and n
        // Set total to zero
        for (int i = 2; i <= n; i++) {
            // Total variable here to eventually sum all the factors; inside for loop to reset total after every new number
            int total = 0;
            // Nested for loop to check for factors
            for (int j = 1; j < i; j++) {
                // If j divides i, increment total by j
                if (i % j == 0) {
                    total += j;
                }
            }
            // Outside for loop, print i if it equals the total
            if (total == i) {
                StdOut.println(i);
            }
        }
    }
}
