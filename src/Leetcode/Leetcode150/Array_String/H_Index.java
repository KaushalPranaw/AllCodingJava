package Leetcode.Leetcode150.Array_String;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(new H_Index().hIndex(citations));
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int countArray[] = new int[n + 1];

        for (int citation : citations) {
            if (citation > n) {
                countArray[n]++;
            } else {
                countArray[citation]++;
            }
        }

        int count = 0;
        for (int i = countArray.length - 1; i >= 0; i--) {
            count += countArray[i];
            if (i <= count) {
                return i;
            }
        }
        return -1;
    }
}
