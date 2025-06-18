package com.nivz.lab5_2.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String description;
    private int imageResId;

    public Product(String name, String description, int imageResId) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getImageResId() { return imageResId; }
}

