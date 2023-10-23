package org.university.lab7;

import lombok.Getter;

@Getter
public class Product implements Comparable<Product>{
    private Integer id;
    private String name;
    private double price;
    private int stock;

    public Product(Integer id, String name, double price, int stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public int compareTo(Product other){
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString(){
        return  "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
    }

}
