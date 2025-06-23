package DesignPatterns.Structural.Decorator;

public class Test {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();  // Start with a basic coffee
        System.out.println("Cost of basic coffee: $" + coffee.cost());

        // Add milk to the coffee
        coffee = new MilkDecorator(coffee);
        System.out.println("Cost after adding milk: $" + coffee.cost());

        // Add sugar to the coffee
        coffee = new SugarDecorator(coffee);
        System.out.println("Cost after adding sugar: $" + coffee.cost());

        // Add whipped cream to the coffee
        coffee = new WhippedCreamDecorator(coffee);
        System.out.println("Cost after adding whipped cream: $" + coffee.cost());

    }
}
