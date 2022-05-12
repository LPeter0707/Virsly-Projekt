package hu.unideb.inf.model;

import java.util.ArrayList;
import java.util.List;

public class Food {
    private String name;
    private List<String> list = new ArrayList<>();
    private int price;

    public Food(String name, List<String> list, int price) {
        this.name = name;
        this.list = list;
        this.price = price;
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

}
