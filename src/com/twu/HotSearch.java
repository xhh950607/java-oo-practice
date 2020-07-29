package com.twu;

public class HotSearch {

    private String title;
    private int heat;
    private int weight;
    private boolean isBought;
    private int price;

    private HotSearch(String title, int heat, int weight, boolean isBought, int price) {
        this.title = title;
        this.heat = heat;
        this.weight = weight;
        this.isBought = isBought;
        this.price = price;
    }

    public static HotSearch getOrdinaryHotSearch(String title){
        return new HotSearch(title, 0, 1, false, 0);
    }

    public static HotSearch getSuperHotSearch(String title){
        return new HotSearch(title, 0, 2, false, 0);
    }

    public String getTitle() {
        return title;
    }

    public int getHeat() {
        return heat;
    }

    public boolean isBought() {
        return isBought;
    }

    public void buy(int price){
        isBought = true;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void vote(int number) {
        heat += weight * number;
    }

    public boolean isSame(String title) {
        return this.title.equalsIgnoreCase(title);
    }
}
