package hu.unideb.inf.model;

import java.util.List;
import java.util.Objects;

public class Drink {
    private String name;
    private int price;

    public static Drink scannedDrink(DrinkDataReader drink){
        String name;
        int price;
        name = drink.getName();
        price = drink.getPrice();
        return new Drink(name, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Drink other = (Drink) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

    public Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drink{" + "name=" + name + ", price=" + price + '}';
    }
}
