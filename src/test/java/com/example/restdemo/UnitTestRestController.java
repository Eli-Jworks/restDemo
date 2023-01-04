package com.example.restdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)

public class UnitTestRestController {
    @Mock
    private BookService bookService;
    @Mock
    private LocalTimeValidator validator;
    @InjectMocks
    private Controller controller;
    private MockMvc mockMvc;
    private final Book book1 = new Book("JK", 1, "Harry Potter", "20-02-2020");
    private final Book book2 = new Book("Eli", 2, "Peter pen", "20/12/2020");
    private List<Book> books = new ArrayList<>();
    private ObjectWriter ow = new ObjectMapper().writer();
    @BeforeEach
    void initializeMock() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        this.books.add(book1);
        this.books.add(book2);
    }

    @Test
    void getAllBooks() throws Exception {
        Mockito.when(bookService.getBooks()).thenReturn(books);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getBooks")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(ow.writeValueAsString(books), mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getBookById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getBookById/{id}", 1)).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(mvcResult.getResponse().getContentAsString(), controller.getBookById(1).toString());
    }
}
