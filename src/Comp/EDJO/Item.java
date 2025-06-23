package Comp.EDJO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Item {
    String name;
    int quantity;
    BigDecimal price;

    public Item(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    /*public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("apple", 5, new BigDecimal(5)),
                new Item("apple", 50, new BigDecimal(50)),
                new Item("orange", 5, new BigDecimal(5)));

        Map<String, ItemSummaryData> summary = items.stream()
                .collect(Collectors.groupingBy(Item::getName,
                        Collectors.collectingAndThen(
                                Collectors.reducing(
                                        new ItemSummaryData(0, BigDecimal.ZERO), // Identity
                                        (a, b) -> new ItemSummaryData(a + b., a.totalPrice.add(b.price.multiply(BigDecimal.valueOf(b.quantity)))) // Accumulator
                                ),
                                itemSummaryData -> itemSummaryData //Finisher
                        )));


        summary.forEach((name, data) -> {
            System.out.println(name + " (" + data.totalQuantity + ") (" + data.totalPrice + ")");
        });


    }*/

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item("apple", 5, new BigDecimal(5)),
                new Item("apple", 50, new BigDecimal(50)),
                new Item("orange", 5, new BigDecimal(5)));

        Map<String, ItemSummaryData> summary = new HashMap<>();

        for (Item item : items) {
            summary.computeIfAbsent(item.name, k -> new ItemSummaryData(0, BigDecimal.ZERO))
                    .accumulate(item); // Accumulate within the loop
        }

        summary.forEach((name, data) -> {
            System.out.println(name + " (" + data.totalQuantity + ") (" + data.totalPrice + ")");
        });
    }

    private static class ItemSummaryData {
        int totalQuantity;
        BigDecimal totalPrice;

        public ItemSummaryData(int totalQuantity, BigDecimal totalPrice) {
            this.totalQuantity = totalQuantity;
            this.totalPrice = totalPrice;
        }

        public void accumulate(Item item) {
            this.totalQuantity += item.quantity;
            this.totalPrice = this.totalPrice.add(item.price.multiply(BigDecimal.valueOf(item.quantity)));
        }
    }
}