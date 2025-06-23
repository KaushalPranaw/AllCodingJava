package Java8Practice.StreamsExercise.ReducingData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestReducingData {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>(
                Arrays.asList(
                        new Transaction(1, 1000.0, "deposit"),
                        new Transaction(2, 1000.0, "withdraw"),
                        new Transaction(4, 1500.0, "deposit"),
                        new Transaction(3, 2000.0, "deposit"),
                        new Transaction(5, 100.0, "withdraw")
                ));

        double totalAmount = transactions.stream().reduce(0.0, (balance, transaction) -> {
            if (transaction.getType().equalsIgnoreCase("deposit")) {
                balance += transaction.getAmount();
            } else if (transaction.getType().equalsIgnoreCase("withdraw")) {
                balance -= transaction.getAmount();
            }
            return balance;
        }, Double::sum);
        System.out.println(totalAmount);

        //count total number of transaction
        long totalTransactions = transactions.stream().reduce(0L, (count, txn) -> count + 1, Long::sum);
        System.out.println(totalTransactions);
    }
}
