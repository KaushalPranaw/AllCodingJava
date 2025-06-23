package Java8Practice.StreamsExercise.OrderItemMappingAndFlatterning;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestOrderItemMappingAndFlatterning {
    public static void main(String[] args) {
        // Create some sample OrderItems
        OrderItem item1 = new OrderItem("Apple", 3);
        OrderItem item2 = new OrderItem("Banana", 2);
        OrderItem item3 = new OrderItem("Orange", 5);
        OrderItem item4 = new OrderItem("Grapes", 10);

        // Create orders
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(101, List.of(item1, item2))); // Order with two items
        orders.add(new Order(102, List.of(item3))); // Order with one item
        orders.add(new Order(103, List.of(item4, item1))); // Order with two items

        // Flatten the orders to a list of OrderItems using streams
        Set<String> productNames = orders.stream()
                .flatMap(order -> order.getOrderItems().stream())
                .map(OrderItem::getProductName)
                .collect(Collectors.toSet());
        // Print the result
        productNames.forEach(System.out::println);

    }
}
