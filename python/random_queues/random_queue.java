// Creating a random queue to resize an array; generic (ie no application)

import java.util.Iterator;
import java.util.NoSuchElementException;


import stdlib.StdOut;
import stdlib.StdRandom;

// A data type to represent a random queue, implemented using a resizing array as the underlying
// data structure.
public class ResizingArrayRandomQueue<T> implements Iterable<T> {
    // instance variables
    private T [] q;
    private int n;

    // Constructs an empty random queue.
    @SuppressWarnings("unchecked")
    public ResizingArrayRandomQueue() {
        // create array of size 2
        q = (T[]) new Object[2];
        // initialize n as 0
        n = 0;
    }

    // Returns true if this queue is empty, and false otherwise.
    public boolean isEmpty() {
        // if number of items is 0, return true to mean it is empty
        return n == 0;
    }

    // Returns the number of items in this queue.
    public int size() {
        // n is the size of the queue
        return n;
    }

    // Adds item to the end of this queue.
    public void enqueue(T item) {
        // throw an error
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        // if it's full
        if (n == q.length) {
            //resize
            resize(2*q.length);
        }
        // insert given item in q at index n and increment n by one
        q[n++] = item;
    }

    // Returns a random item from this queue.
    public T sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Random queue is empty");
        }

        int r =  StdRandom.uniform(0,n);
        return q[r];
    }

    // Removes and returns a random item from this queue.
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Random queue is empty");
        }
        // save q[r] in item
        int r = StdRandom.uniform(0,n);
        T item = q[r];
        // set q[r] to q[n- 1] and q[n- 1] to null
        q[r] = q[n- 1];
        q[n- 1] = null;
        // decrement n by one
        n--;
        // resizing
        if (n > 0 && n==q.length / 4){
            resize(q.length/2);
        }
        return item;
    }

    // Returns an independent iterator to iterate over the items in this queue in random order.
    public Iterator<T> iterator() {
        // return an iterator
        return new RandomQueueIterator();
    }

    // Returns a string representation of this queue.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : this) {
            sb.append(item);
            sb.append(", ");
        }
        return n > 0 ? "[" + sb.substring(0, sb.length() - 2) + "]" : "[]";
    }

    // An iterator, doesn't implement remove() since it's optional.
    private class RandomQueueIterator implements Iterator<T> {
        // array to store items of q
        T[] items;
        // index of the current item in items
        int current;

        public RandomQueueIterator() {
            // create items with capacity n
            items = (T[]) new Object[n];
            // copy the n items from q into items
            for (int i = 0; i < n; i++) {
                items[i] = q[i];
            }
            // shuffle items
            StdRandom.shuffle(items);
            // initialize current
            current = 0;
        }

        // Returns true if there are more items to iterate, and false otherwise.
        public boolean hasNext() {
            // if current is less than length, return true
            return this.current < items.length;
        }

        // Returns the next item.
        public T next() {
            // exception if there is no next/iterator is empty
            if (!hasNext()){
                throw new NoSuchElementException("Iterator is empty");
            }
            // return the next item
            return items[current++];
        }
    }

    // Resizes the underlying array.
    @SuppressWarnings("unchecked")
    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < n; i++) {
            if (q[i] != null) {
                temp[i] = q[i];
            }
        }
        q = temp;
    }

    // Unit tests the data type.
    public static void main(String[] args) {
        ResizingArrayRandomQueue<Integer> q = new ResizingArrayRandomQueue<Integer>();
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            int r = StdRandom.uniform(10000);
            q.enqueue(r);
            sum += r;
        }
        int iterSumQ = 0;
        for (int x : q) {
            iterSumQ += x;
        }
        int dequeSumQ = 0;
        while (q.size() > 0) {
            dequeSumQ += q.dequeue();
        }
        StdOut.println("sum       = " + sum);
        StdOut.println("iterSumQ  = " + iterSumQ);
        StdOut.println("dequeSumQ = " + dequeSumQ);
        StdOut.println("iterSumQ + dequeSumQ == 2 * sum? " + (iterSumQ + dequeSumQ == 2 * sum));
    }
}
