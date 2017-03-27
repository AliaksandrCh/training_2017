package com.epam.training.library2017.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.epam.training.library2017.dao.impl.db.IAuthorDao;
import com.epam.training.library2017.dao.impl.db.IBookDao;
import com.epam.training.library2017.datamodel.Book;
import com.epam.training.library2017.datamodel.BookGenre;
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
            System.out.println("Insert new Book");
            if (book.getGenre() == null) {
                book.setGenre(BookGenre.fantasy);
            }
            bookDao.insert(book);
        } else {
            bookDao.update(book);
        }
    }

    @Override
    public void delete(Integer id) {
        bookDao.delete(id);

    }

    @Override
    public void saveMultiple(Book... bookAray) {

        for (Book book : bookAray) {
            save(book);
        }

    }
}
