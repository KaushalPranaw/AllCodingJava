package Java8Practice.ProblemInterviews;

import java.util.Arrays;

public class RemoveDuplicateFromString {
    public static void main(String[] args) {
        String s = "dabfcadef";
        //s.chars().distinct().mapToObj(c -> (char) c).forEach(System.out::print);
        Arrays.stream(s.split("")).distinct().forEach(System.out::print);
    }

}
