package company;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents Order containing a list of orderLines.
 */
public class Order {

    private List<OrderLine> orderLines = new ArrayList<OrderLine>();


    /**
     * Method that adds OrderLine to list of orderlines.
     * @param  o
     * @throws Exception
     */
    public void add(OrderLine o) throws Exception {
        if (o == null) {
            System.err.println("ERROR - Order is NULL");
            throw new IllegalArgumentException("Order is NULL");
        }
        orderLines.add(o);
    }

    /**
     *
     * @return size(number of orderLines).
     */
    public int size() {
        return orderLines.size();
    }



    public OrderLine get(int i) {
        return orderLines.get(i);
    }

    /**
     * clears the orderlines
     */
    public void clear() {
        this.orderLines.clear();

    }

    public Order clone(){
        Order currentOrder = new Order();
        for(OrderLine s:this.orderLines){
            try {
                currentOrder.add(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return currentOrder;

    }
}

