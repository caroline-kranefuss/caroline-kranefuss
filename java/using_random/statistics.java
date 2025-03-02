// Accept a (int) and b (int) as commandline arguments
// Generate three random doubles (x1,x2, and x3), each from the interval [a,b)
// Compute their mean, variance, and standard deviation and print
// Accept a (int) and b (int) as commandline arguments
// Generate three random doubles (x1,x2, and x3), each from the interval [a,b)
// Compute their mean, variance, and standard deviation and print

import stdlib.StdOut;
import stdlib.StdRandom;

public class Stats {
    public static void main(String[] args) {
        // from the two command-line arguments given, convert to doubles and name a and b
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        // create an empty array of doubles of size three to store the random doubles we will compute
        double[] xes = new double[3];
        // use a for loop to generate three doubles
        for (int i = 0; i < 3; i ++) {
            xes[i] = StdRandom.uniform() * (b - a) + a;;
        }
        // then name the doubles generated
        double x1 = xes[0], x2 = xes[1], x3 = xes[2];
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
