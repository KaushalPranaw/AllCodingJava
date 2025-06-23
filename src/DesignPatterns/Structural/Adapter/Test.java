package DesignPatterns.Structural.Adapter;

public class Test {
    public static void main(String[] args) {
        OldPrinter oldPrinter=new OldPrinter();
        NewPrinter printerAdapter=new PrinterAdapter(oldPrinter);
        printerAdapter.print("Hello World!");
    }
}
