import com.texel.Coin;
import com.texel.CoinStock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jacob on 5/5/2018.
 */
public class CoinStockTest {
    @Test
    public void WhenCoinStockCreatedVerifyEachCoinHasStock(){
        CoinStock stock = new CoinStock(5);
        for(Coin p: Coin.values()){
            assertEquals(stock.getCount(p), 5);
        }
    }

    @Test
    public void WhenAddCoinStock(){
        CoinStock stock = new CoinStock(5);
        stock.addStock(Coin.QUARTER,3);
        assertEquals(stock.getCount(Coin.QUARTER),8);
    }

    @Test
    public void WhenRemoveCoinStock(){
        CoinStock stock = new CoinStock(5);
        stock.removeStock(Coin.QUARTER, 2);
        assertEquals(stock.getCount(Coin.QUARTER), 3);
    }
}
