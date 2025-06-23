package ProblemSolving.Sorting;

public class Deadlock {
    private static class Resource {
        String name;

        public Resource(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Resource resource1 = new Resource("r1");
        Resource resource2 = new Resource("r2");
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + resource1.name);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() +"waiting"+ resource2.name);
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + resource2.name);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + resource2.name);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() +"waiting"+ resource1.name);
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + resource1.name);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
