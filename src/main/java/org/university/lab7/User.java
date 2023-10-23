package org.university.lab7;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Getter
public class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;

    public User(Integer id, String username){
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }

    public void addToCart(Product product, int quantity){
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void removeFromCart(Product product, int quantity){
        if (cart.containsKey(product)){
            int currentQuantity = cart.get(product);
            if (currentQuantity > quantity) {
                cart.put(product, currentQuantity - quantity);
            } else {
                cart.remove(product);
            }
        }
    }

    public void modifyCart(Product product, int quantity){
        cart.put(product, quantity);
    }

    @Override
    public String toString(){
        return "User [id=" + id + ", username=" + username + ", cart=" + cart + "]";
    }
}
