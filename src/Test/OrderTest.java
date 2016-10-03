package Test;

import company.Calculator;
import company.Item;
import company.Order;
import company.OrderLine;
import junit.framework.TestCase;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

/**
 *
 * Order Test case
 */
public class OrderTest extends TestCase{


    /**
     * Test case to find Correct Exception type is thrown
     * @throws Exception
     */
    public void testEmptyOrderLines() throws Exception {
        Order o1 = new Order();
        try {
            OrderLine o =null;
            o1.add(o);
            fail("IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
            assertSame(ex.getClass(),IllegalArgumentException.class );

        }
    }


}
