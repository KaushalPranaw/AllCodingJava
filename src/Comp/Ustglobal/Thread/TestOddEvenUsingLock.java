package Comp.Ustglobal.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharePointerUsingLock{
    private  int num=1;
    private final int MAX=10;

    private final Lock lock=new ReentrantLock();
    private final Condition oddCondition=lock.newCondition();
    private final Condition evenCondition=lock.newCondition();

    public void printOdd(){
        lock.lock();
        try {
            while (num<=MAX){
                //even case
                while (num%2==0){
                    oddCondition.await();
                }
                if(num<=MAX){
                    System.out.println(Thread.currentThread().getName()+"->"+num);
                    num++;
                }
                evenCondition.signal();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }
    public void printEven(){
        lock.lock();
        try {
            while (num<=MAX){
                //even case
                while (num%2!=0){
                    evenCondition.await();
                }
                if(num<=MAX){
                    System.out.println(Thread.currentThread().getName()+"->"+num);
                    num++;
                }
                oddCondition.signal();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
public class TestOddEvenUsingLock {
    public static void main(String[] args) {
        SharePointerUsingLock sharePointer=new SharePointerUsingLock();
        Thread t1=new Thread(()-> sharePointer.printOdd());
        Thread t2=new Thread(()->sharePointer.printEven());
        t1.start();
        t2.start();
    }
}
