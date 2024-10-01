package com.kth.authTest.repository;

import com.kth.authTest.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
