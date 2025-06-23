package CoreJava.ExceptionHandling;

public class E02_MultipleCatchBlock {
    /*public static void main(String[] args) {
        try {
            int a[] = new int[5];
            a[5] = 30 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs"); //only this will be printed
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        } catch (Exception e) {
            System.out.println("Parent Exception occurs");
        }
    }*/

    /*public static void main(String[] args) {
        try {
            int a[] = new int[5];
            a[5] = 30;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");////only this will be printed
        } catch (Exception e) {
            System.out.println("Parent Exception occurs");
        }
    }*/

    /*public static void main(String[] args) {
        try {
            int a[] = new int[5];
            a[5] = 30 / 0;
            System.out.println(a[10]);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs"); //only this will be printed
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        } catch (Exception e) {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("rest of the code");
    }*/

    /*public static void main(String[] args) {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        } catch (Exception e) {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("rest of the code");
    }*/

    /*public static void main(String args[]) {
        //chote exception se bada exception krna hota h
        try {
            int a[] = new int[5];
            a[5] = 30 / 0;
        } catch (Exception e) {
            System.out.println("common task completed");
        } catch (ArithmeticException e) {//compile time error
            System.out.println("task1 is completed");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("task 2 completed");////compile time error
        }
        System.out.println("rest of the code...");
    }*/

}
