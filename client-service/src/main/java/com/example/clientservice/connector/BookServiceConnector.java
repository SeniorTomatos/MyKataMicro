package com.example.clientservice.connector;


import com.example.clientservice.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "BOOK-SERVICE", fallbackFactory = BookServiceConnector.BookServiceConnectorFallback.class)
public interface BookServiceConnector {

    @GetMapping("/api/books")
    List<Book> getAllBooks();

//    @Component
//    class Fallback implements BookServiceConnector {
//        @Override
//        public List<Book> getAllBooks() {
//            return Collections.emptyList();
//        }
//    }

    @Component
    class BookServiceConnectorFallback implements FallbackFactory<FallbackWithFactory> {
        @Override
        public FallbackWithFactory create(Throwable cause) {
            return new FallbackWithFactory(cause.getMessage());
        }
    }

    @Slf4j
    class FallbackWithFactory implements BookServiceConnector {

        private final String reason;

        public FallbackWithFactory(String reason) {
            this.reason = reason;
        }

        @Override
        public List<Book> getAllBooks() {
            log.info("Failed send request on book service, reason: {}", reason);
            return Collections.emptyList();
        }
    }
}
