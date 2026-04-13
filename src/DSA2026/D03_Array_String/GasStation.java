package DSA2026.D03_Array_String;

public class GasStation {
    public static void main(String[] args) {
        //Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        //Output: 3
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int remainingGas = 0;
        int index = 0;

        for (int i = 0; i < gas.length; i++) {
            remainingGas += gas[i] - cost[i];
            if (remainingGas < 0) {
                index = i + 1;
                remainingGas = 0;
            }
        }
        return index;
    }
}
