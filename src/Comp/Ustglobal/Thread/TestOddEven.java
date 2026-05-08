package Comp.Ustglobal.Thread;

class SharePointer{
    private  int num=1;
    private final int MAX=10;

    public synchronized void printOdd(){
        while (num<=MAX){
            //even case
            while (num%2==0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(num<=MAX){
                System.out.println(Thread.currentThread().getName()+"->"+num);
                num++;
            }
            notify();
        }
    }
    public synchronized void printEven(){
        while (num<=MAX){
            //handle odd
            while (num%2!=0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(num<=MAX){
                System.out.println(Thread.currentThread().getName()+"->"+num);
                num++;
            }
            notify();
        }
    }
}
public class TestOddEven {
    public static void main(String[] args) {
        SharePointer sharePointer=new SharePointer();
        Thread t1=new Thread(()-> sharePointer.printOdd());
        Thread t2=new Thread(()->sharePointer.printEven());
        t1.start();
        t2.start();
    }
}
