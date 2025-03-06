// Creating a generic linked deque class

import java.util.Iterator;
import java.util.NoSuchElementException;

import stdlib.StdOut;
import stdlib.StdRandom;

// has previous and next unlike a linked list

// A data type to represent a double-ended queue (aka deque), implemented using a doubly-linked
// list as the underlying data structure.
public class LinkedDeque<T> implements Iterable<T> {
    // reference the front of the deque
    private Node first;
    // reference the back of the deque
    private Node last;
    // size of the deque
    private int n;

    // Constructs an empty deque.
    public LinkedDeque() {
        // Inside of the constructor, there should be no mention of items at all. The constructor should create something that is completely empty, not even have empty nodes, just empty.
        // initializing instance variables
        //first = null;
        //last = null;
        //n = 0;
    }

    // Returns true if this deque is empty, and false otherwise.
    public boolean isEmpty() {
        return n==0;
    }

    // Returns the number of items in this deque.
    public int size() {
        // return n, the size
        return n;
    }

    // Adds item to the front of this deque.
    public void addFirst(T item) {
        // exceptions come at the beginning
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        // creating a variable called oldFirst; another name for first
        Node oldFirst = first;
        // assigning first to a new Node; first now points at the new Node that is empty
        first = new Node();
        // item references the item from the argument (this.item would reference an instance variable)
        first.item = item;
        first.next = oldFirst;
        // If this is the first item that is being added (ie ieEmpty() is true), both first and last must point to the same node
        if (isEmpty()) {
            // last = first because first has the value
            last = first;
        }
        else {
            oldFirst.prev = first;
        }
        // increment n by one
        // If you increment n++ and later check for empty it will never be 0.
        // Either you check for empty before incrementing n or you increment n and check for n == 1 instead of empty.
        n++;
        // doubly linked list, working with nexts and previouses
        // if it is the first item we're putting in; oldFirst.previous is null --> don't work with oldFirst.previous unless >1 item in there
        // n can never be negative so don't need n > 1

    }

    // Adds item to the back of this deque.
    public void addLast(T item) {
        // exceptions come at the beginning
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        // adding the given item to the back of the deque
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        // use prev instead of next like we did in addFirst
        last.prev = oldLast;
        // If this is the first item that is being added, both first and last must point to the same node
        if (isEmpty()) {
            // first = last because last has the value
            first = last;
        }
        else {
            // next one to oldLast is new last
            oldLast.next = last;
        }
        // increment n by one
        n++;
    }

    // Returns the item at the front of this deque.
    public T peekFirst() {
        // exception at beginning
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        // return first item - first is a node that has an item associated with it
        return first.item;
    }

    // Removes and returns the item at the front of this deque.
    public T removeFirst() {
        // exception comes first, if isEmpty() is true
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        // save whatever item you have as a variable and then return it at the end
        T item = first.item;
        // reference the next node as first
        first = first.next;
        // to remove, go to basic data structures and removing a node from the front is on the slide
        item = first.item;
        // decrement n
        n--;
        // another if statement like in add methods
        if (isEmpty()) {
            last = null;
        }
        // if it's the last item being removed, first and last should both be null
        else {
            first.prev = null;
        }
        // return the item
        return item;
    }

    // Returns the item at the back of this deque.
    public T peekLast() {
        // same thing as first
        // exception at beginning
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return last.item;
    }

    // Removes and returns the item at the back of this deque.
    public T removeLast() {
        // exception comes first, if isEmpty() is true
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        // of type T
        // assigning the item with the item stored in last node
        T item = last.item;
        // referencing the prev node as last
        last = last.prev;
        // decrement n by one
        n--;
        // similar if else statement as removeFirst()
        if (last == null) {
            first = null;
        }
        else {
            last.next = null;
        }
        return item;
    }

    // Returns an iterator to iterate over the items in this deque from front to back.
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    // Returns a string representation of this deque.
    public String toString() {
        String s = "";
        for (T item : this) {
            s += item + ", ";
        }
        return this.isEmpty() ? s + "[]" : "[" + s.substring(0, s.length() - 2) + "]";
    }

    // A deque iterator.
    private class DequeIterator implements Iterator<T> {
        // create a new variable
        private Node current;

        // Constructs an iterator.
        public DequeIterator() {
            // initialize instance variable to the first node
            current = first;
        }

        // Returns true if there are more items to iterate, and false otherwise.
        public boolean hasNext() {
            // if current is not null ie there are more items
            return current != null;
        }

        // Returns the next item.
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Iterator is empty");
            }
            // return current and advance current to the next node
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    // A data type to represent a doubly-linked list. Each node in the list stores a generic item
    // and references to the next and previous nodes in the list.
    private class Node {
        private T item;  // the item
        private Node next;  // the next node
        private Node prev;  // the previous node
    }

}
