// Creating a binary search deluxe class

import dsa.Quick;

import java.util.Comparator;

import stdlib.In;
import stdlib.StdOut;

public class BinarySearchDeluxe {
    // Returns the index of the first key in a that equals the search key, or -1, according to the order induced by
    // the comparator c.
    public static <T> int firstIndexOf(T[] a, T key, Comparator<T> c) {
        // exception comes at beginning ie if any argument is null
        if (a == null || key == null || c == null) {
            throw new NullPointerException("a, key, or c is null");
        }
        // initialize index to -1
        int index = -1;
        // initialize hi and lo
        int lo = 0;
        int hi = a.length - 1;
        // as long as lo is less than hi
        while (lo <=  hi) {
            // assign/create mid
            int mid = lo  + ((hi - lo) / 2);
            // create a comparator variable and assign it to comparison of key and a[mid]
            int comparator = c.compare(key, a[mid]);
            // if the comparator returns a negative value
            if (comparator < 0) {
                hi  = mid - 1;
            }
            else if (comparator > 0) {
                lo = mid + 1;
            }
            else {
                // keep looking for more occurrences of the key bc you may not find the first index on the first time
                hi = mid - 1;
                index = mid;
            }
        }
        // return index instead of mid
        return index;
    }

    // Returns the index of the last key in a that equals the search key, or -1, according to the order induced by
    // the comparator c.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> c) {
        // exception comes at beginning ie if any argument is null
        if (a == null || key == null || c == null) {
            throw new NullPointerException("a, key, or c is null");
        }
        // initialize index to -1
        int index = -1;
        // initialize hi and lo
        int lo = 0;
        int hi = a.length - 1;
        // as long as lo is less than hi
        while (lo <=  hi) {
            // assign/create mid
            int mid = lo  + ((hi - lo) / 2);
            // create a comparator variable and assign it to comparison of key and a[mid]
            int comparator = c.compare(key, a[mid]);
            // if the comparator returns a negative value
            if (comparator < 0) {
                hi  = mid - 1;
            }
            else if (comparator > 0) {
                lo = mid + 1;
            }
            else {
                // now we want the last index, so change to lo = mid + 1
                lo = mid + 1;
                index = mid;
            }
        }
        // return index instead of mid
        return index;
    }

}
