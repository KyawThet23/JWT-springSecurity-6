package com.kth.authTest.service.booAuthor.impl;

import com.kth.authTest.dao.Book;
import com.kth.authTest.repository.BookRepository;
import com.kth.authTest.service.booAuthor.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public String create(Book request) {
        repository.save(request);
        return "Success";
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> getById(int id) {
        return repository.findById(id);
    }
}
