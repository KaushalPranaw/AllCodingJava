package DesignPatterns.Creational.Builder;

public class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public void showDetails() {
        System.out.println("Computer Details:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + storage);
        System.out.println("GPU: " + GPU);
    }

}
