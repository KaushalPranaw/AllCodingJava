package Leetcode.Auto.Premium;

public class NumberOfSubarraysThatMatchPatternII {
    public static void main(String[] args) {
        NumberOfSubarraysThatMatchPatternII solution = new NumberOfSubarraysThatMatchPatternII();

        // Test cases
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] pattern1 = {1, 1};
        System.out.println("Test Case 1: " + solution.countMatchingSubarrays(nums1, pattern1)); // Expected: 4

        int[] nums2 = {1, 4, 4, 1, 3, 5, 5, 3};
        int[] pattern2 = {1, 0, -1};
        System.out.println("Test Case 2: " + solution.countMatchingSubarrays(nums2, pattern2)); // Expected: 2

        int[] nums3 = {1, 2, 3};
        int[] pattern3 = {1, 1, 1};
        System.out.println("Test Case 3: " + solution.countMatchingSubarrays(nums3, pattern3)); // Expected: 0

        int[] nums4 = {1, 2, 1, 3, 2, 4};
        int[] pattern4 = {1, -1, 1, -1};
        System.out.println("Test Case 4: " + solution.countMatchingSubarrays(nums4, pattern4)); // Expected: 1

        int[] nums5 = {1};
        int[] pattern5 = {1};
        System.out.println("Test Case 5: " + solution.countMatchingSubarrays(nums5, pattern5)); //expected:0

    }

    /*public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        int count = 0;

        for (int i = 0; i < n - m; i++) {
            int k = 0;
            while (k < m) {
                if (pattern[k] == 1 && nums[i + k + 1] > nums[i + k]) {
                    k++;
                } else if (pattern[k] == 0 && nums[i + k + 1] == nums[i + k]) {
                    k++;
                } else if (pattern[k] == -1 && nums[i + k + 1] < nums[i + k]) {
                    k++;
                } else {
                    break;
                }
            }
            if (k == m) {
                //found the subarray
                count++;
            }
        }
        return count;

    }*/
    //using KMP
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        if (m == 0 || n <= m) {
            return 0;
        }

        int transformedNums[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                transformedNums[i] = 1;
            } else if (nums[i + 1] == nums[i]) {
                transformedNums[i] = 0;
            } else {
                transformedNums[i] = -1;
            }
        }
        return kmp(transformedNums, pattern);

    }

    public int kmp(int[] text, int[] pattern) {
        int n = text.length;
        int m = pattern.length;

        int count = 0;

        if (m == 0) {
            return n + 1;
        }
        int[] lps = computeLPSArray(pattern);
        int i = 0;//index of text[i]
        int j = 0;//index of pattern[j];

        while (i < n) {
            if (pattern[j] == text[i]) {
                j++;
                i++;
            }

            if (j == m) {
                count++;
                j = lps[j - 1];
            } else if (i < n && pattern[j] != text[i]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return count;
    }

    private int[] computeLPSArray(int[] pattern) {
        int m = pattern.length;
        int[] lps = new int[m];

        int len = 0;// length of the previous longest prefix suffix
        lps[0] = 0; // lps[0] is always 0

        int i = 1;
        while (i < m) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

}
