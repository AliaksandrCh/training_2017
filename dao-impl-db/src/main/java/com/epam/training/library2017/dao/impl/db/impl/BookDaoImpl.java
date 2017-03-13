package com.epam.training.library2017.dao.impl.db.impl;

import org.springframework.stereotype.Repository;

import com.epam.training.library2017.dao.impl.db.IBookDao;
import com.epam.training.library2017.datamodel.Book;

@Repository
public class BookDaoImpl implements IBookDao {

    @Override
    public Book get(Integer id) {
        // TODO go to DB
        Book book = new Book();
        book.setId(id);
        return book;
    }

    @Override
    public void insert(Book book) {
    }

    @Override
    public void update(Book book) {
    }

}
