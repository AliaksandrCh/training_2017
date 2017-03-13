package com.epam.training.library2017.dao.impl.db;

import com.epam.training.library2017.datamodel.Book;

public interface IBookDao {

    Book get(Integer id);

    void insert(Book book);

    void update(Book book);
}
