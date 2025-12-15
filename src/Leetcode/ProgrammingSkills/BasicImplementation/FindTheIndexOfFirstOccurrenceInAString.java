package Leetcode.ProgrammingSkills.BasicImplementation;

public class FindTheIndexOfFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(new FindTheIndexOfFirstOccurrenceInAString().strStr(haystack, needle));
    }
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
