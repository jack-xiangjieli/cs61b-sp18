/** This interface defines a method for determining
 *  equality of characters.
 * @author DELL
 * */
public interface CharacterComparator {
    /** Returns true if characters are equal by the rules of the
     * implementing class.
     * @param x input char
     * @param y input char
     * */
    boolean equalChars(char x, char y);
}
