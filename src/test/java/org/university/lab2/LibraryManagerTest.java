package org.university.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryManagerTest {
    private Library library;
    private Patron patron1;
    private Patron patron2;
    private Item book1;
    private Item book2;
    private Item dvd1;

    @BeforeEach
    void setUp(){
        library = new Library();
        patron1 = new Patron("Vasya", "2222");
        patron2 = new Patron("Petya", "4444");
        book1 = new Book("Book1", "1234", "Author1");
        book2 = new Book("Book2", "1111", "Author2");
        dvd1 = new DVD("DVD1", "0000", 86);

        library.add(book1);
        library.add(book2);
        library.add(dvd1);
        library.registerPatron(patron1);
        library.registerPatron(patron2);
    }
    @Test
    void testLendItem(){
        library.lendItem(patron1,book1);
        assertTrue(book1.isBorrowed());
        assertEquals(1, patron1.getBorrowedItems().size());
        assertTrue(patron1.getBorrowedItems().contains(book1));

        library.lendItem(patron2, dvd1);
        assertTrue(dvd1.isBorrowed());
        assertEquals(1, patron2.getBorrowedItems().size());
        assertTrue(patron2.getBorrowedItems().contains(dvd1));
    }

    @Test
    void testReturnItem(){
        library.lendItem(patron1, book1);
        library.lendItem(patron2, dvd1);

        library.returnItem(patron1, book1);
        assertFalse(book1.isBorrowed());
        assertEquals(0, patron1.getBorrowedItems().size());

        library.returnItem(patron2, dvd1);
        assertFalse(dvd1.isBorrowed());
        assertEquals(0, patron2.getBorrowedItems().size());
    }

    @Test
    void testListAvailable(){
        library.listAvailable();
        library.lendItem(patron1, book1);
        library.lendItem(patron2,dvd1);

        library.listAvailable();
    }

    @Test
    void testListBorrowed(){
        library.listBorrowed();
        library.lendItem(patron1, book1);
        library.lendItem(patron2, dvd1);

        library.listBorrowed();
    }
}
