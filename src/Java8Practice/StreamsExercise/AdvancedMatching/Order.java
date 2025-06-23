package Java8Practice.StreamsExercise.AdvancedMatching;

public class Order {
    private int orderId;
    private String status;
    private double amount;

    public Order(int orderId, String status, double amount) {
        this.orderId = orderId;
        this.status = status;
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}
