import com.texel.VendingMachine;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jacob on 5/4/2018.
 */
public class VendingMachineTest {
    @Test
    public void WhenNoCoinsEntered(){
        VendingMachine vend = new VendingMachine();
        assertEquals("INSERT COIN", vend.readDisplay());
    }
}
