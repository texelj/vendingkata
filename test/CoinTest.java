import com.texel.Coin;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jacob on 5/4/2018.
 */
public class CoinTest {
    @Test
    public void WhenQuarterUsed(){
        Coin quarter = Coin.QUARTER;
        assertEquals(5.6,quarter.mass());
        assertEquals(24.3,quarter.diameter());
    }
}
