package CoreJava.OOPS.StringExamples;

public class TestStringBuffer {
    public static void main(String[] args) {
        /*StringBuffer str = new StringBuffer("Hello");
        str.append(" World");
        System.out.println(str.toString());*/

        StringBuffer sb=new StringBuffer();
        Runnable task=()->{
            for(int i=0;i<5;i++){
                sb.append(" ").append(i);
            }
            System.out.println(sb.toString());
        };

        Thread t1=new Thread(task);
        Thread t2=new Thread(task);

        t1.start();
        t2.start();

    }
}
