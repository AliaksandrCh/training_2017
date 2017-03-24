package com.epam.training.library2017.dao.impl.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.epam.training.library2017.dao.impl.db.IBookDao;
import com.epam.training.library2017.datamodel.Book;

@Repository
public class BookDaoImpl implements IBookDao {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public Book get(Integer id) {
        try {
            return jdbcTemplate.queryForObject("select * from book where id = ? ", new Object[] { id },
                    new BeanPropertyRowMapper<Book>(Book.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Book insert(Book entity) {

        final String INSERT_SQL = "insert into book (title, created) values(?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
                ps.setString(1, entity.getTitle());
                ps.setTimestamp(2, entity.getCreated());
                return ps;
            }
        }, keyHolder);

        Number key = keyHolder.getKey();
        entity.setId(key.intValue());
        return entity;

    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("delete from book where id=" + id);
    }

    @Override
    public List<Book> getAll() {
        List<Book> rs = jdbcTemplate.query("select * from book ", new BeanPropertyRowMapper<Book>(Book.class));
        return rs;
    }

    @Override
    public void update(Book book) {
        // TODO
    }

}
