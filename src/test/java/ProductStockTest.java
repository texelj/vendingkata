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
            assertEquals(stock.getCount(p), 5);
        }
    }

    @Test
    public void WhenProductStockCreatedAndAddProduct(){
        ProductStock stock = new ProductStock(5);
        stock.addStock(Product.COLA, 3);
        assertEquals(stock.getCount(Product.COLA),8);
    }

    @Test
    public void WhenProductStockCreatedAndDecreaseProduct(){
        ProductStock stock = new ProductStock(5);
        stock.removeStock(Product.COLA, 3);
        assertEquals(stock.getCount(Product.COLA),2);
    }
}
