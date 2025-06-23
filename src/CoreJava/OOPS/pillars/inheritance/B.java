package CoreJava.OOPS.pillars.inheritance;

public class B extends A {
    void method3() {
        System.out.println("calling method3()");
    }

    void method4() {
        System.out.println("calling method4()");
    }

    public static void main(String[] args) {
        B b=new B();
        // inherited by parent class (A)
        b.method1();
        b.method2();
    }
}
