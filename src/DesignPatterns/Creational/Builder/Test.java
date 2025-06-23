package DesignPatterns.Creational.Builder;

public class Test {
    public static void main(String[] args) {
        // Create a custom computer using the builder pattern
        Computer gamingPC = new ComputerBuilder()
                .cpu("Intel i9")
                .ram("32GB")
                .storage("1TB SSD")
                .build();
        gamingPC.showDetails();  // Show details of the custom computer
        // Create another computer (e.g., office computer)
        Computer officePC = new ComputerBuilder()
                .cpu("Intel i5")
                .ram("8GB")
                .storage("512GB SSD")
                .gpu("Integrated Graphics")
                .build();
        officePC.showDetails();

    }
}
