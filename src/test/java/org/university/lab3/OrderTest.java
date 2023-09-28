package org.university.lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class OrderTest {
    private Cart cart;
    private Order order;
    private Product product1;
    private Product product2;
    @BeforeEach
    void setUp(){
        cart = new Cart();
        order = new Order();
        product1 = new Product(1, "Product 1", 150.0);
        product2 = new Product(2, "Product 2", 10.99);
    }
    @Test
    void testAddProductToCart(){
        cart.addProduct(product1);
        cart.addProduct(product2);

        assertEquals(2, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }
    @Test
    void testRemoveProduct(){
        cart.addProduct(product1);
        cart.addProduct(product2);

        cart.removeProduct(product1);

        assertEquals(1, cart.getProducts().size());
        assertFalse(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }
    @Test
    void testPlaceOrder() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        Cart cartMock = spy(cart);
        doNothing().when(cartMock).placeOrder(order);

        cartMock.placeOrder(order);

        assertEquals(0, cart.getProducts().size());
        assertEquals(2, order.getProducts().size());
        assertEquals("Замовлення розміщено", order.getStatus());
    }
}
