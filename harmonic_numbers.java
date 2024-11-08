import stdlib.StdOut;

public class Harmonic {
    // Entry point.
    public static void main(String[] args) {
        // Accept n as a command-line argument
        int n = Integer.parseInt(args[0]);
        // Hn is a Rational, set it to zero to start
        Rational total = new Rational(0);
        // for loop to create the harmonic number
        for (int i = 1; i <= n; i++) {
            Rational a = new Rational(1, i);
            total = total.add(a);
        }
        StdOut.println(total);
    }
}
