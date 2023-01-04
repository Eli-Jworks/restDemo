package com.example.restdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class Controller {
    private final BookService bookService;

    public Controller(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getBooks")
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }
    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/getBookByTitle/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    @PostMapping("/addBook")
    public String addBook(@RequestBody @Valid Book book) {
        return bookService.addBook(book);
    }
}
