import org.junit.Assert;
import org.junit.Test;

public class FibTest {
    @Test
    public void test(){
        Assert.assertEquals(55, Main.fibr(10));
        Assert.assertEquals(13, Main.fibr(7));
        Assert.assertEquals(34, Main.fibr(9));
        Assert.assertEquals(55, Main.fibi(10));
        Assert.assertEquals(13, Main.fibi(7));
        Assert.assertEquals(34, Main.fibi(9));
        long[] tab = {0, 1, 1, 2, 3, 5, 8};
        long[] tab1 = {0};
        long[] tab2 = {0, 1};
        Assert.assertArrayEquals(tab, Main.tabGenerate(6));
        Assert.assertArrayEquals(tab1, Main.tabGenerate(0));
        Assert.assertArrayEquals(tab2, Main.tabGenerate(1));
    }
}
