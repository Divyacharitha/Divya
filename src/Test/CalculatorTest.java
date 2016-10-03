package Test;

import company.Calculator;
import company.Item;
import company.Order;
import company.OrderLine;
import junit.framework.TestCase;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Calculator Test case
 */
public class CalculatorTest extends TestCase {

    /**
     * Test case for calculating taxes of empty orders
     * @throws Exception
     */
    public void testCalculateEmptyOrders() throws Exception {
        Calculator calculator = new Calculator();
        assert calculator.calculateOrdersTotal(null) == 0;
        System.out.println("Test Succeeded!");

    }

    /**
     * Test case for sum of orders
     * @throws Exception
     */
    public void testCalculate3Orders() throws Exception {
        Map<String, Order> allOrders = new HashMap<String, Order>();
        double grandTotal = 0.0;
        DecimalFormat df = new DecimalFormat();
        Calculator calculator = new Calculator();
        //Build Order 1
        Order order1 = new Order();
        order1.add(new OrderLine(new Item("book", (float) 12.49), 1));
        order1.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
        order1.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));
        allOrders.put("Order 1", order1);

        //Build Order 2
        Order order2 = new Order();
        order2.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
        order2.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));
        allOrders.put("Order 2", order2);

        //Build Order 3
        Order order3 = new Order();
        order3.add(new OrderLine(new Item("imported bottle of perfume", (float) 27.99), 1));
        order3.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
        order3.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
        order3.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));
        allOrders.put("Order 3", order3);

        //Calculate Order Total and Taxes
        grandTotal=calculator.calculateOrdersTotal(allOrders);
        assertEquals(153.81,grandTotal,0.05);
        System.out.println("Test Succeeded!");

    }
}