package CoreJava.ExceptionHandling;

public class E08_FinalExampleTest {
    /*final int age = 18;

    void display() {

        // reassigning value to age variable
        // gives compile time error
        //age = 55;
    }

    public static void main(String[] args) {
        E08_FinalExampleTest obj = new E08_FinalExampleTest();
        // gives compile time error
        obj.display();
    }*/


    /*public static void main(String args[]){
        try {
            System.out.println("Inside try block");
            // below code throws divide by zero exception
            int data=25/0;
            System.out.println(data);
        }
        // handles the Arithmetic Exception / Divide by zero exception
        catch (ArithmeticException e){
            System.out.println("Exception handled");
            System.out.println(e);
        }
        // executes regardless of exception occurred or not
        finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("rest of the code...");
    }*/

    public static void main(String[] args) {
        E08_FinalExampleTest obj = new E08_FinalExampleTest();
        // printing the hashcode
        System.out.println("Hashcode is: " + obj.hashCode());
        obj = null;
        // calling the garbage collector using gc()
        System.gc();
        System.out.println("End of the garbage collection");
    }

    // defining the finalize method
    protected void finalize() {
        System.out.println("Called the finalize() method");
    }
}
