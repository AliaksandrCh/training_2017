package com.epam.training.library2017.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.epam.training.library2017.dao.impl.db.IAuthorDao;
import com.epam.training.library2017.dao.impl.db.IBookDao;
import com.epam.training.library2017.datamodel.Book;
import com.epam.training.library2017.services.IAuthorService;
import com.epam.training.library2017.services.IBookService;

@Service
public class BookServiceImpl implements IBookService {

    @Inject
    private IBookDao bookDao;

    @Inject
    private IAuthorDao authorDao;

    @Inject
    private IAuthorService authorService;

    @Override
    public Book get(Integer id) {
        return bookDao.get(id);
    }

    @Override
    public void save(Book book) {
        if (book.getId() == null) {
            System.out.println("Insert new Book");
            bookDao.insert(book);
        } else {
            bookDao.update(book);
        }
    }
}
