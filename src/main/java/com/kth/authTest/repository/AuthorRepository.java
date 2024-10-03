package com.kth.authTest.repository;

import com.kth.authTest.dao.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query("SELECT Author a FROM AUTHOR ")
    boolean existsByName(@Param("name") String name);
}
