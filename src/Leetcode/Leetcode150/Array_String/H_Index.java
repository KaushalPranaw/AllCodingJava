package Leetcode.Leetcode150.Array_String;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(new H_Index().hIndex(citations));
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] ca = new int[n + 1];

        for (int c : citations) {
            if (c > n) {
                ca[n]++;
            } else {
                ca[c]++;
            }
        }

        int count = 0;
        for (int i = ca.length - 1; i >= 0; i--) {
            count += ca[i];
            if (count >= i) {
                return i;
            }
        }
        return -1;
    }
}
