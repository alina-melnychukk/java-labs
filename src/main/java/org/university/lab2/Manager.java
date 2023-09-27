package org.university.lab2;

public class Manager {
    public static void main(String[] args){
        Library library = new Library();

        Item book1 = new Book("Book1", "1234", "Author1");
        Item book2 = new Book("Book2", "1111", "Author2");
        Item dvd1 = new DVD("DVD1", "0000", 86);
        library.add(book1);
        library.add(book2);
        library.add(dvd1);

        Patron patron1 = new Patron("Vasya", "2222");
        Patron patron2 = new Patron("Petya", "4444");
        library.registerPatron(patron1);
        library.registerPatron(patron2);

        library.lendItem(patron1, book1);
        library.lendItem(patron2,dvd1);
        library.listAvailable();
        library.listBorrowed();
        library.returnItem(patron1, book1);
        library.returnItem(patron2, dvd1);
        library.listBorrowed();
    }
}
