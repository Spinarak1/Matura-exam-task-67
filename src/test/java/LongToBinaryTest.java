import org.junit.Assert;
import org.junit.Test;

public class LongToBinaryTest {
    @Test
    public void test(){
        Assert.assertEquals("10",Main.longToBinary(2,0));
        Assert.assertEquals("1000", Main.longToBinary(8,0));
        Assert.assertEquals("110111", Main.longToBinary(55,0));
        Assert.assertEquals("00101", Main.longToBinary(5, 5));
    }
}
