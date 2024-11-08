// Write a program called Distance.java that accepts n (int) as command-line argument,
// two size-n arrays x and y of doubles from standard input,
// and writes to standard output the Euclidean distance between the two vectors represented by x and y.
// The Euclidean distance is calculated as the square root of the sums of the squares of the differences between the corresponding entries.

import stdlib.StdIn;
import stdlib.StdOut;

public class Distance {
    // Entry point
    public static void main(String[] args) {
        // Accept a CLA
        int n = Integer.parseInt(args[0]);
        // Create an empty array of doubles named x
        double[] x = new double[n];
        // of size n
        n = x.length;
        // For each int i, going from 0 inclusive to n exclusive, put the double inputted into the ith position of the array
        for (int i = 0; i < n; i++) {
            x[i] = StdIn.readDouble();
        }
        // Do the same for y
        double[] y = new double[n];
        n = y.length;
        for (int i = 0; i < n; i++) {
            y[i] = StdIn.readDouble();
        }
        // Initialize a sum variable and start it at zero
        double sum = 0;
        // For each int between [0 and n) increment the sum by squaring the difference
        for (int i = 0; i < n; i++) {
            sum += Math.pow((x[i] - y[i]), 2);
        }
        // Take the sqrt of that sum and print it
        double sqrt = Math.sqrt(sum);
        StdOut.println(sqrt);
    }
}
