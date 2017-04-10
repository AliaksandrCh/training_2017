package com.epam.training.library2017.dao.db.impl;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.training.library2017.dao.api.IAuthorDao;
import com.epam.training.library2017.datamodel.Author;

@Repository
public class AuthorDaoImpl implements IAuthorDao {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public Author get(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

}
