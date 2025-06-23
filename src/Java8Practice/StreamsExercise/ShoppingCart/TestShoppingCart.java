package Java8Practice.StreamsExercise.ShoppingCart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestShoppingCart {
    public static void main(String[] args) {
        // Sample CartItems
        CartItem item1 = new CartItem("Apple", 3, 0.99);
        CartItem item2 = new CartItem("Banana", 2, 1.20);
        CartItem item3 = new CartItem("Orange", 5, 0.80);
        CartItem item4 = new CartItem("Grapes", 10, 2.50);

        // List of CartItems
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(item1);
        cartItems.add(item2);
        cartItems.add(item3);
        cartItems.add(item4);

        //Calculate the total value of all items in the cart. (Use mapToDouble())
        Double totalValue = cartItems.stream().mapToDouble(CartItem::getTotalPrice)
                .sum();
        System.out.println(totalValue);

        //Find the item with the highest total price (quantity * price). (Use Collectors.comparingDouble())
        Optional<CartItem> highestPriceItem = cartItems.stream()
                .max(Comparator.comparingDouble(CartItem::getTotalPrice));
        highestPriceItem.ifPresent(item ->
                System.out.println("Item with highest total price: " + item)
        );

        //Filter out items with a quantity of 0 and print the remaining cart.
        List<CartItem> filteredCart = cartItems.stream().filter(cart -> cart.getQuantity() != 0)
                .collect(Collectors.toList());
        System.out.println("Cart with items having quantity > 0:");
        filteredCart.forEach(System.out::println);
    }
}
