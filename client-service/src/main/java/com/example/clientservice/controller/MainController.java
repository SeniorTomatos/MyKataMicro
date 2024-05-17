package com.example.clientservice.controller;


import com.example.clientservice.model.Book;
import com.example.clientservice.service.ClientBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class MainController {

    private final ClientBookService service;

    @GetMapping("/books")
    public List<Book> getAllBooksFromClient() {
        return service.getAllBooks();
    }

    @GetMapping("/test")
    public String test() {
        return "main-service";
    }


}
