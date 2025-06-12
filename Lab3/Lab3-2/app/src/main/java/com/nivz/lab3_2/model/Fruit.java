package com.nivz.lab3_2.model;

public class Fruit {
    private String name;
    private String description;
    private int imageId;

    public Fruit(String name, String description, int imageId) {
        this.name = name;
        this.description = description;
        this.imageId = imageId;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getImageId() { return imageId; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
}