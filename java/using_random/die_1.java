// Using the StdRandom library to roll a die

import stdlib.StdOut;
import stdlib.StdRandom;

public class Die {
    public static void main(String[] args) {
        // Get a random integer using the StdRandom library
        int value = StdRandom.uniform(1, 7);
        String output;
        // Depending on what the int is, print a series of stars, using \n to make a grid
        if (value == 1) {
            output = "     \n  *  \n     ";
            StdOut.println(output);
        }
        else if (value == 2) {
            output = "*    \n     \n    *";
            StdOut.println(output);
        }
        else if (value == 3) {
            output = "    *\n  *  \n    *";
            StdOut.println(output);
        }
        else if (value == 4) {
            output = "*   *\n     \n*   *";
            StdOut.println(output);
        }
        else if (value == 5) {
            output = "*   *\n  *  \n*   *";
            StdOut.println(output);
        }
        else if (value == 6) {
            output = "* * *\n     \n* * *";
            StdOut.println(output);
        }
        else
            StdOut.println("");
    }
}

