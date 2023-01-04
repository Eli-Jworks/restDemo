package com.example.restdemo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

public class Book {
    @NotEmpty
    private String author;
    private int id;
    @NotEmpty
    private String title;
    @DateFormatValid
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public Book(String author, int id, String title, String date) {
        this.author = author;
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int pages) {
        this.id = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
