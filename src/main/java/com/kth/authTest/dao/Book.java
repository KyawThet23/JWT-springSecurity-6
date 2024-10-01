package com.kth.authTest.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.ISBN;

import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Book implements Serializable {

    private Long id;

    @NotBlank(message = "Book title must not be blank.")
    private String title;
    @ISBN
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
}
