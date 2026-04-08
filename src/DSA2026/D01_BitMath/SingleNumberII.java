package DSA2026.D01_BitMath;

public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(new SingleNumberII().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        /*
        Bucket Analogy (SUPER EASY)
        Imagine 2 buckets:
        Bucket 1 → ones
        Bucket 2 → twos
        When a number comes:
        👉 First time
        → goes to ones
        👉 Second time
        → moves from ones → twos
        👉 Third time
        → removed from twos (disappears completely)
         */
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}
