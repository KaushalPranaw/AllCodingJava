package Leetcode.Array_String;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalCost > totalGas) {
            return -1;
        }

        int index = 0;
        int remainingGas = 0;
        for (int i = 0; i < n; i++) {
            remainingGas += gas[i] - cost[i];
            if (remainingGas < 0) {
                remainingGas = 0;
                index = i+1;
            }
        }
        return index;
    }
}
