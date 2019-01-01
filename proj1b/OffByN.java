/** off-by-one comparator. */
public class OffByN implements CharacterComparator{
    /** this integer determines N. */
    private int diff;

    /** constructor of comparator. */
    public OffByN(int N) {
        diff = N;
    }

    @Override
    /** returns true if input characters are off-by-n.  */
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == diff;
    }
}
