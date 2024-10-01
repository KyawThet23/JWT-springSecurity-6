package com.kth.authTest.service.booAuthor;

import com.kth.authTest.dao.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {

    String create(Book request);

    List<Book> getAll();

    Optional<Book> getById(int id);
}
