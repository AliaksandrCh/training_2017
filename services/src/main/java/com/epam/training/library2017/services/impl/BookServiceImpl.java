package com.epam.training.library2017.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.epam.training.library2017.dao.api.IAuthorDao;
import com.epam.training.library2017.dao.api.IBookDao;
import com.epam.training.library2017.dao.api.filter.BookFilter;
import com.epam.training.library2017.datamodel.Book;
import com.epam.training.library2017.datamodel.BookGenre;
import com.epam.training.library2017.services.IAuthorService;
import com.epam.training.library2017.services.IBookService;

@Service
public class BookServiceImpl implements IBookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    @Inject
    private IBookDao bookDao;

    @Inject
    private IAuthorDao authorDao;

    @Inject
    private IAuthorService authorService;

    @Value("${key1}")
    private String key1;

    @Value("${key2}")
    private Integer key2;

    @Override
    public Book get(Integer id) {
        return bookDao.get(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public void save(Book book) {
        if (book.getId() == null) {

            if (book.getGenre() == null) {
                book.setGenre(BookGenre.fantasy);
            }

            bookDao.insert(book);

            LOGGER.info("Insert new Book.id={}. genre={}. title={}", book.getId(), book.getGenre(), book.getTitle());
        } else {
            bookDao.update(book);
        }
    }

    @Override
    public void delete(Integer id) {
        bookDao.delete(id);
        LOGGER.info("delete  BookId:" + id);
    }

    @Override
    public void saveMultiple(Book... bookAray) {

        for (Book book : bookAray) {
            LOGGER.debug("Insert new Book from array:" + book);
            save(book);
        }

    }

    @Override
    public List<Book> search(BookFilter bookFilter) {
        return bookDao.search(bookFilter);
    }
}
