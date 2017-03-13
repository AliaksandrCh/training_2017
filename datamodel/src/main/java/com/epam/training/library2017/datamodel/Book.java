package com.epam.training.library2017.datamodel;

/**
 * @author dz
 *
 */
public class Book {

    private Integer id;
    private String title;
    private Integer authorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", authorId=" + authorId + "]";
    }

}
