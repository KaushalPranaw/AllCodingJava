package DSA2026.D03_Array_String;

public class TrappingRainWater {
    public static void main(String[] args) {
        //Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
        //Output: 6
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int lMax = height[left], rMax = height[right];
        int totalTrap = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                lMax = Math.max(lMax, height[left]);
                totalTrap += Math.max(0, lMax - height[left]);
                left++;
            } else {
                rMax = Math.max(rMax, height[right]);
                totalTrap += Math.max(0, rMax - height[right]);
                right--;
            }
        }
        return totalTrap;

    }
}
