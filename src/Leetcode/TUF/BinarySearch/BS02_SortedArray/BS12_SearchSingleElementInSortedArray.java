package Leetcode.TUF.BinarySearch.BS02_SortedArray;

public class BS12_SearchSingleElementInSortedArray {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        System.out.println(findSingleElement(arr));
    }

    /*private static int findSingleElement(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num ^ arr[i];
        }
        return num;
    }*/

    private static int findSingleElement(int[] arr) {

        // the first occurrence of a pair will always be at an even index,
        // and the second at an odd index.
        //Index:     0 1 2 3 4 5 6
        //Array:     1 1 2 2 3 3 4
        //Here:
        //
        //1 is at index 0 (even), its pair at index 1 (odd)
        //
        //2 is at index 2 (even), its pair at index 3 (odd)
        //
        //3 is at index 4 (even), its pair at index 5 (odd)
        //
        //This pattern continues until the single element appears — which breaks this even-odd alignment.

        int n = arr.length;
        // Edge cases:
        if (n == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];

        int low = 1, high = n - 2;//excluding first and last element

        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the single element:
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            //odd-means pair end
            //even - means pair start

            //If mid is odd and arr[mid] == arr[mid - 1],
            //you're on the second of a pair → pattern is still fine.

            //If mid is even and arr[mid] == arr[mid + 1],
            // you're on the first of a pair → pattern is still fine.

            // We are in the left part:
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
                    (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                //mtlb yha tk sb sorted h avi to iske aage ka dekhna hai
                low = mid + 1;
            } else {
                //mtlb mid ke phle hi dikkat hai
                high = mid - 1;
            }
        }
        return -1;
    }
}
