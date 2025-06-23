package CoreJava.ExceptionHandling;

import java.io.*;

public class E07_Testthrows {
    /*void m() throws IOException {
        throw new IOException("device error");//checked exception
    }
    void n() throws IOException {
        m();
    }
    void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("exception handled");
        }
    }
    public static void main(String args[]) {
        E07_Testthrows obj = new E07_Testthrows();
        obj.p();
        System.out.println("normal flow...");
    }*/

    /*public static void main(String args[]) {
        try {
            M m = new M();
            m.method();
        } catch (Exception e) {
            System.out.println("exception handled");
        }

        System.out.println("normal flow...");
    }*/

    public static void main(String args[])throws IOException{//declare exception
        M m=new M();
        m.method();

        System.out.println("normal flow...");
    }
}

/*
class M {
    void method() throws IOException {
        throw new IOException("device error");
    }
}*/

class M {
    void method() throws IOException {
        System.out.println("device operation performed");
    }
}