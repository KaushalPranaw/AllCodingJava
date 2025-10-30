package Leetcode.Leetcode150.TwoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater().maxArea(height));

    }

    public int maxArea(int[] height) {
        int n=height.length;
        int l=0, r=n-1;
        int max=Integer.MIN_VALUE;
        while (l<r){
            int area=Math.min(height[l], height[r])*(r-l);
            max=Math.max(max, area);
            if(height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
}
