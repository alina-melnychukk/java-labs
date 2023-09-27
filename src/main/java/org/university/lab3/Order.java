package org.university.lab3;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Order {
    public enum Status {
        CREATED, IN_PROGRESS, COMPLETED, CANCELED
    }

    private final int id;
    private final List<Product> products;
    private Status status;

    public Order(int id, List<Product> products) {
        this.id = id;
        this.products = Collections.unmodifiableList(products);
        this.status = Status.CREATED;
    }
    public Order(Order order) {
        this.id = order.id;
        this.products = new ArrayList<>(order.products);
        this.status = order.status;
    }

    public void setStatus(Status Status) {
        this.status = Status;
    }

}
