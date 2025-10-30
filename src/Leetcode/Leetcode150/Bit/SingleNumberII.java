package Leetcode.Leetcode150.Bit;

public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(new SingleNumberII().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            // 'ones' keeps track of bits that have appeared 1 time (modulo 3)
            ones = (ones ^ num) & ~twos;

            // 'twos' keeps track of bits that have appeared 2 times (modulo 3)
            twos = (twos ^ num) & ~ones;
        }

        // The answer is in 'ones', since it represents the bits that appeared exactly once.
        return ones;
    }
}
