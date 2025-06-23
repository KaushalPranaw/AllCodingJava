package Comp.GSGR_PMW3;

public class Problem18_SecondSmallest {
    public static void main(String[] args) {
        System.out.println(secondSmallest(new int[]{-1, 0, 1, -2, 2}));  // Output: -1
        System.out.println(secondSmallest(new int[]{0, 1}));              // Output: 1
        System.out.println(secondSmallest(new int[]{5, 5, 5, 5}));        // Output: 0
        System.out.println(secondSmallest(new int[]{3}));                 // Output: 0
        System.out.println(secondSmallest(null));                        // Output: 0
    }

    /*public static int secondSmallest(int[] x) {
        if (x == null || x.length < 2) {
            return 0;
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : x) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else {
                if (num < secondSmallest && num != smallest) {
                    secondSmallest = num;
                }
            }
        }
        // Handle case where all elements are the same
        if (secondSmallest == Integer.MAX_VALUE) {
            return 0;
        }

        return secondSmallest;
    }*/
    public static int secondSmallest(int[] x) {
        if (x == null || x.length < 2) {
            return 0;
        }

        int first = Integer.MAX_VALUE;
        int second = first;
        for (int i = 0; i < x.length; i++) {
            if (x[i] < first) {
                second = first;
                first = x[i];
            } else if (second > x[i] && x[i] != first) {
                second = x[i];
            }
        }
        return second;
    }
}
