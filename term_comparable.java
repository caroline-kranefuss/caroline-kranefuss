import dsa.Quick;

import java.util.Comparator;

import stdlib.In;
import stdlib.StdOut;

public class Term implements Comparable<Term> {
    // instance variables
    private String query;
    private long weight;

    // Constructs a term given the associated query string, having weight 0.
    public Term(String query) {
        if (query == null) {
            throw new NullPointerException("query is null");
        }
        // this.query refers to the instance variable
        this.query = query;
        // weight starts at 0 if not given a weight
        weight = 0;
    }

    // Constructs a Term given the associated query string and weight.
    public Term(String query, long weight) {
        if (query == null) {
            throw new NullPointerException("query is null");
        }
        if (weight < 0) {
            throw new IllegalArgumentException("Illegal weight");
        }
        this.query = query;
        // set weight if we are given a weight (constructors are same otherwise)
        this.weight = weight;
    }

    // Returns a string representation of this term.
    public String toString() {
        // use \t to get a tab
        return weight + "\t" + query;
    }

    // Returns a comparison of this term and other by query.
    public int compareTo(Term other) {
        // comparing QUERY
        return this.query.compareTo(other.query);
    }

    // Returns a comparator for comparing two terms in reverse order of their weights.
    public static Comparator<Term> reverseWeightOrder() {
        // use a constructor to create an object
        return new ReverseWeightOrder();
    }

    // Returns a comparator for comparing two terms by their prefixes of length r.
    public static Comparator<Term> prefixOrder(int r) {
        if (r < 0) {
            throw new IllegalArgumentException("Illegal r");
        }
        // same but with argument r
        return new PrefixOrder(r);
    }

    // Reverse-weight comparator.
    private static class ReverseWeightOrder implements Comparator<Term> {
        // Returns a comparison of terms v and w by their weights in reverse order.
        public int compare(Term v, Term w) {
            //longs are not comparable so use Long.compare
            return Long.compare(w.weight, v.weight);
        }
    }

    // Prefix-order comparator.
    private static class PrefixOrder implements Comparator<Term> {
        // instance variable, declared at beginning of class
        private int r;
        // Constructs a PrefixOrder given the prefix length.
        PrefixOrder(int r) {
            // initializing the instance variable
            this.r = r;
        }

        // Returns a comparison of terms v and w by their prefixes of length r.
        public int compare(Term v, Term w) {
            // figure out what the two strings we are comparing are
            // string method String(here v.query).substring(0,r)
            // go to r or to the length of v.query, whichever is shorter
            String a = v.query.substring(0, Math.min(r, v.query.length()));
            // repeat for w
            String b = w.query.substring(0, Math.min(r, w.query.length()));
            // return comparison between first and second substring
            return a.compareTo(b);
        }
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
        StdOut.printf("Top %d by lexicographic order:\n", k);
        Quick.sort(terms);
        for (int i = 0; i < k; i++) {
            StdOut.println(terms[i]);
        }
        StdOut.printf("Top %d by reverse-weight order:\n", k);
        Quick.sort(terms, Term.reverseWeightOrder());
        for (int i = 0; i < k; i++) {
            StdOut.println(terms[i]);
        }
    }
}
