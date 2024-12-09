// A program to check the edit distance as defined in the other program in this folder

import stdlib.StdIn;
import stdlib.StdOut;

public class EditDistance {
    // Entry point.
    public static void main(String[] args) {
        // Read strings x and y from standard input, make each an array of strings
        String x = StdIn.readString();
        String y = StdIn.readString();
        int m = GSA.length(x);
        int n = GSA.length(y);
        // Create an empty array called opt of dimension m + 1 x n + 1
        int[][] opt = new int[m + 1][n + 1];
        // Rightmost column is 2(m - i)
        for (int i = 0; i <= m; i++) {
            opt[i][n] = 2 * (m - i);
        }
        // Bottommost row is 2(n - j)
        for (int j = 0; j <= n; j++) {
            opt[m][j] = 2 * (n - j);
        }
        // Create a nested for loop to calculate the rest of opt[i][j] in the right order
        // so that opt[i + 1][j + 1], opt[i + 1][j], and opt[i][j + 1] are all computed before opt[i][j] is computed
        // Count backwards because we're starting at the right or at the bottom and moving left/up
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (GSA.charAt(x,i) == GSA.charAt(y,j)) {
                    opt[i][j] = Math.min(opt[i + 1][j + 1], Math.min(opt[i + 1][j] + 2, opt[i][j + 1] + 2));
                }
                else {
                    opt[i][j] = Math.min(opt[i + 1][j + 1] + 1, Math.min(opt[i + 1][j] + 2, opt[i][j + 1] + 2));
                }
            }
        }
        // Print x, y, m, and n
        StdOut.println(x);
        StdOut.println(y);
        StdOut.println((m + 1) + " " + (n + 1));
        // Print the array
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == n) {
                    StdOut.printf("%3d\n", opt[i][j]);
                }
                else {
                    StdOut.printf("%3d ", opt[i][j]);
                }
            }
        }
    }
}
