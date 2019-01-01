/** off-by-one comparator.
 * @author DELL
 */
public class OffByN implements CharacterComparator {
    /** this integer determines N. */
    private int diff;

    /** constructor of comparator.
     * @param N determines the value to off-by
     * */
    public OffByN(int N) {
        diff = N;
    }

    @Override
    /** returns true if input characters are off-by-n.  */
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == diff;
    }
}
