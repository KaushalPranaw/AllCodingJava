package Comp.ReaIndia;

public class ToffeeWrapper {
    public static void main(String[] args) {
        // Example input
        int rupees = 10;

        // Calculate total toffees for given rupees
        int total = totalToffees(rupees);

        // Output the result
        System.out.println("Total toffees you can get with " + rupees + " rupees: " + total);

    }

    public static int totalToffees(int rupees) {
        int toffees = rupees;
        int wrappers = toffees;
        while (wrappers >= 3) {
            int newToffee = wrappers / 3;
            toffees += newToffee;
            wrappers = wrappers % 3 + newToffee;
        }
        return toffees;

    }
}
