package Comp.CodeWithComplexity75.DP;

import java.util.Arrays;
import java.util.Map;

public class C17_CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new C17_CoinChange().coinChange(coins, amount));
    }

    //recur+memo
    /*public int coinChange(int[] coins, int amount) {
        if (i == 0) {
            if (T % coins[i] == 0) {
                return T / coins[i];
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (dp[i][T] != -1) {
            return dp[i][T];
        }

        int notTake = coinChangeHelper(i - 1, T, coins, dp);
        int take = Integer.MAX_VALUE;
        if (T - coins[i] >= 0) {
            take = coinChangeHelper(i, T - coins[i], coins, dp);
            if (take != Integer.MAX_VALUE) {
                take += 1; // Add 1 only if the subproblem is solvable
            }
        }
        return dp[i][T] = Math.min(take, notTake);
    }*/

    /*//bottom up
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        //for i=0
        for (int T = 0; T <= amount; T++) {
            if (T % coins[0] == 0) {
                dp[0][T] = T / coins[0];
            } else {
                dp[0][T] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int T = 0; T <= amount; T++) {
                int notTake = dp[i - 1][T];
                int take = Integer.MAX_VALUE;
                if (T - coins[i] >= 0) {
                    take = dp[i][T - coins[i]];
                    if (take != Integer.MAX_VALUE) {
                        take += 1; // Add 1 only if the subproblem is solvable
                    }
                }
                dp[i][T] = Math.min(take, notTake);
            }
        }

        return dp[n - 1][amount] == Integer.MAX_VALUE ? -1 : dp[n - 1][amount];
    }*/

    //bottom up
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        //for i=0
        for (int T = 0; T <= amount; T++) {
            if (T % coins[0] == 0) {
                prev[T] = T / coins[0];
            } else {
                prev[T] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < n; i++) {
            int[] cur = new int[amount + 1];
            for (int T = 0; T <= amount; T++) {
                int notTake = prev[T];
                int take = Integer.MAX_VALUE;
                if (T - coins[i] >= 0) {
                    take = cur[T - coins[i]];
                    if (take != Integer.MAX_VALUE) {
                        take += 1; // Add 1 only if the subproblem is solvable
                    }
                }
                cur[T] = Math.min(take, notTake);
            }
            prev = cur.clone();
        }

        return prev[amount] == Integer.MAX_VALUE ? -1 : prev[amount];
    }
}
