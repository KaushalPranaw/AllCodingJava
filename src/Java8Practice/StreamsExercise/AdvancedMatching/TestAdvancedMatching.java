package Java8Practice.StreamsExercise.AdvancedMatching;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestAdvancedMatching {
    public static void main(String[] args) {
        // Create a list of orders
        List<Order> orders = Arrays.asList(
                new Order(101, "shipped", 500.0),
                new Order(102, "processing", 300.0),
                new Order(103, "shipped", 700.0),
                new Order(104, "cancelled", 200.0),
                new Order(105, "processing", 150.0)
        );

        // Use Stream.allMatch() to check if all orders are above a certain amount
        boolean allAbove200 = orders.stream().allMatch(order -> order.getAmount() > 200);
        System.out.println("All orders above 200: " + allAbove200);

        // Use Stream.anyMatch() to check if any order has a status of "shipped"
        boolean anyShipped = orders.stream().anyMatch(order -> order.getStatus().equalsIgnoreCase("shipped"));
        System.out.println("Any order is shipped: " + anyShipped);

        // Use Stream.noneMatch() to check if no order has a status of "cancelled"
        boolean noneCancelled = orders.stream().noneMatch(order -> order.getStatus().equalsIgnoreCase("cancelled"));
        System.out.println("No orders are cancelled: " + noneCancelled);

        // Use Stream.findFirst() to retrieve an order with a specific orderId
        Optional<Order> specificOrder = orders.stream()
                .filter(order -> order.getOrderId() == 103) // Find order with orderId 103
                .findFirst();

        specificOrder.ifPresent(order -> System.out.println("Order with ID 103: " + order));
    }
}
