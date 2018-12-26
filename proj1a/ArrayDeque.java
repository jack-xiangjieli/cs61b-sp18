/** ArrayDeque is the deque that uses
 * array as the core data structure.
 * @author DELL nerdlee
 * @since 2018/12/26
 * @version 1.0
 */
public class ArrayDeque<T> {
    /* an instance variable that caches the size of the array. */
    private int size;
    /* instance variable that points to the index of
       a position that will store the next first item. */
    private int nextfirst = 0;

    /* instance variable that points to the index of
      a position that will store the next last item. */
    private int nextlast = 1;

    /* declare an array that will be the basic data structure. */
    private T[] a;

    /* constructor of an empty ArrayDeque. */
    public ArrayDeque() {
        a = (T[])new Object[8];
        size = 0;
    }

    /** method that returns the size of the ArrayDeque. */
    public int size() {
        return size;
    }

    /** method that checks whether the deque is empty. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** method that resize the deque if the size gets larger
    than the length of the array.
     */
    private void resize( ) {
        T[] b = (T[])new Object[a.length+1];
        System.arraycopy(a,0,b,0,nextlast);
        if (nextlast <= size - 1) {
            int sp = nextlast + 2;
            int dp = nextlast + 3;
            int len = size - nextlast;
            System.arraycopy(a, sp, b, dp, len);
        }
        a = b;
    }

    /** method that adds an item in front of the
    previous ArrayDeque.
     @param item  the item to be added to the ArrayDeque.
     */
    public void addFirst(T item) {
        if(size >= a.length - 2) {
            resize();
            if (nextfirst != 0) {
                nextfirst += 1;
            }
        }
        a[nextfirst] = item;
        if (nextfirst == 0) {
            nextfirst = a.length - 1;
        } else {nextfirst = nextfirst - 1;}

        size += 1;
    }

    /** method that adds an item in the end of
    the previous ArrayDeque.
    @param item  the item to be added to the ArrayDeque.
     */
    public void addLast(T item) {
        if (size >= a.length - 2) {
            resize();
            if (nextlast != size + 1) {
                nextfirst += 1;
            }
        }
        a[nextlast] = item;
        if (nextlast == a.length - 1) {
            nextlast = 0;
        }else {nextlast += 1;}

        size += 1;
    }

    /** method that removes the first item
    of the ArrayDeque and output the item removed.
     */
    public T removeFirst() {
        if (size == 0){
            return null;
        }
        T output;
        if (nextfirst == a.length - 1) {
            output = a[0];
            a[0] = null;
            nextfirst = 0;
        } else {
            output = a[nextfirst + 1];
            a[nextfirst + 1] = null;
            nextfirst += 1;
        }
        size -= 1;
        return output;
    }

    /** method that removes the last item
    of the ArrayDeque and output the item removed.
     */
    public T removeLast() {
        if(size == 0){
            return null;
        }
        T output;
        if (nextlast == 0) {
            output = a[a.length - 1];
            a[a.length - 1] = null;
            nextlast = a.length - 1;
        } else {
            output = a[nextlast - 1];
            a[nextlast - 1] = null;
            nextlast -= 1;
        }
        size -= 1;
        return output;
    }

    /** method that prints the item of
    the ArrayDeque by order.
     */
    public void printDeque() {
        int index = nextfirst + 1;
        for (int i = 0; i<size; i++){
            if (index == a.length) {
                index = 0;
            }
            System.out.print(a[index]+" ");
            index += 1;
        }
    }

    /** method that get the item of a
    ArrayDeque given the index.
     @param index the index of the item in the ArrayDeque.
     */
    public T get(int index) {
        if(index > size-1) {
            return null;
        }
        else if (index <= a.length-nextfirst - 2) {
            return a[index + nextfirst + 1];
        }
        else {
            return a[index + nextfirst + 1 - a.length];
        }
    }

}
