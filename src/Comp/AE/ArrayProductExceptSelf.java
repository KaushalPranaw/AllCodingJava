package Comp.AE;

public class ArrayProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        /*
        a[i-1]*res[i-1]
        nums=>1, 2, 3, 4
        resu=>1, 1 ,2, 6
        rp=1
        rp=1*nums[i+1]=1*4=4
        res[i]=2
        res[i]=res[i]*rp=2*4=8;
        rp=4*3=12
        res[1]=rp*res[1]=12*1=12
                 6


         */

        // Find and print the result array where each element is the product of all other elements
        int[] result = productExceptSelf(nums);

        System.out.print("Product array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        //l->r
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        //r->l
        for (int i = n - 2; i >= 0; i--) {
            rightProduct = rightProduct * nums[i + 1];
            res[i] = res[i] * rightProduct;
        }
        return res;
    }
}
