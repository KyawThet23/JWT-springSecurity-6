package com.kth.authTest.service.booAuthor;

import com.kth.authTest.dao.Author;
import com.kth.authTest.dto.AuthorInput;

import java.util.List;

public interface AuthorService {

    String save(AuthorInput request);

    String delete(int id);

    Author findById(int id);

    boolean existsById(int id);

    List<Author> findAll();
}
