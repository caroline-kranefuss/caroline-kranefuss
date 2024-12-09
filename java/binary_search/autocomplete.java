// Goal: write a program to implement autocomplete feature
// for a given set of n strings and non-negative weights;
// ie, given a prefix,
// find all strings in the set that start with the prefix,
// in descending order of weight
// Example of my use of binary search

import dsa.Quick;

// added this to make a copy of terms
import java.util.Arrays;
import java.util.Comparator;


import stdlib.In;
import stdlib.StdIn;
import stdlib.StdOut;

public class Autocomplete {
    // instance variable is terms
    private Term[] terms;

    // Constructs an Autocomplete data structure from an array of terms.
    public Autocomplete(Term[] terms) {
        // if there are no terms given
        if (terms == null) {
            throw new NullPointerException("terms is null");
        }
        // initialize this.terms to a defensive copy (ie, a fresh copy and not an alias) of terms
        this.terms = Arrays.copyOf(terms, terms.length);
        // sort this.terms in lexicographic order using quick sort
        // implement quick sort on this.terms so we can use binary search deluxe
        Quick.sort(this.terms);

    }

    // Returns all terms that start with prefix, in descending order of their weights.
    public Term[] allMatches(String prefix) {
        // if there is no prefix given, need an exception
        if (prefix == null) {
            throw new NullPointerException("prefix is null");
        }
        // find the index of the first term in terms that starts with prefix using the binary search deluxe and term.java that we made
        // can assign weight to be anything, here I've picked 0
        int first_Index = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.prefixOrder(prefix.length()));
        // do same for lat index
        int last_Index = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), Term.prefixOrder(prefix.length()));
        // check if we've found anything from binary search; if nothing, return an empty array
        if (first_Index == -1 || last_Index == -1) {
            return new Term[0];
        }
        // create a variable to count the size of the array we found from binary search
        int size = last_Index - first_Index + 1;
        // create a new array Term of similar size
        Term[] search_results = new Term[size];
        // construct an array search_results containing n elements from terms, starting at i
        for (int i = 0; i < size; i++) {
            search_results[i] = terms[first_Index + i];
        }
        // sort array in reverse order
        Quick.sort(search_results, Term.reverseWeightOrder());
        // return the array
        return search_results;
    }

    // Returns the number of terms that start with prefix.
    public int numberOfMatches(String prefix) {
        // similar concept for this next method
        // start with exception if there is no prefix given
        if (prefix == null) {
            throw new NullPointerException("prefix is null");
        }
        // find the index of the first and last terms starting with the prefix using binary search
        int first_Index = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.prefixOrder(prefix.length()));
        int last_Index = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), Term.prefixOrder(prefix.length()));
        // return 0 if no match is found
        if (first_Index == -1) {
            return 0;
        }
        // return number of terms
        return last_Index - first_Index + 1;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        int k = Integer.parseInt(args[1]);
        In in = new In(filename);
        int n = in.readInt();
        Term[] terms = new Term[n];
        for (int i = 0; i < n; i++) {
            long weight = in.readLong();
            in.readChar();
            String query = in.readLine();
            terms[i] = new Term(query.trim(), weight);
        }
        Autocomplete autocomplete = new Autocomplete(terms);
        StdOut.print("Enter a prefix (or ctrl-d to quit): ");
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            String msg = " matches for \"" + prefix + "\", in descending order by weight:";
            if (results.length == 0) {
                msg = "No matches";
            } else if (results.length > k) {
                msg = "First " + k + msg;
            } else {
                msg = "All" + msg;
            }
            StdOut.printf("%s\n", msg);
            for (int i = 0; i < Math.min(k, results.length); i++) {
                StdOut.println("  " + results[i]);
            }
            StdOut.print("Enter a prefix (or ctrl-d to quit): ");
        }
    }
}
