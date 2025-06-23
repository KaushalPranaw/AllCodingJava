package Leetcode.TUF.BinarySearch.BS02_SortedArray;

public class BS13_PeakElement {

    //if 'arr[i]' is the peak element
    // if , 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'.
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        System.out.println(findPeakElement(arr));

    }

    private static int findPeakElement(int[] arr) {
        int n = arr.length;

        // Edge cases:
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;


        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If arr[mid] is the peak:
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // If we are on the left slope:
            if (arr[mid - 1] < arr[mid]) {
                //mtlb right me isse bhi bada mil skta hai
                low = mid + 1;
            } else {
                // If we are on the right slope or at a flat part:
                high = mid - 1;
            }

        }
        return -1;
    }
}
