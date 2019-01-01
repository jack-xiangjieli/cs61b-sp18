import org.junit.Test;
import org.junit.Assert;

public class TestPalindrome {
    /** You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        Assert.assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertFalse(palindrome.isPalindrome("cat"));
        Assert.assertTrue(palindrome.isPalindrome("radar"));
        Assert.assertTrue(palindrome.isPalindrome("e"));
    }

    @Test
    public void testIsPalindromeInOffByOne() {
        CharacterComparator offByOne = new OffByOne();
        Assert.assertTrue(palindrome.isPalindrome("flake",offByOne));
    }
}
