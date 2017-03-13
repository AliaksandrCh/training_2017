package com.epam.training.library2017.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.epam.training.library2017.services.IAuthorService;
import com.epam.training.library2017.services.IBookService;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Inject
    private IBookService bookService;

}
