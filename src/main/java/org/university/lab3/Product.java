package org.university.lab3;

import lombok.Getter;


@Getter
public class Product {
    private final int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Product product, int id) {
        this(id, product.name, product.price);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
