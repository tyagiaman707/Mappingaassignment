package com.example.Mapping.Controller;

import com.example.Mapping.Model.Book;
import com.example.Mapping.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public Book addBook(@RequestBody String book) {
        return bookService.addBook(book);
    }

    @GetMapping("/book")
    public List<Book> getBook(@Nullable @RequestParam String bookId) {
        return  bookService.findByBook(bookId);
    }}