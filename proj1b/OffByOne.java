/** off-by-one comparator.
 * @author DELL
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
            return Math.abs(x - y) == 1 ;
    }
}
