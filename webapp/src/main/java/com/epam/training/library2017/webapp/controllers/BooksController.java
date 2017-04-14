package com.epam.training.library2017.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.library2017.dao.api.filter.BookFilter;
import com.epam.training.library2017.datamodel.Book;
import com.epam.training.library2017.datamodel.BookGenre;
import com.epam.training.library2017.services.IBookService;
import com.epam.training.library2017.webapp.models.BookModel;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Inject
    private IBookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(@RequestParam(required = false) String genre) {
        List<Book> allBooks;
        if (genre == null) {
            allBooks = bookService.getAll();
        } else {
            BookFilter bookFilter = new BookFilter();

            try {
                bookFilter.setGenre(BookGenre.valueOf(genre));
            } catch (IllegalArgumentException e) {
                String msg = String.format("Genre [%s] is not supported. Please use one of: %s", genre,
                        BookGenre.values());
                return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
            }
            allBooks = bookService.search(bookFilter);
        }
        List<BookModel> convertedBooks = new ArrayList<>();
        for (Book book : allBooks) {
            convertedBooks.add(entity2model(book));
        }

        return new ResponseEntity<List<BookModel>>(convertedBooks, HttpStatus.OK);
    }

    private BookModel entity2model(Book book) {
        BookModel bookModel = new BookModel();
        bookModel.setTitle(book.getTitle());
        bookModel.setGenre(book.getGenre() == null ? null : book.getGenre().name());
        return bookModel;
    }
}
