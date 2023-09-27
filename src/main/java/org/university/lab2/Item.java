package org.university.lab2;

import lombok.Getter;

abstract class Item {
    @Getter
    private String title;
    @Getter
    private String uniqueID;
    private boolean isBorrowed = false;

    public Item(String title, String uniqueID){
        this.title = title;
        this.uniqueID = uniqueID;
        this.isBorrowed = false;
    }

    public boolean isBorrowed(){
        return isBorrowed;
    }
    public void borrowItem(){
        isBorrowed = true;
    }
    public void returnItem(){
        isBorrowed = false;
    }
    @Override
    public String toString(){
        return "Назва: " + title + " (ID: " + uniqueID + ")";
    }
}
