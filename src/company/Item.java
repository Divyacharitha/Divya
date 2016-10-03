package company;

/**
 * represents an item, contains a price and a description.
 */
public class Item {

    /**
     * @Param description description of an item
     *
     * @Param price price of an item
     */
    private String description;
    private float price;

    public Item(String description, float price) {
        this.description = description;
        this.price = price;
    }

    /**
     *
     * @return description description of an item
     */
        public String getDescription() {
        return description;
    }

    /**
     *
     * @return price price of an item
     */
    public float getPrice() {
        return price;
    }
}