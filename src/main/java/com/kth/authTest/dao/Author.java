package com.kth.authTest.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String genre;
    @NotBlank
    private int age;

    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "author",
               orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);
    }
    public void removeBook(Book book) {
        book.setAuthor(null);
        this.books.remove(book);
    }
    public void removeBooks() {
        Iterator<Book> iterator = this.books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            book.setAuthor(null);
            iterator.remove();
        }
    }

}