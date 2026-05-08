package May2026.DSA.Day3.DSA;

public class D12_LongestSubarrayWithGivenSumK_Positives {
    public static void main(String[] args) {
        //Input:
        // nums = [10, 5, 2, 7, 1, 9], k = 15
        //Output:
        // 4
        //Explanation:
        // The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.
        // Input:
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;
        int ans = longestSubarray(nums, k);
        System.out.println("Longest Subarray Length: " + ans);
    }

    // Sliding Window (Works for Positive Numbers only)
    public static int longestSubarray(int[] arr, int k) {
        int left = 0, right = 0;
        int sum = 0;
        int maxLen = 0;
        while (right < arr.length) {
            sum += arr[right];

            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }
        return maxLen;
    }
}