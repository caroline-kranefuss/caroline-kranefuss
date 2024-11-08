import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.StdStats;

public class PercolationStats {
    // create m, number of independent experiments
    int m;
    // create percolation thresholds for the experiments
    double[] x;

    // Performs m independent experiments on an n x n percolation system.
    public PercolationStats(int n, int m) {
        // check if n and m have appropriate values
        if (n <= 0 || m <= 0) {
            // throw an error if not
            throw new IllegalArgumentException("Illegal n or m");
        }
        // initialize instance variables
        // point towards the m variable defined in the formation of class
        this.m = m;
        // create x
        this.x = new double[m];
        // for loop to create the system and count opened sites
        for(int a = 0; a < m; a++){
            // creating n x n percolation system
            Percolation sys = new Percolation(n);
            while(!sys.percolates()){
                // choose a random site until the system percolates
                // row number
                int i = StdRandom.uniform(0, n);
                // column number
                int j = StdRandom.uniform(0, n);
                // open the site and increment the counter if it is closed
                // don't need if statement because it's already filtering
                sys.open(i,j);
                }
            // calculate the percolation threshold as ratio of sites opened
            // store that in x
            // calling method on sys
            x[a] = (double) sys.numberOfOpenSites() / (n*n);
        }

    }

    // Returns sample mean of percolation threshold.
    public double mean() {
        return StdStats.mean(x);
    }

    // Returns sample standard deviation of percolation threshold.
    public double stddev() {
        return StdStats.stddev(x);
    }

    // Returns low endpoint of the 95% confidence interval.
    public double confidenceLow() {
        return StdStats.mean(x) - (1.96 * StdStats.stddev(x) / Math.sqrt(m));
    }

    // Returns high endpoint of the 95% confidence interval.
    public double confidenceHigh() {
        return StdStats.mean(x) + (1.96 * StdStats.stddev(x) / Math.sqrt(m));
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, m);
        StdOut.printf("Percolation threshold for a %d x %d system:\n", n, n);
        StdOut.printf("  Mean                = %.3f\n", stats.mean());
        StdOut.printf("  Standard deviation  = %.3f\n", stats.stddev());
        StdOut.printf("  Confidence interval = [%.3f, %.3f]\n", stats.confidenceLow(), stats.confidenceHigh());
    }
}
