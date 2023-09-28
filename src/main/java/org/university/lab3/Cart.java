package org.university.lab3;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Cart {
    private final List<Product> products;
    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
    public void placeOrder(Order order){
        order.setProducts(this.products);
        order.setStatus("Замовлення розміщено");
        this.products.clear();
    }
}
