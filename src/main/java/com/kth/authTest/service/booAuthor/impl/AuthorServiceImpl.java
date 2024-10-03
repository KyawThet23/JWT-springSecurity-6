package com.kth.authTest.service.booAuthor.impl;

import com.kth.authTest.dao.Author;
import com.kth.authTest.dto.AuthorInput;
import com.kth.authTest.repository.AuthorRepository;
import com.kth.authTest.service.booAuthor.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository repository;

    @Override
    public String save(AuthorInput request) {

        if(existsById(1)) return "";
        return "";
    }

    @Override
    public String delete(int id) {
        return "";
    }

    @Override
    public Author findById(int id) {
        return null;
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public List<Author> findAll() {
        return List.of();
    }
}
