/** create  a LinkedListDeque which
 * can expand in length without limit.
 * @author DELL nerdlee;
 * @since 2018/12/22
 * @version 1.0
 */
public class LinkedListDeque<T> {

    /** create a nested class IntList. */
    private class IntList {
        /**  the front of a node. */
        private IntList front;

        /** the item of a node. */
        private T item;

        /** the rest of a node. */
        private IntList next;

        /** constructor of a node.
         * @param f this is the front of the node
         * @param i this is the item of the node
         * @param n this is the next of the node
         */
        private IntList(IntList f, T i, IntList n) {
            front = f;
            item = i;
            next = n;
        }
    }

    /** declare a sentinel node. */
    private IntList sentinel;

    /** declare an int variable that caches the current size.*/
    private int size;

    /** constructor of LinkedListDeque. */
    public LinkedListDeque() {
        sentinel = new IntList(null, null, null);
        size = 0;
    }

    /** utility method to add a item in the front of the deque.
     * @param item  this is the item that we want to add in the front
     * */
    public void addFirst(T item) {
        if (size == 0) {
            sentinel.next = new IntList(sentinel, item, sentinel);
            sentinel.front = sentinel.next;
        } else {
            sentinel.next = new IntList(sentinel, item, sentinel.next);
            sentinel.next.next.front = sentinel.next;
        }
        size += 1;
    }

    /** utility method that can  add an item.
     * @param a  this is the item that we want to add in the end.
     * */
    public void addLast(T a) {
        if (size == 0) {
            sentinel.front = new IntList(sentinel, a, sentinel);
            sentinel.next = sentinel.front;
        } else {
            sentinel.front = new IntList(sentinel.front, a, sentinel);
            sentinel.front.front.next = sentinel.front;
        }
        size += 1;
    }

    /** method determining whether a deque is empty or not. */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /** method that returns the size of the deque. */
    public int size() {
        if (size < 0) {
            return 0;
        }
        return size;
    }

    /** method that prints the element of deque in order. */
    public void printDeque() {
        IntList p = sentinel.next;
        for (int i = 0; i < this.size(); i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /** method that removes the first item of a deque. */
    public T removeFirst() {
        if (sentinel.next == null) {
            return null;
        }
        IntList p = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.front = sentinel;
        size -= 1;
        return p.item;

    }

    /** method that removes the last item of a deque. */
    public T removeLast() {
        if (sentinel.front == null) {
            return null;
        }
        T result = sentinel.front.item;
        sentinel.front = sentinel.front.front;
        sentinel.front.next = sentinel;
        size -= 1;
        return result;
    }

    /** method that returns an item given the index of that item.
     * @param index  this is the index of the item that we want to get
     * */
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        IntList p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    /** methods that returns the items with specific index recursively.
     * @param index  this is the index of the item that we want to get
     * */
    public T getRecursive(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        if (index == 0) {
            return sentinel.next.item;
        }
        return getRecursive(index - 1);
    }
}
