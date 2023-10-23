package org.university.lab7;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Getter
public class Order {
    private Integer id;
    private Integer userId;
    private Map<Product, Integer> orderDetails;
    private double totalPrice;

    public Order(Integer id, Integer userId){
        this.id = id;
        this.userId = userId;
        this.orderDetails = new HashMap<>();
        this.totalPrice = 0.0;
    }

    public void addProductToOrder(Product product, int quantity){
        orderDetails.put(product, quantity);
        totalPrice += product.getPrice() * quantity;
    }

    @Override
    public String toString(){
        return "Order [id=" + id + ", userId=" + userId + ", orderDetails=" + orderDetails + ", totalPrice=" + totalPrice + "]";
    }
}
