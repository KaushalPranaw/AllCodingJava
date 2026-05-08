package May2026.DSA.Day3.DSA;

public class D11_FindNumberThatAppearsOnceAndOtherNumbersTwice {
    public static void main(String[] args) {
        //Example 1:
        //Input Format: arr[] = {2,2,1}
        //Result: 1
        //Explanation: In this array, only the element 1 appear once and so it is the answer.
        //
        //
        //Example 2:
        //Input Format: arr[] = {4,1,2,1,2}
        //Result: 4
        //Explanation: In this array, only element 4 appear once and the other elements appear twice. So, 4 is the answer.
        int[] arr1 = {2, 2, 1};
        int[] arr2 = {4, 1, 2, 1, 2};

        System.out.println(singleNumber(arr1));
        System.out.println(singleNumber(arr2));
    }

    private static int singleNumber(int[] arr) {
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            num = num ^ arr[i];
        }
        return num;

    }
}
