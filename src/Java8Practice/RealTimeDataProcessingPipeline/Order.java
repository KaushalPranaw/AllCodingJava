package Java8Practice.RealTimeDataProcessingPipeline;

public class Order {
    private final String orderId;
    private final int quantity;
    private final double price;

    public Order(String orderId, int quantity, double price) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
