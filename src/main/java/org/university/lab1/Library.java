package org.university.lab1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// Creating a class Library
public class Library {
    private List<Book> books;
    // Creating a library
    public Library(){
        books = new ArrayList<>();
    }
    // Method to add some new books to the library
    public void addBook(Book book){
        books.add(book);
    }
    // Method to show out all books in the library
    public void showAllBooks(){
        for(Book book : books){
            System.out.println(book);
        }
    }
    // Method for searching book by it`s title
    public List<Book> searchByTitle(String title){
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                matchingBooks.add(book);
            }
        } return matchingBooks;
    }
    // Method to remove book by it`s ISBN
    public boolean removeBook(String isbn){
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if(book.getIsbn().equalsIgnoreCase(isbn)){
                iterator.remove();
                return true;
            }
        } return false;
    }
}