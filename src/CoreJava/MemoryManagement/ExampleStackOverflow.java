package CoreJava.MemoryManagement;

public class ExampleStackOverflow {
    public ExampleStackOverflow() {
        new ExampleStackOverflow();
    }

    public static void main(String[] args) {
        new ExampleStackOverflow();
    }
}
