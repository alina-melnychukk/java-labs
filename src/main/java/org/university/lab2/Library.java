package org.university.lab2;

import java.util.ArrayList;
import java.util.List;

public class Library implements IManagable{
    private List<Item> items;
    private List<Patron> patrons;

    public Library(){
        this.items = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }
    @Override
    public void add(Item item){
        items.add(item);
    }
    @Override
    public void remove(Item item){
        items.remove(item);
    }
    @Override
    public void listAvailable(){
        System.out.println("Доступні позиції: ");
        for (Item item : items){
            if (!item.isBorrowed()){
                System.out.println(item);
            }
        }
    }
    @Override
    public void listBorrowed(){
        System.out.println("Зайняті позиції: ");
        for (Patron patron : patrons){
            List<Item> borrowedItems = patron.getBorrowedItems();
            for (Item item : borrowedItems){
                System.out.println(item + " знаходиться у " + patron.getName());
            }
        }
    }
    public void registerPatron(Patron patron){
        patrons.add(patron);
    }
    public void lendItem(Patron patron, Item item){
        if(!item.isBorrowed()){
            patron.borrow(item);
            item.borrowItem();
            System.out.println(item + " знаходиться у " + patron.getName());
        } else {
            System.out.println(item + " вже позичений");
        }
    }
    public void returnItem(Patron patron, Item item){
        if (patron.getBorrowedItems().contains(item)){
            patron.returnItem(item);
            item.returnItem();
            System.out.println(item + " повернений таким користувачем: " + patron.getName());
        } else {
            System.out.println(patron.getName() + " не позичав" + item);
        }
    }

}
