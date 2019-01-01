/** this class determines whether a word is
 * palindrome or not.
 * @author DELL
 */
public class Palindrome {

    /** method that put every character in a word in
     * a node in a Deque by the natural order.
     * @param word word that are to be divided  into single characters
     * @return Deque that contains every character of the word given
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<Character>();
        char item;
        if (word == null) {
            return null;
        } else {
            for (int i = 0; i < word.length(); i++) {
                item = word.charAt(i);
                d.addLast(item);
            }
            return d;
        }
    }

    /** method that determines whether a word is a palindrome,
     * if so returns true, otherwise returns false.
     * @param word the word given to be determined
     * @return true or false
     */
    public boolean isPalindrome(String word) {
        Deque<Character> origin = wordToDeque(word);
        return isEqual(origin);
    }

    /** helper method that runs recursively to determine whether
     * the characters at two ends are the same for a given word.
     * @param d input deque that contains characters of a single word
     * @return true if the characters at two ends are the same
     */
    private boolean isEqual(Deque<Character> d) {
        if (d.isEmpty() || d.size() == 1) {
            return true;
        }
        char f = d.removeFirst();
        char l = d.removeLast();
        return f == l && isEqual(d);
    }

    /** method that determines whether a word is a off-by-one palindrome,
     * if so returns true, otherwise returns false.
     * @param word the word given to be determined
     * @param cc  off-by-n comparator
     * @return true or false
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> origin = wordToDeque(word);
        return isEqual(origin, cc);
    }

    /** helper method that runs recursively to determine whether
     * the characters at two ends are off-by-one for a given word.
     * @param d input deque that contains characters of a single word
     * @param cc  off-by-n comparator
     * @return true if the characters at two ends are the same
     */
    private boolean isEqual(Deque<Character> d, CharacterComparator cc) {
        if (d.isEmpty() || d.size() == 1) {
            return true;
        }
        char f = d.removeFirst();
        char l = d.removeLast();
        return cc.equalChars(f, l) && isEqual(d, cc);
    }
}


