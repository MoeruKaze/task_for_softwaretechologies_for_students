package org.softwaretechnologies;

public class MilkCoffee implements CoffeeInterface {
    private CoffeeInterface coffee;

    public MilkCoffee(CoffeeInterface coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 10; // к стоимости базового напитка добавьте 10
    }

    @Override
    public String description() {
        return coffee.description() + " + milk"; // к описанию добавьте " + milk"
    }
}