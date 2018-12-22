/*create  a LinkedListDeque which can expand in length without limit */
public class LinkedListDeque<T>{

    /* create a nested class IntList */
    private class IntList{
        private IntList front;
        private T item;
        private IntList next;

        private IntList(IntList f, T i, IntList n){
            front = f;
            item = i;
            next = n;
        }
    }

    private IntList sentinel;
    private int size;

    /*  constructor of LinkedListDeque*/
    public LinkedListDeque(){
        sentinel = new IntList(null, null, null);
        size = 0;
    }

    /* utility method to add a item in the front of the deque. */
    public void addFirst(T item){
        if(size == 0){
            sentinel.next = new IntList(sentinel, item, sentinel);
            sentinel.front = sentinel.next;
        } else {
            sentinel.next = new IntList(sentinel, item, sentinel.next);
            sentinel.next.next.front = sentinel.next;
        }
        size += 1;
    }

    /** utility method that can  add an item
    in the end of the deque.*/

    public void addLast(T a){
        if(size == 0){
            sentinel.front = new IntList(sentinel, a, sentinel);
            sentinel.next = sentinel.front;
        } else {
            sentinel.front = new IntList(sentinel.front, a, sentinel);
            sentinel.front.front.next = sentinel.front;
        }
        size += 1;
    }

    /** helper method determining whether a deque
    is empty or not. If empty, return true, otherwise false */
    public boolean isEmpty(){
        return this.size( ) == 0;
    }

    /* method that returns the size of the deque */
    public int size(){
        if(size < 0){
            return 0;
        }
        return size;
    }

    /* method that prints the element of deque in order */
    public void printDeque ( ) {
        IntList p = sentinel.next;
        for(int i = 0; i < this.size(); i++){
            System.out.print(p.item+" ");
            p = p.next;
        }
    }

    /* method that removes the first item of a deque */
    public T removeFirst(){
        if(sentinel.next == null){
            return null;
        }
        IntList p = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.front = sentinel;
        size -= 1;
        return p.item;

    }

    /* method that removes the last item of a deque */
    public T removeLast(){
        if(sentinel.front == null){
            return null;
        }
        T result = sentinel.front.item;
        sentinel.front = sentinel.front.front;
        sentinel.front.next = sentinel;
        size -= 1;
        return result;
    }

    /* method that returns an item given the index of that item */
    public T get(int index){
        if(index > size-1 || index < 0){
            return null;
        }
        IntList p = sentinel.next;
        for(int i = 0; i < index; i++){
            p = p.next;
        }
        return p.item;
    }

    /* methods that returns the items with specific index recursively */

    public T getRecursive(int index){
        if (index > size - 1 || index < 0 ){
            return null;
        }
        if(index == 0){
            return sentinel.next.item;
        }
        return getRecursive(index - 1);
    }
}
