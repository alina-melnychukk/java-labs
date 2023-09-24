## Лабораторна робота 1
1. Розроблено програму мовою Java для керування простою бібліотекою. У бібліотеці є книги, і кожна книга має такі властивості:

- Назва 
- Автор
- Номер ISBN
- Рік видання

Програма має такий функціонал:

* Додає нову книгу в бібліотеку.
* Показує всі книги в бібліотеці.
* Шукає книгу за її назвою.
* Видаляє книгу з бібліотеки за її номером ISBN.

2. Програма покрита тестами.

During completing my first lab i`d created 4 classes : Book, Library, Manager, LibraryTest. Each class had next TODO`s
Library:
•	Creating a class Library
•	Creating a library
•	Method to add some new books to the library
•	Method to show out all books in the library
•	Method for searching book by it`s title
•	Method to remove book by it`s ISBN
Book:
•	Creating a class of Book
•	Creating a constructor to initialize a Book
•	Getters to find out an information about books
•	Overriding toString method
Manager:
•	Creating a Manager class
•	Adding books to the library
•	Showing all the books
•	Searching the book by title
•	Deleting the book by isbn
•	Showing the library after deleting
LibraryTest:
•	Test searching for a book by its title
•	Test searching for a non-existent book by its title
•	Test removing a book by its ISBN
•	est removing a non-existent book by its ISBN