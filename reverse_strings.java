// Write a program called Reverse.java that accepts strings from standard input,
// and writes them in reverse order to standard output.

import stdlib.StdIn;
import stdlib.StdOut;

public class Reverse {
    // Entry point.
    public static void main(String[] args) {
        // Accept all strings from standard input
        String[] a = StdIn.readAllStrings();
            // Calculate the length of the array
            int n = a.length;
            // Create a for loop, go to n/2 because every time you swap the first half with the second half
            // So by the time you get halfway through, you've swapped everything
            for (int i = 0; i < n / 2; i++) {
                // Use a temp variable to store a[i], otherwise those values will be lost
                String t = a[i];
                a[i] = a[n - i - 1];
                a[n - i - 1] = t;
            }
            // Create a for loop, this time going to n, to print all characters
            for (int i = 0; i < n; i++) {
                if (i < (n - 1)) {
                    StdOut.print(a[i] + " " );
                }
                else {
                    StdOut.println(a[i]);
                }
            }
        }
    }
