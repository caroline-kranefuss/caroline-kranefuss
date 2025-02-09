// Write a program called Transpose.java that accepts m (int) and n (int) as command-line arguments,
// m×n doubles from standard input representing the elements of an m × n matrix a,
// and writes to standard output the transpose of a.

import stdlib.StdIn;
import stdlib.StdOut;

public class Transpose {
    // Entry point.
    public static void main(String[] args) {
        // Accept two CLAs
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        // Create a new array of m x n size
        double[][] a = new double[m][n];
        // Build an array from standard input using nested for loops, one for rows and one for columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readDouble();
            }
        }
        // Make an n x m array c of doubles (n x m since it is transposed)
        double[][] c = new double[n][m];
        // Set c[i][j] to a[j][i]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = a[j][i];
            }
        }
        // Use nested for loops to print each element of the array with an f string
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j < m - 1) {
                    StdOut.printf("%f ", c[i][j]);
                } else {
                    StdOut.printf("%f\n", c[i][j]);
                    }
                }
            }
        }
    }
