import org.junit.Test;
import org.junit.Assert;

public class TestOffByOne {

    /** initialize a comparator. */
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        Assert.assertFalse(offByOne.equalChars('a', 'B'));
    }
}
