import stdlib.StdOut;

public class StrangeMatrix {
    // Entry point
    public static void main(String[] args) {
        // Get m and n as CLAs
        int m =Integer.parseInt(args[0]);
        int n =Integer.parseInt(args[1]);
        // Create an empty m x n matrix of doubles named a
        int[][] a = new int[m][n];
        // For loop to a(i,n − 1) (ie, last column of a) to m −i−1, for 0 ≤ i < m
        for (int i = 0; i < m; i++) {
            a[i][n - 1] = m - i - 1;
        }
        // For loop to set a(m −1,j) (ie, last row of a) to n−j −1, for 0 ≤ j < n,
        for (int j = 0; j < n; j++) {
            a[m - 1][j] = n - j - 1;
        }
        // Nested for loop to set a(i,j) to a(i,j + 1) + a(i + 1,j +1)+a(i+1,j), for 0 ≤ i < m−1 and 0 ≤ j < n−1
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                a[i][j] = a[i][j + 1] + a[i + 1][j +1] +a[i+1][j];
            }
        }
        // Outside previous for loops, write the matrix to StdOut using stdio.writef() and nested for loops
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If j < n−1, write a[i][j] with the format string "%5d "
                if (j < n - 1) {
                    StdOut.printf("%5d ", a[i][j]);
                }
                // otherwise, write a[i][j] with the format string "%5d\n"
                else {
                    StdOut.printf("%5d\n", a[i][j]);
                }
            }
        }
    }
}
