package com.example.clientservice.service.impl;


import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.model.Book;
import com.example.clientservice.service.ClientBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ClientBookServiceImpl implements ClientBookService {

    private final BookServiceConnector feignClient;


    public List<Book> getAllBooks() {
        return feignClient.getAllBooks();
    }
}
