package org.university.lab2;

public class Book extends Item {
    private final String author;
    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }
    @Override
    public String toString(){
        return "Автор: " + super.toString();
    }
}
