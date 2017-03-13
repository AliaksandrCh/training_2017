package com.epam.training.library2017.services.impl;

import org.springframework.stereotype.Service;

import com.epam.training.library2017.services.IAuthorService;

@Service
public class AuthorServiceImpl implements IAuthorService {

    public static final IAuthorService INSTANCE = new AuthorServiceImpl();

    private AuthorServiceImpl() {
    }

}
