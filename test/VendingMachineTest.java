import com.texel.Coin;
import com.texel.VendingMachine;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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

    @Test
    public void WhenNickelInsertedIntoMachineAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.NICKEL);
        assertEquals("0.05",vend.readDisplay());
    }

    @Test
    public void WhenPennyInsertedIntoMachineAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.PENNY);
        assertEquals("INSERT COIN", vend.readDisplay());
    }

    @Test
    public void WhenCoinInsertedAndReturnedOrNot(){
        VendingMachine vend = new VendingMachine();
        assertArrayEquals(vend.insertCoin(Coin.QUARTER), new Coin[]{});
        assertArrayEquals(vend.insertCoin(Coin.DIME),new Coin[]{});
        assertArrayEquals(vend.insertCoin(Coin.NICKEL),new Coin[]{});
        assertArrayEquals(vend.insertCoin(Coin.PENNY),new Coin[]{Coin.PENNY});
    }
}
