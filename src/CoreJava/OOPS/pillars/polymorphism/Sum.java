package CoreJava.OOPS.pillars.polymorphism;

public class Sum {
    //problem
    /*int twoSum(int a, int b){
        return a+b;
    }

    int threeSum(int a, int b, int c){
        return a+b+c;
    }*/


    /*int sum(int a, int b) {
        return a + b;
    }

    int sum(int... a) {
        int res = 0;
        for (int s : a) {
            res += s;
        }
        return res;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }*/

    void sum(int a, long b){
        System.out.println("int long method");
    }

    /*void sum(int a, int b){
        System.out.println("int int method");
    }*/

    public static void main(String[] args) {
        Sum obj = new Sum();
        /*System.out.println(obj.sum(2, 3));
        System.out.println(obj.sum(2, 3, 4));
        System.out.println(obj.sum(1,2,3,4,5,6));*/

        obj.sum(1,2);
    }
}
