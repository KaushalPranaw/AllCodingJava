package DesignPatterns.Structural.Proxy;


//Middle man
public class Proxy {
    private RealSubject realSubject;
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();  // Only create when needed
        }
        realSubject.request();
    }

}
