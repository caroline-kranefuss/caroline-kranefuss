import stdlib.StdIn;
import stdlib.StdOut;

public class EditDistance {
    // Entry point.
    public static void main(String[] args) {
        // read and print the genetic code strings given as input
        String x = StdIn.readString();
        StdOut.println(x);
        String y = StdIn.readString();
        StdOut.println(y);
        // create variables to signify the length of m and n; print them
        int m = GSA.length(x);
        int n = GSA.length(y);
        stdlib.StdOut.println(m + " " + n);
        // create a blank array to hold the Needleman-Wunsch array contents
        int[][] opt = new int[m + 1][n + 1];
        // set the rightmost column to show the "score" of gaps going up and up; each is set to the equation shown within the for loop
        for (int i = 0; i <=m; i++) {
            opt[i][n] = 2 * (m - i);
        }
        // set the bottom row to show the score of gaps going left and left
        for (int j = 0; j <=n; j++) {
            opt[m][j] = 2 * (n - j);
        }
        // now fill in the rest of the array
        // do this so that opt[i + 1][j + 1], opt[i + 1][j], and opt[i][j + 1] are all computed before opt[i][j] is computed (dynamic programming)
        // Count backwards because we're starting at the right or at the bottom and moving left/up
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // if the characters in the strings are equal, take the minimum of the scores above, below, and diagonally above, adding two for any gaps
                if (GSA.charAt(x,i) == GSA.charAt(y,j)) {
                    opt[i][j] = Math.min(opt[i + 1][j + 1],(Math.min(opt[i + 1][j] + 2, opt[i][j + 1] + 2)));
                }
                // else, do the same thing but add a score of 1 to the diagonal movement
                else {
                    opt[i][j] = Math.min(opt[i + 1][j + 1] + 1,(Math.min(opt[i + 1][j] + 2, opt[i][j + 1] + 2)));
                }
            }
        }
        for (int i = 0; i <= m; i ++) {
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
