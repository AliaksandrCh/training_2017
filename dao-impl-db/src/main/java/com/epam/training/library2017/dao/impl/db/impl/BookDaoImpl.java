package com.epam.training.library2017.dao.impl.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.epam.training.library2017.dao.impl.db.IBookDao;
import com.epam.training.library2017.dao.impl.filter.BookFilter;
import com.epam.training.library2017.dao.impl.filter.SortData;
import com.epam.training.library2017.datamodel.Book;

@Repository
public class BookDaoImpl implements IBookDao {

    private final static Logger LOGGER = LoggerFactory.getLogger(BookDaoImpl.class);

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

        final String INSERT_SQL = "insert into book (title, created, genre) values(?,?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
                ps.setString(1, entity.getTitle());
                ps.setTimestamp(2, entity.getCreated());
                ps.setString(3, entity.getGenre().name());
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

    @Override
    public List<Book> search(BookFilter bookFilter) {
        StringBuilder sqlWhere = new StringBuilder("");
        List<Object> paramsList = new ArrayList<Object>();
        List<String> sqlWhereFragmentsAndList = new ArrayList<String>();

        if (bookFilter.getGenre() != null) {
            sqlWhereFragmentsAndList.add("genre=?");
            paramsList.add(bookFilter.getGenre().name());
        }
        if (bookFilter.getTitle() != null && bookFilter.getTitle().length() > 0) {
            sqlWhereFragmentsAndList.add("title=?");
            paramsList.add(bookFilter.getTitle());
        }

        if (!paramsList.isEmpty()) {
            sqlWhere.insert(0, "where ");
        }

        sqlWhere.append(concatAnds(sqlWhereFragmentsAndList));

        SortData sort = bookFilter.getSort();
        if (sort != null) {
            String column = sort.getColumn();
            String direction = sort.getOrder();
            // TODO add 'order by ' fragment to final SQL
        }

        if (bookFilter.getLimit() != null) {
            // TODO add "limit" to SQL
        }

        if (bookFilter.getOffset() != null) {
            // TODO add "offset" to SQL
        }

        String fullSql = String.format("select * from book %s ", sqlWhere);

        LOGGER.debug("execute sql:{}", fullSql);
        List<Book> rs = jdbcTemplate.query(fullSql, paramsList.toArray(), new BeanPropertyRowMapper<Book>(Book.class));
        return rs;
    }

    private String concatAnds(List<String> sqlParts) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < sqlParts.size(); i++) {
            String string = sqlParts.get(i);
            if (i != 0) {
                stringBuilder.append("AND ");
            }
            stringBuilder.append(string + " ");
        }
        return stringBuilder.toString();
    }
}
