// Program that writes to standard output all integers less than or equal to n that can be expressed as the sum of two cubes in two different ways.
// In other words, find distinct positive integers a, b, c, and d such that a cubed + b cubed = c cubed + d cubed ≤ n.

import stdlib.StdOut;

public class RamanujanNumbers {
    public static void main(String[] args) {
        // Parse input as an integer
        int n = Integer.parseInt(args[0]);
        // Use Math.pow to cube a and go for as long as it's less than or equal to n
        for (int a = 0; Math.pow(a,3) <= n; a++){
            // Within that cube b and go for as long as it's less than or equal to n - a cubed
            for(int b = a + 1; Math.pow(b,3) <= n - a*a*a; b++){
                // Within that cube c and go for as long as it's less than or equal to n
                for (int c = a + 1; Math.pow(c,3) <= n; c++){
                    // Create an int d and go for as long as it's less than or equal to n - c cubed
                    for (int d = c + 1; Math.pow(d,3) <= n - c*c*c; d++){
                        // Create your ramanujan numbers
                        int ramanujan_1 = (int) (Math.pow(a,3) + Math.pow(b,3));
                        int ramanujan_2 =  (int) (Math.pow(c,3) + Math.pow(d,3));
                        // If they are equal
                        if (ramanujan_1 == ramanujan_2){
                            // Print the answer in the proper format
                            String answer = (ramanujan_1 + " = " + a + "^3" + " + " + b + "^3" + " = " + c + "^3"+ " + " + d + "^3");
                            StdOut.println(answer);
                        }
                    }
                }
            }
        }
    }
}

