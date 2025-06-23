package CoreJava.ExceptionHandling;

public class E05_TestThrow {

    /*//function to check if person is eligible to vote or not
    public static void validate(int age) {
        if (age < 18) {
            //throw Arithmetic exception if not eligible to vote
            throw new ArithmeticException("Person is not eligible to vote");
        } else {
            System.out.println("Person is eligible to vote!!");
        }
    }

    //main method
    public static void main(String args[]) {
        //calling the function
        validate(13);
        System.out.println("rest of the code...");
    }*/

    /*//function to check if person is eligible to vote or not
    public static void method() throws FileNotFoundException {
        FileReader file = new FileReader("C:\\Users\\Anurati\\Desktop\\abc.txt");
        BufferedReader fileInput = new BufferedReader(file);
        throw new FileNotFoundException();
    }
    //main method
    public static void main(String args[]) {
        try {
            method();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("rest of the code...");
    }*/

    public static void main(String args[]) {
        try {
            // throw an object of user defined exception
            throw new UserDefinedException("This is user-defined exception");
        } catch (UserDefinedException ude) {
            System.out.println("Caught the exception");
            // Print the message from MyException object
            System.out.println(ude.getMessage());
        }
    }
}
