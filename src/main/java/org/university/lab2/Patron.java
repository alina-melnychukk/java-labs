package org.university.lab2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    @Getter
    private String name;
    @Getter
    private String ID;
    public List<Item> borrowedItems;
    public Patron(String name, String ID){
        this.name = name;
        this.ID = ID;
        this.borrowedItems = new ArrayList<>();
    }
    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }
    public void borrow(Item item){
        borrowedItems.add(item);
    }
    public void returnItem(Item item){
        borrowedItems.remove(item);
    }
    @Override
    public String toString(){
        return "Користувач: " + name + " (ID: " + ID + ")";
    }
}
