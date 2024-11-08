import stdlib.StdOut;

public class Rational {
    private long x; // create x
    private long y; // create y

    // Constructs a rational number whose numerator is x and denominator is 1.
    public Rational(long x) {
        // set this.x equal to x
        this.x = x;
        // set this.y to 1 as an initial denominator
        this.y = 1;
    }

    // Constructs a rational number given its numerator x and denominator y.
    public Rational(long x, long y) {
        long gcd = gcd(x, y);
        this.x = x / gcd;
        this.y = y / gcd;
    }

    // Returns the sum of this rational number and other.
    public Rational add(Rational other) {
        // rule is that a/b + c/d = (ad+bc)/bd; do this with x, y
        // create a numerator and a denominator variable
        long num = (this.x * other.y + this.y * other.x);
        long den = this.y * other.y;
        return new Rational(num, den);
    }

    // Returns the product of this rational number and other.
    public Rational multiply(Rational other) {
        // rule is that a/b × c/d = ac/bd
        // create a product variable and initialize it to zero
        long num = (this.x * other.x);
        long den = (this.y * other.y);
        return new Rational(num, den);
    }

    // Returns true if this rational number is equal to other, and false otherwise.
    public boolean equals(Object other) {
        // false if other is null
        if (other == null) {
            return false;
        }
        // true if other and this are equal
        if (other == this) {
            return true;
        }
        // if the class of other and this are not the same, return false
        if (other.getClass() != this.getClass()) {
            return false;
        }
        // Rationals a/b and c/d are equal iff a == c and b == d.
        Rational a = this, b = (Rational) other;
        //check whether the fraction is equal or not
        return a.x == b.x && a.y == b.y;
    }

    // Returns a string representation of this rational number.
    public String toString() {
        long a = this.x, b = this.y;
        if (a == 0 || b == 1) {
            return a + "";
        }
        if (b < 0) {
            a *= -1;
            b *= -1;
        }
        return a + "/" + b;
    }

    // Returns gcd(p, q), computed using Euclid's algorithm.
    private static long gcd(long p, long q) {
        return q == 0 ? p : gcd(q, p % q);
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Rational total = new Rational(0);
        Rational term = new Rational(1);
        for (int i = 1; i <= n; i++) {
            total = total.add(term);
            term = term.multiply(new Rational(1, 2));
        }
        StdOut.printf("1 + 1/2 + 1/4 + ... + 1/2^%d = %s\n", n, total);
    }
}
