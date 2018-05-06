import com.texel.*;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
        assertEquals("PRICE 1.00",vend.readDisplay());
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
        assertEquals("PRICE 1.00",vend.readDisplay());
        assertEquals("0.25",vend.readDisplay());
    }

    @Test
    public void WhenProductChipsSelectedWithNoMoneyAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.selectProduct(Product.CHIPS);
        assertEquals("PRICE 0.50",vend.readDisplay());
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
        assertEquals("PRICE 0.50",vend.readDisplay());
        assertEquals("0.25",vend.readDisplay());
    }

    @Test
    public void WhenProductCandySelectedWithNoMoneyAndDisplayRead(){
        VendingMachine vend = new VendingMachine();
        vend.selectProduct(Product.CANDY);
        assertEquals("PRICE 0.65",vend.readDisplay());
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
        assertEquals("PRICE 0.65",vend.readDisplay());
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

    @Test
    public void WhenProductSelectedAndNickelReturned(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.NICKEL);
        assertEquals("0.55",vend.readDisplay());
        assertArrayEquals(vend.selectProduct(Product.CHIPS), new Coin[]{Coin.NICKEL});
    }

    @Test
    public void WhenProductSelectAndDimesReturned(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.DIME);
        vend.insertCoin(Coin.DIME);
        assertEquals("0.70",vend.readDisplay());
        assertArrayEquals(vend.selectProduct(Product.CHIPS), new Coin[]{Coin.DIME,Coin.DIME});
    }

    @Test
    public void WhenProductSelectAndQuartersReturned(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        assertEquals("1.00",vend.readDisplay());
        assertArrayEquals(vend.selectProduct(Product.CHIPS), new Coin[]{Coin.QUARTER,Coin.QUARTER});
    }

    @Test
    public void WhenProductSelectedAndOneEachCoinReturned(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.DIME);
        vend.insertCoin(Coin.NICKEL);
        assertEquals("0.90",vend.readDisplay());
        assertArrayEquals(vend.selectProduct(Product.CHIPS), new Coin[]{Coin.QUARTER,Coin.DIME,Coin.NICKEL});
    }

    @Test
    public void WhenReturnChangeWithNoCoinsInserted(){
        VendingMachine vend = new VendingMachine();
        assertArrayEquals(vend.returnCoins(),new Coin[]{});
    }

    @Test
    public void WhenReturnCoinsOneOfEachAndReadDisplay(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.DIME);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.NICKEL);
        assertArrayEquals(vend.returnCoins(), new Coin[]{Coin.QUARTER,Coin.DIME,Coin.NICKEL});
        assertEquals("INSERT COIN",vend.readDisplay());
    }

    @Test
    public void WhenCoinReturnMultipleOfSameCoin(){
        VendingMachine vend = new VendingMachine();
        vend.insertCoin(Coin.DIME);
        vend.insertCoin(Coin.DIME);
        vend.insertCoin(Coin.DIME);
        assertArrayEquals(vend.returnCoins(), new Coin[]{Coin.DIME,Coin.DIME,Coin.DIME});
        assertEquals("INSERT COIN",vend.readDisplay());
    }

    @Test
    public void WhenSoldOutAndNoCoinsInsertedAndDisplayCheckedTwice(){
        VendingMachine vend = new VendingMachine(new ProductStock(0));
        vend.selectProduct(Product.COLA);
        assertEquals(vend.readDisplay(),"SOLD OUT");
        assertEquals(vend.readDisplay(),"INSERT COIN");
    }

    @Test
    public void WhenSoldOutAndCoinsInsertedAndDisplayCheckedTwice(){
        VendingMachine vend = new VendingMachine(new ProductStock(0));
        vend.insertCoin(Coin.QUARTER);
        vend.selectProduct(Product.COLA);
        assertEquals(vend.readDisplay(),"SOLD OUT");
        assertEquals(vend.readDisplay(),"0.25");
    }

    @Test
    public void WhenLastItemSoldAndSelectProductAndDisplayReadTwice(){
        VendingMachine vend = new VendingMachine(new ProductStock(1));
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.selectProduct(Product.COLA);
        vend.selectProduct(Product.COLA);
        assertEquals(vend.readDisplay(),"SOLD OUT");
        assertEquals(vend.readDisplay(),"INSERT COIN");
    }

    @Test
    public void WhenCannotMake5centChange(){
        VendingMachine vend = new VendingMachine(new CoinStock(0));
        assertEquals(vend.readDisplay(), "EXACT CHANGE ONLY");
    }

    @Test
    public void WhenCannotMake10CentChange(){
        CoinStock stock = new CoinStock(0);
        VendingMachine vend = new VendingMachine(stock);
        stock.addStock(Coin.NICKEL,1);
        stock.addStock(Coin.QUARTER,1);
        assertEquals("EXACT CHANGE ONLY", vend.readDisplay());
    }

    @Test
    public void WhenCannotMake15CentChange(){
        CoinStock stock = new CoinStock(0);
        VendingMachine vend = new VendingMachine(stock);
        stock.addStock(Coin.NICKEL,2);
        assertEquals("EXACT CHANGE ONLY", vend.readDisplay());
    }

    @Test
    public void WhenCannotMake20CentChange(){
        CoinStock stock = new CoinStock(0);
        VendingMachine vend = new VendingMachine(stock);
        stock.addStock(Coin.NICKEL,1);
        stock.addStock(Coin.DIME,1);
        assertEquals("EXACT CHANGE ONLY", vend.readDisplay());
        stock.removeStock(Coin.DIME,1);
        stock.addStock(Coin.NICKEL,2);
        assertEquals("EXACT CHANGE ONLY", vend.readDisplay());
    }

    @Test
    public void WhenPurchaseCompleteSoCoinStockIncreases(){
        CoinStock stock = new CoinStock(0);
        VendingMachine vend = new VendingMachine(stock);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.DIME);
        vend.insertCoin(Coin.DIME);
        vend.insertCoin(Coin.NICKEL);
        vend.selectProduct(Product.CHIPS);
        assertEquals(stock.getCoinCount(Coin.QUARTER),1);
        assertEquals(stock.getCoinCount(Coin.DIME),2);
        assertEquals(stock.getCoinCount(Coin.NICKEL),1);
    }

    @Test
    public void WhenPurchaseChangeCauseDecreaseInCoinStock(){
        CoinStock stock = new CoinStock(4);
        VendingMachine vend = new VendingMachine(stock);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.insertCoin(Coin.QUARTER);
        vend.selectProduct(Product.CANDY);
        assertEquals(stock.getCoinCount(Coin.DIME),3);
    }
}
