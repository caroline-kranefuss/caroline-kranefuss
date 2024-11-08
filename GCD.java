import stdlib.StdOut;
import java.io.*;
import java.util.*;

public class GCD {
    public static void main(String[] args) {
        // Get two integers based on command line arguments
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        // Create a while loop and check if p mod q is equal to 0
        // We want a remainder so the while loop eventually has an end
        // As long as it isn't equal to zero, swap p with q and q with p mod q
        while (p % q != 0) {
            int temp = 0;
            temp = p;
            p = q;
            q = temp % q;
        }
        StdOut.println(q);
    }
}
