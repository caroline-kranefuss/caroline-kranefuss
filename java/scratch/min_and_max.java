// Implement a library called MinMax
// with functions min() and max()
// that each accept a reference
// first to the first node in a linked list of integers
// and return the minimum and the maximum values respectively.

import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.StdStats;

public class MinMax {
    // Returns the minimum value in the given linked list.
    public static int min(Node first) {
        // start with the biggest possible value
        int min = Integer.MAX_VALUE;
        // for each Node in the linked list first where x is not null
        for (Node x = first; x != null; x = x.next) {
            // so that eventually you find min
            if (x.item < min) {
                // set min equal to x.item;
                min = x.item;
            }
        }
        // return min since that's what we're looking for
        return min;
    }

    // Returns the maximum value in the given linked list.
    public static int max(Node first) {
        // start with the smallest possible value
        int max = Integer.MIN_VALUE;
        // for each Node in the linked list first where x is not null
        for (Node x = first; x != null; x = x.next) {
            // so that you eventually find max
            if (x.item > max) {
                // set max equal to x.item;
                max = x.item;
            }
        }
        // return max since that's what we're looking for
        return max;
    }

    // A data type to represent a linked list. Each node in the list stores an integer item and a
    // reference to the next node in the list.
    protected static class Node {
        protected int item;  // the item
        protected Node next; // the next node
    }

    // Unit tests the library
    public static void main(String[] args) {
        int[] items = new int[1000];
        for (int i = 0; i < 1000; i++) {
            items[i] = StdRandom.uniform(-10000, 10000);
        }
        Node first = null;
        for (int item : items) {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
        }
        StdOut.println("min(first) == StdStats.min(items)? " + (min(first) == StdStats.min(items)));
        StdOut.println("max(first) == StdStats.max(items)? " + (max(first) == StdStats.max(items)));
    }
}
