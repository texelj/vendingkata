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

    @Test
    public void WhenDimeUsed(){
        Coin dime = Coin.DIME;
        assertEquals(2.3,dime.mass());
        assertEquals(17.9,dime.diameter());
    }

    @Test
    public void WhenNickelUsed(){
        Coin nickel = Coin.NICKEL;
        assertEquals(5.0,nickel.mass());
        assertEquals(21.2,nickel.diameter());
    }

    @Test
    public void WhenPennyUsed(){
        Coin penny = Coin.PENNY;
        assertEquals(2.5,penny.mass());
        assertEquals(19.1,penny.diameter());
    }
}
