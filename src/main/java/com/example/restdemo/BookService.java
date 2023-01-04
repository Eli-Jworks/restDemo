package com.example.restdemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private Book book1 = new Book("JK", 1, "Harry Potter", "20/02/2020");
    private Book book2 = new Book("Eli", 2, "Peter pen", "20/12/2020");
    private List<Book> books = new ArrayList<>();

    public BookService() {
        this.books.add(book1);
        this.books.add(book2);

    }
        public List<Book> getBooks(){
            return this.books;
        }

        public Book getBookById(int id) {
            for(Book book: books) {
                if (book.getId() == id) {
                    return book;
                }
            }
            return null;
        }

    public Book getBookByTitle(String title) {
        for(Book book: books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public String addBook(Book book) {
        this.books.add(book);
        return "Book added succesfully!" + book.toString();
    }
}
