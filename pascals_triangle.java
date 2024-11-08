import stdlib.StdOut;

public class Pascal {
    // Entry point.
    public static void main(String[] args) {
        //Get a CLA n
        int n = Integer.parseInt(args[0]);
        // Initialize a ragged array
        int[][] Pn = new int[n + 1][];
        // Fill the # of columns for each row with a for loop
        for (int i = 0; i <= n; i++) {
            Pn[i] = new int[i + 1];
            // Set Pn[i][j] to 1 for each int j from 0 to n inclusive
            for (int j = 0; j <= i; j++) {
                Pn[i][j] = 1;
            }
        }
        // Make a nested for loop to fill the array
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                Pn[i][j] = Pn[i - 1][j - 1] + Pn[i - 1][j];
            }
        }
        // Print the array
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < i) {
                    StdOut.print(Pn[i][j] + " ");
                }
                else {
                    StdOut.println(Pn[i][j]);
                }
            }
        }
    }
}
