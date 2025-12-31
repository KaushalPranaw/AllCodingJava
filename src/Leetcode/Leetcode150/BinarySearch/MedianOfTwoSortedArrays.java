package Leetcode.Leetcode150.BinarySearch;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));//2.0

        int[] nums3 = {1, 2}, nums4 = {3, 4};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums3, nums4));//2.5

    }

    /*
    Sbse phle chote wale array me hum binary search, so find min array first

    uske bad hum decide krege kitne element left me rhege,
    fir uske bad kuch element A se lege aur kuch element B se

    if we need 5 element left side, if we take 3 from A then 2 from B , we have to take

    in left side if l1<=r2 and l2<=r1 then it is valid symmetric
    we have to apply this basically

    if we found valid symmetric and we know the median we can find easily

    even case : using median=( max(l1, l2) + min(r1, r2) )/2
    odd case:

    if l1>r2 then high will be eliminated
    high=mid-1;

    if l2>r1 means low is eliminiated
    low=mid+1;

     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int n1 = A.length;
        int n2 = B.length;
        if (n1 > n2) {
            findMedianSortedArrays(B, A);
        }

        int n = n1 + n2;

        int left = (n1 + n2 + 1) / 2;//element required on left side
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE;
            int l2 = Integer.MIN_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1) {
                r1 = A[mid1];
            }

            if (mid2 < n2) {
                r2 = B[mid2];
            }

            if (mid1 - 1 >= 0) {
                l1 = A[mid1 - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = B[mid2 - 1];
            }

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                }
                return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
