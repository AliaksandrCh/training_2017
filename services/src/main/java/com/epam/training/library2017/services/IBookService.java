package com.epam.training.library2017.services;

import com.epam.training.library2017.datamodel.Book;

public interface IBookService {

    Book get(Integer id);

    void save(Book book);
}
