package DSA2026.D03_Array_String;

public class FindIndexOfFirstOccurrenceInString {
    public static void main(String[] args) {
        //Input: haystack = "sadbutsad", needle = "sad"
        //Output: 0
        String haystack = "abcsadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));

    }

    public static int strStr(String txt, String pattern) {
        int n=txt.length();
        int m=pattern.length();

        if (pattern.length() == 0) return 0;

        int resultIndex=0;

        // Create an LPS array to store the longest proper prefix which is also a suffix
        //lps[i] = the longest proper prefix of pat[0..i] which is also a suffix of pat[0..i].
        int[] lps=new int[m];
        computeLPS(lps, pattern);

        //apply KMP code
        int i=0;
        int j=0;

        while (i<n){
            if(txt.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }

            if(j==m){
                resultIndex=i-j;
                return  resultIndex;
                //if need to return all index
                //res.add(i-j);
                //j=lps[j-1];
            } else if(i<n && txt.charAt(i)!=pattern.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return -1;


    }

    private static void computeLPS(int[] lps, String pattern) {
        int len=0;// Length of the previous longest prefix & suffix
        int m=pattern.length();

        lps[0]=0;// Because there is no proper suffix and prefix of pattern[0..0]

        int i=1;
        while (i<m){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else {
                if(len!=0){
                    len=lps[len-1];//You can also write, len = len-1;
                }else {
                    len=0;
                    i++;
                }
            }
        }


    }
}
