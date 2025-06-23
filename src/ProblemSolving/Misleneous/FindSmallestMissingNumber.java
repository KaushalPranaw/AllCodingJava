package ProblemSolving.Misleneous;

public class FindSmallestMissingNumber {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
        int n = arr.length;
        int m = 11;
        System.out.println("Smallest missing element is " + findFirstMissing(arr, n, m));
    }

    private static int findFirstMissing(int[] arr, int n, int m) {
        int vec[] = new int[m];

        for (int i = 0; i < n; i++) {
            vec[arr[i]] = 1;
        }

        for (int i = 0; i < m; i++) {
            if (vec[i] == 0) {
                return i;
            }
        }
        return m;
    }
}
