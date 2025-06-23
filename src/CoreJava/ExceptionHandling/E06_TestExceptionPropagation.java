package CoreJava.ExceptionHandling;

import java.io.IOException;

public class E06_TestExceptionPropagation {
    /*void m() {
        int data = 50 / 0;
    }

    void n() {
        m();
    }

    void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println("exception handled");
        }
    }

    public static void main(String args[]) {
        E06_TestExceptionPropagation obj = new E06_TestExceptionPropagation();
        obj.p();
        System.out.println("normal flow...");
    }*/

    void m() throws IOException{
    //void m()//throws IOException{
        throw new IOException("device error");//checked exception
    }
    void n() throws IOException{
        m();
    }
    void p(){
        try{
            n();
        }catch(Exception e){System.out.println("exception handeled");}
    }
    public static void main(String args[]){
        E06_TestExceptionPropagation obj=new E06_TestExceptionPropagation();
        obj.p();
        System.out.println("normal flow");
    }
}
