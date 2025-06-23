package CoreJava.ExceptionHandling;

public class E03_NestedTryBlock {
    /*public static void main(String args[]) {
        //outer try block
        try {
            //inner try block 1
            try {
                System.out.println("going to divide by 0");
                int b = 39 / 0;
            }
            //catch block of inner try block 1
            catch (ArithmeticException e) {
                System.out.println(e);
            }


            //inner try block 2
            try {
                int a[] = new int[5];

                //assigning the value out of array bounds
                a[5] = 4;
            }

            //catch block of inner try block 2
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }


            System.out.println("other statement");
        }
        //catch block of outer try block
        catch (Exception e) {
            System.out.println("handled the exception (outer catch)");
        }

        System.out.println("normal flow..");
    }*/


    public static void main(String args[]) {
        // outer (main) try block
        try {
            //inner try block 1
            try {
                // inner try block 2
                try {
                    int arr[] = {1, 2, 3, 4};
                    //printing the array element out of its bounds
                    System.out.println(arr[10]);
                }
                // to handles ArithmeticException
                catch (ArithmeticException e) {
                    System.out.println("Arithmetic exception");
                    System.out.println(" inner try block 2");
                }
            }

            // to handle ArithmeticException
            catch (ArithmeticException e) {
                System.out.println("Arithmetic exception");
                System.out.println("inner try block 1");
            }
        }

        // to handle ArrayIndexOutOfBoundsException
        catch (ArrayIndexOutOfBoundsException e4) {
            System.out.println(e4);
            System.out.println(" outer (main) try block");
        } catch (Exception e5) {
            System.out.print("Exception");
            System.out.println(" handled in main try-block");
        }
    }
}
