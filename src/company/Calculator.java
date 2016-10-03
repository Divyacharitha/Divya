package company;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;


public class Calculator {

     /**
     * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
     * is the item's price * quantity * taxes.
     *
     * For each order, print the total Sales Tax paid and Total price without taxes for this order
     *
     * @param allOrders : All the orders to be used for calculation
     *
     * @return
     *
     */

    public double calculateOrdersTotal(Map<String, Order> allOrders) {
        if (allOrders == null)
            return 0;

        /**
         * Sort the orders based on orderNames
         */
        SortedSet<String> orderNames = new TreeSet<>(allOrders.keySet());
        double grandTotal = 0;
        /**
         * Used to round the double value up to two digits
         */
        DecimalFormat df = new DecimalFormat("#.##");

        for (String orderName : orderNames) {
            System.out.println("*******" + orderName + "*******");

            Order order = allOrders.get(orderName);
            double totalTax = 0;
            double total = 0;

            // Iterate through the items in the order
            for (int i = 0; i < order.size(); i++) {
                // Calculate the taxes
                double tax = 0;
                Item item = order.get(i).getItem();

                if (item.getDescription().toLowerCase().contains("Imported".toLowerCase())) {
                    tax = Double.valueOf(df.format(item.getPrice() * 0.15)); // Extra 5% tax on imported items
                } else {
                    tax = Double.valueOf(df.format(item.getPrice() * 0.10));
                }

                // Calculate the total price
                double totalprice = item.getPrice() + tax;
                // Print out the item's total price
                System.out.println(order.get(i).getQuantity() + " " + order.get(i).getItem().getDescription() + ": " + df.format(totalprice));

                // Keep a running total
                totalTax += tax;
                total += order.get(i).getItem().getPrice();
            }

            // Print out the total taxes
            System.out.println("Sales Tax: " + df.format(totalTax));

            // Print out the total amount
            System.out.println("Total: " + df.format(total));

            //total = total + totalTax;
            grandTotal += total;
        }
        System.out.println("Sum of orders: " + df.format(grandTotal));
        return grandTotal;
    }
}

