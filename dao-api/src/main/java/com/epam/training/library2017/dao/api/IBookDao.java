package com.epam.training.library2017.dao.api;

import java.util.List;

import com.epam.training.library2017.dao.api.filter.BookFilter;
import com.epam.training.library2017.datamodel.Book;

public interface IBookDao {

    Book get(Integer id);

    Book insert(Book book);

    void update(Book book);

    List<Book> getAll();

    void delete(Integer id);

    List<Book> search(BookFilter bookFilter);
}
