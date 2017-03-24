package com.epam.training.library2017.services;

import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.util.Assert;

import com.epam.training.library2017.datamodel.Book;

public class BookServiceTest extends AbstractTest {

    @Inject
    private IBookService service;

    @Test
    public void createTest() {
        Book book = new Book();
        book.setTitle("new book from java");
        book.setCreated(new Timestamp(new Date().getTime()));
        service.save(book);

        Integer savedBookId = book.getId();
        Book bookFromDb = service.get(savedBookId);

        Assert.notNull(bookFromDb, "book must be saved");

        Assert.notNull(bookFromDb.getCreated(), "created column must not me empty");

        Assert.isTrue(bookFromDb.getCreated().equals(book.getCreated()), "created must be eq...");

    }
}
