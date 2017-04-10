package com.epam.training.library2017.datamodel;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author dz
 *
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1;

    private Integer id;
    private String title;
    private Integer authorId;
    private Timestamp created;
    private Timestamp updated;
    private BookGenre genre;

    private transient NotSerializable notSerObj;

    public NotSerializable getNotSerObj() {
        return notSerObj;
    }

    public void setNotSerObj(NotSerializable notSerObj) {
        this.notSerObj = notSerObj;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

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

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", authorId=" + authorId + ", created=" + created + ", updated="
                + updated + ", genre=" + genre + "]";
    }

}
