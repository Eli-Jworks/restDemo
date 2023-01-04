package com.example.restdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestTemplateIntegration {
    private static final int BOOKID = 1;
    @Autowired
    private RestTemplate restTemplate;
    private ObjectWriter ow = new ObjectMapper().writer();
    private final Book book1 = new Book("JK", 1, "Harry Potter", "20/02/2020");
    private final Book book2 = new Book("Eli", 2, "Peter pen", "20/12/2020");
    private List<Book> books = new ArrayList<>();

    @BeforeEach
    void initialize() {
        this.books.add(book1);
        this.books.add(book2);
    }

    @Test
    @Validate
    void getAllBooks() throws Exception {
        URI uri =  new URI("http://localhost:8080/getBooks");
        ResponseEntity<List<Book>> result = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY
                ,new ParameterizedTypeReference<>() {});
        assertEquals(ow.writeValueAsString(books), ow.writeValueAsString(result.getBody()));
    }

    @Test
    @Validate
    void getBookById() throws Exception {
        String str = String.format("http://localhost:8080/getBookById/%d", BOOKID);
        URI uri =  new URI(str);
        ResponseEntity<Book> result = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY
                ,new ParameterizedTypeReference<>() {});
        assertEquals(ow.writeValueAsString(book1), ow.writeValueAsString(result.getBody()));
    }
}
