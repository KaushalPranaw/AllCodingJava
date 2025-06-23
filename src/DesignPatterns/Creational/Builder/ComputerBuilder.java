package DesignPatterns.Creational.Builder;

public class ComputerBuilder {
    private Computer computer;

    public ComputerBuilder() {
        this.computer = new Computer();
    }

    public ComputerBuilder cpu(String CPU) {
        computer.setCPU(CPU);
        return this;
    }

    public ComputerBuilder ram(String RAM) {
        computer.setRAM(RAM);
        return this;
    }

    public ComputerBuilder storage(String storage) {
        computer.setStorage(storage);
        return this;
    }

    public ComputerBuilder gpu(String GPU) {
        computer.setGPU(GPU);
        return this;
    }

    public Computer build() {
        return computer;
    }

}
