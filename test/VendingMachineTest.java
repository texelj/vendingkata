import com.texel.Coin;
import com.texel.Product;
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

    @Test
    public void WhenProductColaPriceCheckAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.selectProduct(Product.COLA);
        assertEquals("1.00",vend.readDisplay());
        assertEquals("INSERT COIN",vend.readDisplay());
    }

    @Test
    public void WhenProductColaPurchasedAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.selectProduct(Product.COLA);
        assertEquals("THANK YOU",vend.readDisplay());
        assertEquals("INSERT COIN", vend.readDisplay());
    }

    @Test
    public void WhenColaSelectAndNotEnoughMoney(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.QUARTER);
        vend.selectProduct(Product.COLA);
        assertEquals("1.00",vend.readDisplay());
        assertEquals("0.25",vend.readDisplay());
    }

    @Test
    public void WhenProductChipsSelectedWithNoMoneyAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.selectProduct(Product.CHIPS);
        assertEquals("0.50",vend.readDisplay());
        assertEquals("INSERT COIN",vend.readDisplay());
    }

    @Test
    public void WhenProductChipsSelectedWithExactMoneyAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.selectProduct(Product.CHIPS);
        assertEquals("THANK YOU",vend.readDisplay());
        assertEquals("INSERT COIN", vend.readDisplay());
    }

    @Test
    public void WhenProductChipsSelectedWithSomeMoneyAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.QUARTER);
        vend.selectProduct(Product.CHIPS);
        assertEquals("0.50",vend.readDisplay());
        assertEquals("0.25",vend.readDisplay());
    }

    @Test
    public void WhenProductCandySelectedWithNoMoneyAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.selectProduct(Product.CANDY);
        assertEquals("0.65",vend.readDisplay());
        assertEquals("INSERT COIN",vend.readDisplay());
    }

    @Test
    public void WhenProductCandySelectedWithExactMoneyAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.DIME);
        vend.insertCoin(Coin.NICKEL);
        vend.selectProduct(Product.CANDY);
        assertEquals("THANK YOU",vend.readDisplay());
        assertEquals("INSERT COIN", vend.readDisplay());
    }

    @Test
    public void WhenProductCandySelectedWithSomeMoneyAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.QUARTER);
        vend.selectProduct(Product.CANDY);
        assertEquals("0.65",vend.readDisplay());
        assertEquals("0.25",vend.readDisplay());
    }

    @Test
    public void WhenProductSelectedAndNoChangeReturned(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        assertArrayEquals(vend.selectProduct(Product.COLA), new Coin[]{});
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.DIME);
        vend.insertCoin(Coin.NICKEL);
        assertArrayEquals(vend.selectProduct(Product.CANDY), new Coin[]{});
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        assertArrayEquals(vend.selectProduct(Product.CHIPS), new Coin[]{});
    }
}
