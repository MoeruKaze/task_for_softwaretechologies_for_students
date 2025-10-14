package org.softwaretechnologies;

public class Coffee implements CoffeeInterface {
    @Override
    public int getCost() {
        return 50; // стоимость базового напитка равна 50
    }

    @Override
    public String description() {
        return "only coffee"; // описание "only coffee"
    }
}