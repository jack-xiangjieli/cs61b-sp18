import org.junit.Test;
import org.junit.Assert;

public class TestOffByN {

    /** initialize a comparator. */
    static CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void testEqualChars(){
        Assert.assertTrue(offBy5.equalChars('a', 'f'));
    }

}