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
            assertEquals(stock.getCoinCount(p), 5);
        }
    }
}
