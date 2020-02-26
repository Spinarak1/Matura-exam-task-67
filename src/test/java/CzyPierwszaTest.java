import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CzyPierwszaTest {
    @Test
    public void test(){
        Assert.assertEquals(true, Main.czyPierwsza(7));
        Assert.assertEquals(false, Main.czyPierwsza(10));
        Assert.assertEquals(true, Main.czyPierwsza(13));
        Assert.assertEquals(false, Main.czyPierwsza(20));
        Assert.assertEquals(false, Main.czyPierwsza(21));
    }
    @Test
    public void test2(){
        ArrayList<Long> list = new ArrayList<Long>();
        list.add(2L);
        list.add(3L);
        list.add(5L);
        list.add(13L);
        Assert.assertEquals(list, Main.zad672(10));
    }
}
