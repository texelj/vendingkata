import com.texel.Product;
import com.texel.ProductStock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jacob on 5/5/2018.
 */
public class ProductStockTest {
    @Test
    public void WhenProductStockCreatedVerifyEachProductHasStock(){
        ProductStock stock = new ProductStock(5);
        for(Product p: Product.values()){
            assertEquals(stock.getProductCount(p), 5);
        }
    }


}
