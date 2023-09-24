package org.university.lab1;

import java.util.List;
// Creating a Manager class
public class Manager {
    public static void main(String[] args){
        Library library= new Library();
        // Adding books to the library
        library.addBook(new Book("The Little Prince", "Antonie Exupery", "12345", 1943) );
        library.addBook(new Book("Harry Potter", "Joan Rowling", "11111", 1997) );
        library.addBook(new Book("The Hobbit", "Tolkien", "22222", 1937) );
        // Showing all the books
        System.out.println("All Books: ");
        library.showAllBooks();
        System.out.println("\n****************");

        // Searching the book by title
        String searchByTitle = "Harry Potter";
        List<Book> searchResults = library.searchByTitle(searchByTitle);
        if (!searchResults.isEmpty()){
            System.out.println("\nResults for title '" + searchByTitle + "'");
            for (Book book : searchResults){
                System.out.println(book);
            }}
        else {
            System.out.println("\nNo book found");
        }
        System.out.println("\n****************");
        // Deleting the book by isbn
        String deleteByIsbn = "11111";
        boolean isDeleted = library.removeBook(deleteByIsbn);
        if(isDeleted){
            System.out.println("\nBook with ISBN '" + deleteByIsbn + "' is deleted.");
        } else {
            System.out.println("\nNo book found");
        }
        System.out.println("\n****************");
        // Showing the library after deleting
        System.out.println("\nAll books in library after deletion");
        library.showAllBooks();
    }
}
