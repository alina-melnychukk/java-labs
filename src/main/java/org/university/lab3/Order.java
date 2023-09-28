package org.university.lab3;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    @Getter
    private  int orderId;
    @Getter
    private  List<Product> products;
    private String status;

    public Order(){
        this.products = new ArrayList<>();
        this.status = "В обробці";
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
