/** performs some basic tests on ArrayDeque.
 * @author nerdlee
 * @since 2018/12/22
 */
import org.junit.Test;
import org.junit.Assert;

public class ArrayDequeTest {
    @Test
    public void isEmptyTest() {
        ArrayDeque<String> ld = new ArrayDeque();
        boolean actual = ld.isEmpty();
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addFirstSizeTest() {
        ArrayDeque<String> ld=new ArrayDeque();
        String a="a";
        for (int i=0; i<16; i++) {
            ld.addFirst("a"+i);
        }
        int actual=ld.size();
        Assert.assertEquals(16,actual);
    }

    @Test
    public void addLastSizeTest() {
        ArrayDeque<String> ld=new ArrayDeque();
        String a="a";
        for (int i=0; i<16; i++) {
            ld.addFirst("a"+i);
        }
        ld.addLast("b");
        int actual=ld.size();
        Assert.assertEquals(17,actual);
    }

    @Test
    public void removeTest(){
        ArrayDeque<String> ld=new ArrayDeque();
        String a="a";
        for (int i=0; i<16; i++) {
            ld.addFirst("a"+i);
        }
        ld.addLast("b");
        ld.removeFirst();
        ld.removeLast();
        int actual=ld.size();
        Assert.assertEquals(15,actual);
    }

    @Test
    public void getTest(){
        ArrayDeque<String> ld=new ArrayDeque();
        String a="a";
        for (int i=0; i<16; i++) {
            ld.addFirst("a"+i);
        }
        ld.addLast("b");
        ld.removeFirst();
        ld.removeLast();
        Assert.assertEquals("a13",ld.get(6));
    }
}
