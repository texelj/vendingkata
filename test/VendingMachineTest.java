import com.texel.Coin;
import com.texel.VendingMachine;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jacob on 5/4/2018.
 */
public class VendingMachineTest {
    @Test
    public void WhenNoCoinsEnteredAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        assertEquals("INSERT COIN", vend.readDisplay());
    }

    @Test
    public void WhenQuarterInsertedAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.QUARTER);
        assertEquals("0.25",vend.readDisplay());
    }

    @Test
    public void WhenDimeInsertedIntoMachineAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.DIME);
        assertEquals("0.10",vend.readDisplay());
    }
}
