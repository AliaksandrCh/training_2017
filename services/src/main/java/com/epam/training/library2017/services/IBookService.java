package com.epam.training.library2017.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.epam.training.library2017.dao.api.filter.BookFilter;
import com.epam.training.library2017.datamodel.Book;

public interface IBookService {

    Book get(Integer id);

    @Transactional
    void save(Book book);

    @Transactional
    void saveMultiple(Book... book);

    List<Book> getAll();

    @Transactional
    void delete(Integer id);

    List<Book> search(BookFilter bookFilter);
}
