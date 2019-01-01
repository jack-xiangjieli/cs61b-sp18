/** this is a interface of Deque that lists the
 * method in both ArrayDeque and LinkedListDeque.
 * @author DELL
 * @since 2019/1/1
 */
public interface Deque<T> {
    /**  add an item.
      * @param item to add
     */
    void addFirst(T item);

    /** add an item.
     * @param item to add
     */
    void addLast(T item);

    /** check whether is empty.
     * @return true if empty
     */
    boolean isEmpty();

    /** return the size.
     * @return the size
     */
    int size();

    /** print. */
    void printDeque();

    /** remove the first item.
     * @return item to be removed
     */
    T removeFirst();

    /** remove the last item.
     * @return item to be removed
     */
    T removeLast();

    /** get the item given the index.
     * @param index the index of the item
     * @return the item
     */
    T get(int index);
}
