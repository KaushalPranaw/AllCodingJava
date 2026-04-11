package DSA2026.D03_Array_String;

public class H_Index {
    public static void main(String[] args) {
        //Input: citations = [3,0,6,1,5]
        //Output: 3
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations));

    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] countArray = new int[n + 1];
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
