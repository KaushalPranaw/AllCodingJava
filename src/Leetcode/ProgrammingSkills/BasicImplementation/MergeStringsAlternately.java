package Leetcode.ProgrammingSkills.BasicImplementation;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        /*
        Input: word1 = "abc", word2 = "pqr"
        Output: "apbqcr"
         */
        String word1 = "abc", word2 = "pqr";
        System.out.println(new MergeStringsAlternately().mergeAlternately(word1, word2));

    }

    /*public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();

    }*/
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
            i++;
        }

        return sb.toString();

    }
}
