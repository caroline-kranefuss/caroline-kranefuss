// Another way to randomly roll a die

import stdlib.StdOut;
import stdlib.StdRandom;

public class Die {
    private int value; // the face value, private variable

    // Constructs a die, must be public as a constructor
    public Die() {
        // Constructs it with face value -1 of instance variable value
        this.value = -1;
    }

    // Rolls this die.
    public void roll() {
        // Roll the die by choosing a random integer
        this.value = StdRandom.uniform(1, 7);
    }

    // Returns the face value of this die.
    public int value() {
        return this.value;
    }

    // Returns true if this die is the same as other, and false otherwise.
    public boolean equals(Object other) {
        // return true if this die and other have the same value
        if (other == this) {
            return true;
        }
        // returns false if other is null
        if (other == null) {
            return false;
        }
        // returns false if the classes of other and this are the same
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Die a = this, b = (Die) other;
        return a.value == b.value;
    }

    // Returns a string representation of this die.
    public String toString() {
        // print a series of stars, using \n to make a grid
        if (value == 1) {
            return "     \n  *  \n     ";
        } else if (value == 2) {
            return "*    \n     \n    *";
        } else if (value == 3) {
            return "    *\n  *  \n    *";
        } else if (value == 4) {
            return "*   *\n     \n*   *";
        } else if (value == 5) {
            return "*   *\n  *  \n*   *";
        } else if (value == 6) {
            return "* * *\n     \n* * *";
        } else {
            return "Error";
        }
    }

}
