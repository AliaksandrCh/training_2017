package com.epam.training.library2017.dao.xml.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.epam.training.library2017.dao.api.IBookDao;
import com.epam.training.library2017.dao.api.filter.BookFilter;
import com.epam.training.library2017.dao.xml.impl.exception.NotSupportedMethodException;
import com.epam.training.library2017.dao.xml.impl.wrapper.XmlModelWrapper;
import com.epam.training.library2017.datamodel.Book;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Repository
public class BookDaoXmlImpl implements IBookDao {

    private final XStream xstream = new XStream(new DomDriver());

    @Value("${root.folder}")
    private String rootFolder;

    @Override
    public Book get(Integer id) {

        File file = getFile();

        XmlModelWrapper<Integer, Book> wrapper = (XmlModelWrapper<Integer, Book>) xstream.fromXML(file);
        List<Book> books = wrapper.getRows();
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;

    }

    @Override
    public Book insert(Book book) {
        File file = getFile();

        XmlModelWrapper<Integer, Book> wrapper = (XmlModelWrapper<Integer, Book>) xstream.fromXML(file);
        List<Book> books = wrapper.getRows();
        Integer lastId = wrapper.getLastId();
        int newId = lastId + 1;

        book.setId(newId);
        books.add(book);

        wrapper.setLastId(newId);
        writeNewData(file, wrapper);
        return book;

    }

    @Override
    public void update(Book book) {
        File file = getFile();

        XmlModelWrapper<Integer, Book> wrapper = (XmlModelWrapper<Integer, Book>) xstream.fromXML(file);
        List<Book> books = wrapper.getRows();
        for (Book bookItem : books) {
            if (bookItem.getId().equals(book.getId())) {
                // TODO copy all properties
                break;
            }
        }

        writeNewData(file, wrapper);
    }

    @Override
    public List<Book> getAll() {
        File file = getFile();

        XmlModelWrapper<Integer, Book> wrapper = (XmlModelWrapper<Integer, Book>) xstream.fromXML(file);
        return wrapper.getRows();
    }

    @Override
    public void delete(Integer id) {
        File file = getFile();

        XmlModelWrapper<Integer, Book> wrapper = (XmlModelWrapper<Integer, Book>) xstream.fromXML(file);
        List<Book> books = wrapper.getRows();
        Book found = null;
        for (Book book : books) {
            if (book.getId().equals(id)) {
                found = book;
                break;
            }
        }
        if (found != null) {
            books.remove(found);
            writeNewData(file, wrapper);
        }
    }

    @Override
    public List<Book> search(BookFilter bookFilter) {
        throw new NotSupportedMethodException();
    }

    private void writeNewData(File file, XmlModelWrapper obj) {
        try {
            xstream.toXML(obj, new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private File getFile() {
        File file = new File(rootFolder + "books.xml");
        return file;
    }
}
