package org.university.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static junit.framework.Assert.*;


public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp(){
        library = new Library();
        library.addBook(new Book("The Little Prince", "Antonie Exupery", "12345", 1943) );
        library.addBook(new Book("Harry Potter", "Joan Rowling", "11111", 1997) );
        library.addBook(new Book("The Hobbit", "Tolkien", "22222", 1937) );
    }
    // Test searching for a book by its title
    @Test
    public void testSearchByTitle(){
        String searchTitle = "Harry Potter";
        List<Book> searchResults = library.searchByTitle(searchTitle);
        assertEquals(1,searchResults.size());
        assertEquals("Harry Potter", searchResults.get(0).getTitle());
    }
    // Test searching for a non-existent book by its title
    @Test
    public void testSearchByTitleNotFound(){
        String searchTitle = "NoBook";
        List<Book> searchResults = library.searchByTitle(searchTitle);
        assertEquals(0, searchResults.size());
    }
    // Test removing a book by its ISBN
    @Test
    public void testRemoveBookByIsbn() {
        String iterator = "11111";
        boolean isDeleted;
        if (library.removeBook(iterator)) isDeleted = true;
        else isDeleted = false;
        assertTrue(isDeleted);
        List<Book> searchResults = library.searchByTitle("Harry Potter");
    }
    // Test removing a non-existent book by its ISBN
    @Test
    public void testRemoveBookByIsbnNotFound(){
        String deleteByIsbn = "No book found";
        boolean isDeleted = library.removeBook(deleteByIsbn);
        assertFalse(isDeleted);
    }
}
