// Purpose is to use a union-find data type to calculate the percolation threshold of a system
// Example incudes conductivity of a metal, permeation of water from top layer to bottom layer, etc.
// Using weighted quick union-find data type

import dsa.WeightedQuickUnionUF; // importing weighted-quick union uf, can help with dynamic connectivity too
import stdlib.In;
import stdlib.StdOut;


public class Percolation {
    // Create n, the percolation system size
    int n;
    // Create the percolation system - true means open and false means blocked
    boolean[][] open;
    // create the number of open sites
    int openSites;
    // create Union-find representation of the percolation system; linear structure from 0 to n * n inclusive, size n * n + 2
    // use connected and union methods in this problem
    // use this because don't want to work with n x n array directly - nested for-loops are inefficient
    WeightedQuickUnionUF uf;
    // backwash: first uf to test if percolates, second uf to test if full (no sink in second)
    WeightedQuickUnionUF uf_two;

    private int encode(int i, int j) {
        //Return the uf site (1,2,...,n^2) corresponding to the percolation system site (i, j)
        // use a formula to convert the 2D element into an 1D array
        // source and sink are not part of this
        return n * i + j + 1;
    }

    // Constructs an n x n percolation system, with all sites blocked.
    public Percolation(int n) {
        // n is already given to us from readInt in main
        if (n <= 0) {
            // throw an error if n <= 0 since the system size can't be zero or negative
            throw new IllegalArgumentException("Illegal n");
        }
        // initialize n as n
        this.n = n;
        // create the 2D array of sze n x n
        this.open = new boolean[n][n];
        // zero open sites to start i.e. all sites blocked
        this.openSites = 0;
        // instantiate variable uf
        this.uf = new WeightedQuickUnionUF(n * n + 2);
        // second uf, no sink
        this.uf_two = new WeightedQuickUnionUF(n * n + 1);
    }

    // Opens site (i, j) if it is not already open.
    // to work with second uf, inside open method, do same stuff except for sink
    public void open(int i, int j) {
        // time to throw errors!
        // open(), isOpen(), and isFull() should throw an IndexOutOfBoundsException("Illegal i or j") if i or j is outside the interval [0,n−1]
        // throw an error if outside grid or surpassing number of columns or rows
        if (i < 0 || j < 0 || i > this.n - 1 || j > this.n - 1) {
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        if (!this.open[i][j]) {
            // if given site is not open, open it via true (boolean)
            this.open[i][j] = true;
            // increment number of open sites
            this.openSites++;
            // if first row, connect to source
            if (i == 0) {
                uf.union(encode(0, j), 0);
                uf_two.union(encode(0, j), 0);
            }
            // if last row, connect to sink
            if (i == n - 1) {
                uf.union(encode(n - 1, j), n * n + 1);
                // no sink
            }
            // if grid at (i, j) is open (we are at (i,j)), check if neighbor to north is open; if it is, connect; same for EW&S
            // connect it by talking to the uf data structure
            // if north is open and i - 1 is in bounds
            if (i - 1 >= 0 && open[i - 1][j]) {
                // use union to connect
                uf.union(encode(i - 1, j), encode(i, j));
                uf_two.union(encode(0, j), 0);
            }
            //repeat for west
            if (j - 1 >= 0 && open[i][j - 1]) {
                // use union to connect
                uf.union(encode(i, j - 1), encode(i, j));
                uf_two.union(encode(i, j - 1), encode(i, j));
            }
            // repeat for south, keep bounds in mind
            if (i + 1 <= n - 1 && open[i + 1][j]) {
                // use union to connect
                uf.union(encode(i + 1, j), encode(i, j));
                uf_two.union(encode(i, j - 1), encode(i, j));
            }
            // repeat for east
            if (j + 1 <= n - 1 && open[i][j + 1]) {
                // use union to connect
                uf.union(encode(i, j + 1), encode(i, j));
                uf_two.union(encode(i, j + 1), encode(i, j));
            }
        }
    }

    // Returns true if site (i, j) is open, and false otherwise.
    public boolean isOpen(int i, int j) {
        // throw an error if outside grid or surpassing number of columns or rows
        if (i < 0 || j < 0 || i > this.n - 1 || j > this.n - 1) {
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        // check if site is open or not by returning value of this.open[i][j], it'll be true or false
        return this.open[i][j];
    }

    // Returns true if site (i, j) is full, and false otherwise.
    public boolean isFull(int i, int j) {
        // throw an error if outside grid or surpassing number of columns or rows
        if (i < 0 || j < 0 || i > this.n - 1 || j > this.n - 1) {
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        // check if it's open
        // and check if its corresponding uf site is connected to the source
        // start from grid zero, check if it's connected to 0, the source
        return isOpen(i,j) && uf.connected(encode(i,j), 0) ;
    }

    // Returns the number of open sites.
    public int numberOfOpenSites() {
        return this.openSites;
    }

    // Returns true if this system percolates, and false otherwise.
    public boolean percolates() {
        // only do this for i bc we've converted from 2D to 1D array
        // if source is connected to sink
        if (uf.connected(n * n + 1, 0)) {
            return true;
        }
        else {
            return false;
        }
    }

}
