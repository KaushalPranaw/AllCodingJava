package CoreJava.ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class E01_TryCatchExample {
    /*public static void main(String[] args) {
        int data=50/0;
        System.out.println("rest of the code");

    }*/
    /*public static void main(String[] args) {
        try {
            int data=50/0;
        } catch (ArithmeticException e){
            System.out.println(e);
        }

        System.out.println("rest of the code");

    }*/

    /*public static void main(String[] args) {
        try {
            int data=50/0;
            System.out.println("rest of the code");// will not be printed
        } catch (ArithmeticException e){
            System.out.println(e);
        }
    }*/

    /*public static void main(String[] args) {
        int i = 50;
        int j = 0;
        int data;
        try {

            data = i / j;
        } catch (ArithmeticException e) {
            data = i / (j + 2);
            System.out.println(data);
        }
        System.out.println("rest of the code");

    }*/

    /*public static void main(String[] args) {
        try {
            int data1 = 50/0;
        } catch (ArithmeticException e) {
            int data2 = 50/0;
        }
        System.out.println("rest of the code");

    }*/

    /*public static void main(String[] args) {
        try {
            int data1 = 50/0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code");

    }*/

    /*public static void main(String[] args) {
        try {
            int arr[]= {1,3,5,7};
            System.out.println(arr[10]); //may throw exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code");
    }*/

    public static void main(String[] args) {
        PrintWriter pw;
        try {
            pw=new PrintWriter("abc.yml");
            pw.println("saved");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        System.out.println("File saved successfully");
    }
}
