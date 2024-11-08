// Write a program called Stats.java that accepts a (int) and b (int) as commandline arguments,
// generates three random doubles (x1,x2, and x3), each from the interval [a,b),
// computes their mean µ = (x1 +x2 +x3)/3, variance var = ((x1 −µ)2 +(x2 −µ)2 +(x3 −µ)2)/3, and standard deviation σ = √var,
// and writes those values to standard output, separated by a space.

import stdlib.StdOut;
import stdlib.StdRandom;

public class Stats {
    public static void main(String[] args) {
        // Get input as integers
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        // Generate random doubles from a inclusive to b exclusive. StdRandom.uniform makes sure that doubles are generated
        double x1 = StdRandom.uniform() * (b - a) + a;
        double x2 = StdRandom.uniform() * (b - a) + a;
        double x3 = StdRandom.uniform() * (b - a) + a;
        // Calculations
        double mu = (x1 + x2 + x3) / 3;
        // More calculations using pow for squared
        double var = (Math.pow(x1 - mu, 2) + Math.pow(x2 - mu, 2) + Math.pow(x3 - mu, 2)) / 3;
        // Take square root
        double sig = Math.sqrt(var);
        // Print variance and sigma
        StdOut.println(mu + " " + var + " " + sig);
    }
}
