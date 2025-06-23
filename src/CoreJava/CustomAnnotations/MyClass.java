package CoreJava.CustomAnnotations;

public class MyClass {
    @MyAnnotation(value = "Hello, Custom annotation")
    public void myMethod(){
        System.out.println("myMethod called()");
    }
}
