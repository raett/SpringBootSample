package com.cko.sampleSpringProject.dao;

import com.cko.sampleSpringProject.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDAO extends CrudRepository<Book, Long> {
    List<Book> findAll();
    Book findBooksById(long id);
}
