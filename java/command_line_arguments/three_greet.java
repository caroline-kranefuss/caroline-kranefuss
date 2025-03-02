// Prompt: Write a program called GreetThree.java that accepts name1 (String), name2 (String), and name3 (String) as command-line arguments
// and writes the string “Hi name3, name2, and name1.” to standard output.

// Note that solution does not actually assign variables to the command-line arguments given

import stdlib.StdOut;

public class GreetThree {
    public static void main(String[] args) {
        // Start the message
        StdOut.print("Hi ");
        // Print the third name
        StdOut.print(args[2]);
        // Add a comma
        StdOut.print(", ");
        // Print the second name
        StdOut.print(args[1]);
        // Add a comma and an and
        StdOut.print(", and ");
        // Print the first name
        StdOut.print(args[0]);
        // Add a period
        StdOut.println(".");
    }
}
