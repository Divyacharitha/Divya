package company;

/**
 * represents an order line which contains the @link Item and the quantity.
 */
public class OrderLine {

    /**
     * @Param item Item of the order
     *
     * @Param quantity Quantity of the item
     */

    private Item item;
    private int quantity;

    public OrderLine(Item item, int quantity) throws Exception  {
        if (item == null) {
            System.err.println("ERROR - Item is NULL");
            throw new Exception("Item is NULL");
        }
        if (quantity <= 0) {
            System.err.println("ERROR - Quantity should be greater than zero");
            throw new Exception("Quantity is less than or equal to zero");
        }
        this.quantity = quantity;
        this.item = item;
    }

    /**
     *
     * @return Item item of the order
     */
    public Item getItem()    {
        return item;
    }

    /**
     *
     * @return quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }
}