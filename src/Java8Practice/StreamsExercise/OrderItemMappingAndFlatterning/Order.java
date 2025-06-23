package Java8Practice.StreamsExercise.OrderItemMappingAndFlatterning;

import java.util.List;

public class Order {
    private int id;
    private List<OrderItem> orderItems;

    public Order(int id, List<OrderItem> orderItems) {
        this.id = id;
        this.orderItems = orderItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderItems=" + orderItems +
                '}';
    }
}
