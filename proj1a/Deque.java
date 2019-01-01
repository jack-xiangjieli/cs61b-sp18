/** this is a interface of Deque that lists the
 * method in both ArrayDeque and LinkedListDeque.
 * @author DELL
 * @since 2019/1/1
 */
public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    boolean isEmpty();
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
}
