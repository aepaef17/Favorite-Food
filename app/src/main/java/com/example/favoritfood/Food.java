package com.example.favoritfood;

public class Food {
    private String name;
    private float rate;
    private double price;
    private boolean fave;

    public Food(String name, float rate, double price, boolean fave) {
        this.name = name;
        this.rate = rate;
        this.price = price;
        this.fave = fave;
    }

    public String getName() {
        return name;
    }

    public float getRate() {
        return rate;
    }

    public double getPrice() {
        return price;
    }

    public boolean isFave() {
        return fave;
    }
}
