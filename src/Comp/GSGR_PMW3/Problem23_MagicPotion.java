package Comp.GSGR_PMW3;

public class Problem23_MagicPotion {
    public static void main(String[] args) {
        // Test Cases
        System.out.println(minimalSteps("ABCDABCE")); // Output: 8
        System.out.println(minimalSteps("ABCABCE")); // Output: 5
        System.out.println(minimalSteps("AAAA"));    // Output: 2
    }
    public static int minimalSteps(String ingredients) {
        int n = ingredients.length();
        int[] dp = new int[n + 1]; // dp[i] represents the minimum encoded length for the first i characters

        // Base case: the first character
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // Encode without a '*'
            dp[i] = dp[i - 1] + 1;

            // Check all possible substrings for repetition
            for (int j = 1; j < i; j++) {
                if (ingredients.substring(0, j).equals(ingredients.substring(j, i))) {
                    // If a repeat is found, update dp[i]
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n];
    }
}
