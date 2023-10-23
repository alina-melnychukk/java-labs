package org.university.lab7;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
@Getter
public class ECommercePlatform {
    private Map<Integer, User> users;
    public Map<Integer, Product> products;
    public Map<Integer, Order> orders;

    public ECommercePlatform() {
        users = new HashMap<>();
        products = new HashMap<>();
        orders = new HashMap<>();
    }
    public ECommercePlatform(Map<Integer, User> users, Map<Integer, Product> products, Map<Integer, Order> orders) {
        this.users = users;
        this.products = products;
        this.orders = orders;
    }
    public void addUser(User user){
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }
    public Order createOrder(int userId) {
        if (users.containsKey(userId)) {
            Order order = new Order(generateOrderId(), userId);
            orders.put(order.getId(), order);
            return order;
        } else {
            throw new IllegalArgumentException("User with ID " + userId + " does not exist.");
        }
    }
    private int generateOrderId() {
        return orders.size() + 1;
    }
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(1, "User1");
        User user2 = new User(2, "User2");
        platform.addUser(user1);
        platform.addUser(user2);

        Product product1 = new Product(1, "Product1", 10.0, 100);
        Product product2 = new Product(2, "Product2", 15.0, 50);
        platform.addProduct(product1);
        platform.addProduct(product2);

        user1.addToCart(product1, 5);
        user2.addToCart(product2, 3);

        Order order1 = platform.createOrder(user1.getId());
        order1.addProductToOrder(product1, 5);

        Order order2 = platform.createOrder(user2.getId());
        order2.addProductToOrder(product2, 3);

        System.out.println("Users: " + platform.users.values());
        System.out.println("Products: " + platform.products.values());
        System.out.println("Orders: " + platform.orders.values());
    }

    public List<Product> sortProductsByName() {
        List<Product> sortedProducts = new ArrayList<>(products.values());
        sortedProducts.sort(Comparator.comparing(Product::getName));
        return sortedProducts;
    }

    public List<Product> sortProductsByPrice() {
        List<Product> sortedProducts = new ArrayList<>(products.values());
        sortedProducts.sort(Comparator.comparing(Product::getPrice));
        return sortedProducts;
    }

    public List<Product> sortProductsByStock() {
        List<Product> sortedProducts = new ArrayList<>(products.values());
        sortedProducts.sort(Comparator.comparing(Product::getStock));
        return sortedProducts;
    }

    public List<Product> filterProductsInStock() {
        List<Product> availableProducts = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getStock() > 0) {
                availableProducts.add(product);
            }
        }
        return availableProducts;
    }

    public List<Product> recommendProductsForUser(User user) {
        List<Product> recommendedProducts = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : user.getCart().entrySet()) {
            if (entry.getValue() > 0) {
                recommendedProducts.add(entry.getKey());
            }
        }
        for (Order order : orders.values()) {
            if (Objects.equals(order.getUserId(), user.getId())) {
                for (Map.Entry<Product, Integer> entry : order.getOrderDetails().entrySet()) {
                    if (entry.getValue() > 0) {
                        recommendedProducts.add(entry.getKey());
                    }
                }
            }
        }
        recommendedProducts = recommendedProducts.stream()
                .distinct()
                .collect(Collectors.toList());

        return recommendedProducts;
    }
}
