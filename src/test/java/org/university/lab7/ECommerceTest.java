package org.university.lab7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ECommerceTest {
    private ECommercePlatform platform;

    @BeforeEach
    void setUp(){
        platform = new ECommercePlatform();
    }

    @Test
    void testSortProductsByName(){
        Product product1 = new Product(1, "Banana", 1.0, 100);
        Product product2 = new Product(2, "Apple", 2.0, 50);
        Product product3 = new Product(3, "Orange", 1.5, 75);

        platform.products.put(product1.getId(), product1);
        platform.products.put(product2.getId(), product2);
        platform.products.put(product3.getId(), product3);

        assertEquals("Apple", platform.sortProductsByName().get(0).getName());
        assertEquals("Banana", platform.sortProductsByName().get(1).getName());
        assertEquals("Orange", platform.sortProductsByName().get(2).getName());
    }

    @Test
    void testSortProductsByPrice() {
        Product product1 = new Product(1, "Banana", 1.0, 100);
        Product product2 = new Product(2, "Apple", 2.0, 50);
        Product product3 = new Product(3, "Orange", 1.5, 75);

        platform.products.put(product1.getId(), product1);
        platform.products.put(product2.getId(), product2);
        platform.products.put(product3.getId(), product3);

        assertEquals(1.0, platform.sortProductsByPrice().get(0).getPrice(), 0.01);
        assertEquals(1.5, platform.sortProductsByPrice().get(1).getPrice(), 0.01);
        assertEquals(2.0, platform.sortProductsByPrice().get(2).getPrice(), 0.01);
    }

    @Test
    void testSortProductsByStock() {
        Product product1 = new Product(1, "Banana", 1.0, 100);
        Product product2 = new Product(2, "Apple", 2.0, 50);
        Product product3 = new Product(3, "Orange", 1.5, 75);

        platform.products.put(product1.getId(), product1);
        platform.products.put(product2.getId(), product2);
        platform.products.put(product3.getId(), product3);

        assertEquals(50, platform.sortProductsByStock().get(0).getStock());
        assertEquals(75, platform.sortProductsByStock().get(1).getStock());
        assertEquals(100, platform.sortProductsByStock().get(2).getStock());
    }

    @Test
    void testFilterProductsInStock() {
        Product product1 = new Product(1, "Banana", 1.0, 100);
        Product product2 = new Product(2, "Apple", 2.0, 0);
        Product product3 = new Product(3, "Orange", 1.5, 50);

        platform.products.put(product1.getId(), product1);
        platform.products.put(product2.getId(), product2);
        platform.products.put(product3.getId(), product3);

        assertEquals(2, platform.filterProductsInStock().size());
        assertTrue(platform.filterProductsInStock().contains(product1));
        assertTrue(platform.filterProductsInStock().contains(product3));
    }

    @Test
    void testRecommendProductsForUser() {
        User user = new User(1, "User1");

        Product product1 = new Product(1, "Banana", 1.0, 100);
        Product product2 = new Product(2, "Apple", 2.0, 0);
        Product product3 = new Product(3, "Orange", 1.5, 50);

        platform.products.put(product1.getId(), product1);
        platform.products.put(product2.getId(), product2);
        platform.products.put(product3.getId(), product3);

        user.addToCart(product1, 3);
        user.addToCart(product3, 2);

        Order order = new Order(1, user.getId());
        order.addProductToOrder(product1, 3);
        platform.orders.put(order.getId(), order);

        assertEquals(2, platform.recommendProductsForUser(user).size());
        assertTrue(platform.recommendProductsForUser(user).contains(product1));
        assertTrue(platform.recommendProductsForUser(user).contains(product3));
    }

    @Test
    void testAddUser() {
        User user = new User(1, "User1");
        platform.addUser(user);
        assertTrue(platform.getUsers().containsKey(user.getId()));
    }
    @Test
    void testAddProduct() {
        Product product = new Product(1, "Banana", 1.0, 100);
        platform.addProduct(product);
        assertTrue(platform.getProducts().containsKey(product.getId()));
    }

    @Test
    void testCreateOrder() {
        User user = new User(1, "User1");
        Product product = new Product(1, "Banana", 1.0, 100);
        platform.addUser(user);
        platform.addProduct(product);

        Order order = platform.createOrder(user.getId());
        assertNotNull(order);
        assertEquals(user.getId(), order.getUserId());
    }
}



