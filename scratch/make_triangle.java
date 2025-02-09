// Write a program called Triangle.java that accepts x (int), y (int), and z (int) as commandline arguments,
// and writes true to standard output if each one of them is less than or equal to the sum of the other two, and false otherwise.

import stdlib.StdOut;

public class Triangle {
    public static void main(String[] args) {
        // Get input and parse as an integer
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        // Calculate if each one of them is less than OR equal to the sum of the other two
        // Create a flag outside the if statements
        int flag = 0;
        // Flag each one as zero or one depending on the answer
        if (x <= y + z) {
            flag += 1;
        }
        if (y <= z + x) {
            flag += 1;
        }
        if (z <= x + y) {
            flag += 1;
        }
        // If the flag was changed to one at every point, print true
        if (flag == 3) {
            StdOut.println("true");
            // Else print false
        } else {
            StdOut.println("false");
        }
    }
}
