// Calculating the edit distance of two given genes
// Edit distance is a procedure to "measure the similarity between two DNA sequences by counting the minimum number of single-character edits required to transform one sequence into the other" (https://bmcmedgenomics.biomedcentral.com/articles/10.1186/s12920-017-0279-9#:~:text=Edit%20distance%20is%20a%20well,be%20shared%20in%20a%20plaintext."
// This is an example of creating matrices

import stdlib.StdArrayIO;
import stdlib.StdIn;
import stdlib.StdOut;

public class Alignment {
    // Entry point.
    public static void main(String[] args) {
        // Read strings x and y from standard input
        String x = StdIn.readString();
        String y = StdIn.readString();
        int m = GSA.length(x);
        int n = GSA.length(y);
        // Read the edit-distance matrix opt from standard input; it will be m + 1 by n x 1; print it
        int[][] opt = StdArrayIO.readInt2D();
        StdOut.println(opt[0][0]);
        // Write the edit distance
            // This actually isn't asked for, don't so so
        // int editDistance = opt[0][0];
        // Create i and j - for some reason, I can't do it inside the while loop, maybe this is just while loop convention
        int i = 0;
        int j = 0;
        // Create a penalty variable - don't do this
        //int penalty = 0;
        // For loop to recover and output the optimal alignment
        while (i < m && j < n) {
            if (opt[i][j] == opt[i + 1][j] + 2) {
                // Align x and - and penalty of 2
                StdOut.println(GSA.charAt(x, i) + " - " + "2");
                i++;
                //penalty += 2;
            }
            else if (opt[i][j] == opt[i][j + 1] + 2) {
                // Align y and - and penalty of 2; trial and error to figure out how to align the spaces
                StdOut.println("- " + GSA.charAt(y, j) + " 2");
                j++;
                //penalty += 2;
            }
            else {
                int z = 0;
                if (GSA.charAt(x, i) != GSA.charAt(y, j)) {
                    // They're not equal
                    z = 1;
                }
                // Just print both next to each other
                StdOut.println(GSA.charAt(x, i) + " " + GSA.charAt(y, j) + " " + z);
                i++;
                j++;
            }
        }
        // While loop if x is exhausted before y
        while (i < m) {
            // Align x and - and penalty of 2
            StdOut.println(GSA.charAt(x, i) + " - " + "2");
            i++;
            //penalty += 2;
        }
        // Vice versa
        while (j < n) {
            // Align y and - and penalty of 2
            StdOut.println("- " + GSA.charAt(y, i) + " 2");
            j++;
            //penalty+= 2;
        }
    }
}
