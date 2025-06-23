package CoreJava.ExceptionHandling;

class Parent {

    // defining the method
    void msg() throws ArithmeticException {
        System.out.println("parent method");
    }
}

public class E09_TestExceptionChild extends Parent {

    // overriding the method in child class
    // gives compile time error
//    void msg() //throws IOException
    void msg() {
        System.out.println("TestExceptionChild");
    }

    public static void main(String args[]) {
        Parent p = new E09_TestExceptionChild();
        p.msg();
    }
}