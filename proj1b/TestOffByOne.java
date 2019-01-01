import org.junit.Test;
import org.junit.Assert;

public class TestOffByOne {

    /** initialize a comparator. */
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars(){
        Assert.assertTrue(offByOne.equalChars('a', 'b'));
    }

}
