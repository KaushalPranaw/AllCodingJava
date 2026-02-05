package Leetcode.Leetcode150.Array_String;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(height));//6
    }
    //{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
    //lm=0;
    //rm=0;
    /*
     *
     * */

    //using 2 pointers
    /*
    min(max height on left, max height on right) − current height

     */
    public int trap(int[] height) {
        int trap = 0;
        int left = 0, right = height.length - 1;
        int lMax = height[left], rMax = height[right];

        while (left < right) {
            if (height[left] < height[right]) {
                lMax = Math.max(lMax, height[left]);
                trap += Math.max(0, lMax - height[left]);
                left++;
            } else {
                rMax = Math.max(rMax, height[right]);
                trap += Math.max(0, rMax - height[right]);
                right--;
            }
        }
        return trap;
    }

    /*//using 2 pointers
    public int trap(int[] height) {
        //left, right, lmax, rmax, trap
        int left = 1, right = height.length - 2;
        int lmax = height[left - 1];
        int rmax = height[right + 1];
        int trap = 0;

        while (left <= right) {
            if (lmax < rmax) {
                trap += Math.max(0, lmax - height[left]);
                lmax = Math.max(lmax, height[left]);
                left++;
            } else {
                trap += Math.max(0, rmax-height[right]);
                rmax = Math.max(rmax, height[right]);
                right--;
            }
        }
        return trap;
    }*/

}
