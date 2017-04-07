package com.epam.training.library2017.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.util.Assert;

import com.epam.training.library2017.dao.impl.filter.BookFilter;
import com.epam.training.library2017.datamodel.Book;
import com.epam.training.library2017.datamodel.BookGenre;

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

        // DELETE for sample

        service.delete(savedBookId);
    }

    @Test
    public void createMultipleTest() {

        Book book1 = new Book();
        book1.setTitle("new book1 from java");
        book1.setCreated(new Timestamp(new Date().getTime()));

        Book book2 = new Book();
        book2.setTitle("new book2 from java");
        book2.setCreated(new Timestamp(new Date().getTime()));

        Book book3 = new Book();
        book3.setTitle("new book3 from java");
        book3.setCreated(new Timestamp(new Date().getTime()));

        service.saveMultiple(book1, book2, book3);

        BookFilter bookFilter = new BookFilter();
        bookFilter.setGenre(BookGenre.fantasy);
        bookFilter.setTitle("book3");
        List<Book> booksByGenre = service.search(bookFilter);
    }
}
