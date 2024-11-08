import java.util.Iterator;
import stdlib.StdOut;

// An immutable data type to systematically iterate over the first n primes.
public class Primes implements Iterable<Integer> {
    private int n; // need first n primes

    // Constructs a Primes object given the number of primes needed.
    public Primes(int n) {
        // initialize n
        this.n = n;
    }

    // Returns an iterator to iterate over the first n primes.
    public Iterator<Integer> iterator() {
        // class Iterator has a method iterator() from the Iterator interface, returns PrimesIterator object (which is an Iterator object)
        return new PrimesIterator();
    }

    // Primes iterator.
    private class PrimesIterator implements Iterator<Integer> {
        private int count; // number of primes returned so far
        private int p;     // current prime

        // Constructs an iterator.
        public PrimesIterator() {
            // start count at zero
            count = 0;
            // start current prime at 2
            p = 2;
        }

        // Returns true if there are any more primes to be iterated, and false otherwise.
        public boolean hasNext() {
            // if count is less than n, there are still primes to go
            if (count < n) {
                return true;
            }
            else {
                return false;
            }
        }

        // Returns the next prime.
        public Integer next() {
            // if p is not prime, increment p by one; as long as (in discussion) indicates while loop needed
            while (!isPrime(p)) {
                p++;
            }
            // then increment count by one and return p (must be outside if statement) and increment by one
            count++;
            return p++;
        }

        // Returns true if x is a prime, and false otherwise.
        private boolean isPrime(int x) {
            // start at first prime 2, go to x / i because we don't need to test multiples of numbers already tested
            for (int i = 2; i <= x / i; i++) {
                // if x is divisible by a number i, it is not prime
                if (x % i == 0) {
                    return false;
                }
            }
            // else it's prime and return true
            return true;
        }
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i : new Primes(n)) {
            StdOut.println(i);
        }
    }
}
