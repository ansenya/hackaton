package ru.packetSolution.hack.domain.model;



public class Product {
    private int id;
    private String name;
    private int user_id;
    private String product_location;
    private int likes;
    private int views;
    private String cost;
    private String product_photo_url;
    private String description;

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
                ", product_photo_url='" + product_photo_url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }


    public String getProduct_photo_url() {
        return product_photo_url;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getUser_id() {
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

    public Product(int id, String name, int user_id, String product_location, int likes, int views, String cost, String product_photo_url, String description) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
        this.product_location = product_location;
        this.likes = likes;
        this.views = views;
        this.cost = cost;
        this.product_photo_url = product_photo_url;
        this.description = description;
    }


}
