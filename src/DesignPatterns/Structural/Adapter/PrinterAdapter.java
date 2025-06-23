package DesignPatterns.Structural.Adapter;

public class PrinterAdapter implements NewPrinter {
    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String text) {
        oldPrinter.printOldFormat(text);  // Call the old system's method
    }
}
