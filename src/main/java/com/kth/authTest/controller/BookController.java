package com.kth.authTest.controller;

import com.kth.authTest.dao.Book;
import com.kth.authTest.service.booAuthor.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public String create(@RequestBody Book request){
        return service.create(request);
    }

    @GetMapping
    public List<Book> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> getById(@PathVariable int id){
        return service.getById(id);
    }
}
