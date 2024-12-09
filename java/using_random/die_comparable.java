// Another die roll, this time with the usage of comparable to return true if this die is the same as other, and false otherwise

import stdlib.StdOut;
import stdlib.StdRandom;

public class Die implements Comparable<Die> {
    // value is declared
    private int value; // the face value

    // Constructs a die.
    public Die() {
        // don't need an input because we're making a fair die
        // can have value or this.value in this context
        value = -1;
    }

    // Rolls this die.
    public void roll() {
        // get a random integer from [0, 7)
        value = StdRandom.uniform(1, 7);
    }

    // Returns the face value of this die.
    public int value() {
        // return that value
        return value;
    }

    // Returns true if this die is the same as other, and false otherwise.
    // this is the equals method
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Die a = this, b = (Die) other;
        // return whether a and b are the same
        return a.value == b.value;
    }

    // Returns a string representation of this die.
    public String toString() {
        // Depending on what the int is, print a series of stars, using \n to make a grid
        if (value == 1) {
            return "     \n  *  \n     ";
        }
        else if (value == 2) {
            return "*    \n     \n    *";
        }
        else if (value == 3) {
            return "    *\n  *  \n    *";
        }
        else if (value == 4) {
            return "*   *\n     \n*   *";
        }
        else if (value == 5) {
            return "*   *\n  *  \n*   *";
        }
        else if (value == 6) {
            return "* * *\n     \n* * *";
        }
        else {
            return "Error";
        }
    }

    // Returns a comparison of this die with other, based on their face values.
    public int compareTo(Die other) {
        // use Integer.compare because value is an integer
        return Integer.compare(this.value, other.value);
    }

    // Unit tests the data type
    public static void main(String[] args) {
        Die a = new Die();
        while (a.value() != 3) {
            a.roll();
        }
        Die b = new Die();
        while (b.value() != 5) {
            b.roll();
        }
        Die c = new Die();
        while (c.value() != 3) {
            c.roll();
        }
        StdOut.println("Dice a, b, and c:");
        StdOut.println(a);
        StdOut.println(b);
        StdOut.println(c);
        StdOut.println("a.equals(b)    = " + a.equals(b));
        StdOut.println("a.equals(c)    = " + a.equals(c));
        StdOut.println("a.compareTo(b) = " + a.compareTo(b));
        StdOut.println("a.compareTo(c) = " + a.compareTo(c));
    }
}
