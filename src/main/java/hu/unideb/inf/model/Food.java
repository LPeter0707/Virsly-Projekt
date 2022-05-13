package hu.unideb.inf.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Food {
    private String name;
    private List<String> list = new ArrayList<>();
    private int price;

    public static Food scannedFood(FoodDataReader food){
        String name;
        List<String> list;
        int price;
        name = food.getName();
        list = food.getList();
        price = food.getPrice();
        return new Food(name, list, price);
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
        final Food other = (Food) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.list, other.list)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }
    public Food(String name, List<String> list, int price) {
        this.name = name;
        this.list = list;
        this.price = price;
    }

    public Food()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" + "name=" + name + ", list=" + list + ", price=" + price + '}';
    }

}
