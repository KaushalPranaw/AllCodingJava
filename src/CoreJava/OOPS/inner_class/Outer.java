package CoreJava.OOPS.inner_class;

//Member inner class
/*public class Outer {
    private String message = "Hello from Outer";

    class Inner { // Member Inner Class
        void display() {
            System.out.println(message); // Access outer class private member
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); // Create instance of Inner class
        inner.display();
    }
}*/

//Static inner class
/*public class Outer {
    private static String message = "Hello from Static Nested Class";

    static class Nested { // Static Nested Class
        void display() {
            System.out.println(message); // Can access static members of Outer class
        }
    }

    public static void main(String[] args) {
        Outer.Nested nested = new Outer.Nested(); // Create instance directly
        nested.display();
    }
}*/

//Local inner class
/*public class Outer {
    void showMessage() {
        final String localMessage = "Hello from Local Inner Class";

        class Inner { // Local Inner Class
            void display() {
                System.out.println(localMessage); // Access final local variable
            }
        }

        Inner inner = new Inner();
        inner.display();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.showMessage();
    }
}*/

//Anonymous inner class
interface Greeting {
    void greet();
}

public class Outer {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() { // Anonymous Inner Class
            @Override
            public void greet() {
                System.out.println("Hello from Anonymous Inner Class");
            }
        };

        greeting.greet();
    }
}

