package com.epam.training.library2017.dao.impl.filter;

import java.util.Date;

import com.epam.training.library2017.datamodel.BookGenre;

public class BookFilter {

    private String title;

    private BookGenre genre;

    private Date from;

    private Date to;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
