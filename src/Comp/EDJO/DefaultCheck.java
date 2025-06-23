package Comp.EDJO;

interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B {

    B a();
    default void show() {
        System.out.println("B");
    }
}
public class DefaultCheck implements A, B {

    public B a(){
        return new DefaultCheck();
    }

    @Override
    public void show() {
        A.super.show();
    }

    public static void main(String[] args) {
        new DefaultCheck().show();
    }
}
