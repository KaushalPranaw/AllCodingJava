package Comp.WDTS;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        // Example array
        int[] arr = {1, 34, 3, 98, 9, 76, 45, 4};
        String maxNum = Arrays.stream(arr)
                .mapToObj(String::valueOf)  // Convert each integer to String
                .sorted((x,y)->(y+x).compareTo(x+y))
                .collect(Collectors.joining());
        System.out.println(maxNum);


        //System.out.println(Arrays.toString/(strArr));
    }
}
