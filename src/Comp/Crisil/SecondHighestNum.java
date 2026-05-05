package Comp.Crisil;

public class SecondHighestNum {
    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 8, 20};
        System.out.println(secondHighestNum(arr));
    }

    private static int secondHighestNum(int[] arr) {
        int max=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;

        for(int num: arr){
            if(num>max){
                second=max;
                max=num;
            }else if(num>second && num!=max){
                second=num;
            }
        }
        return second;
    }

}
