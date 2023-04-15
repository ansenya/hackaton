package ru.packetSolution.hack.model;



public class Product {
    private int id;
    private String name;
    private User user_id;
    private String product_location;
    private int likes;
    private int views;
    private String cost;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user_id=" + user_id +
                ", product_location='" + product_location + '\'' +
                ", likes=" + likes +
                ", views=" + views +
                ", cost='" + cost + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getUser_id() {
        return user_id;
    }

    public String getProduct_location() {
        return product_location;
    }

    public int getLikes() {
        return likes;
    }

    public int getViews() {
        return views;
    }

    public String getCost() {
        return cost;
    }

    public Product(int id, String name, User user_id, String product_location, int likes, int views, String cost) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
        this.product_location = product_location;
        this.likes = likes;
        this.views = views;
        this.cost = cost;
    }
}
