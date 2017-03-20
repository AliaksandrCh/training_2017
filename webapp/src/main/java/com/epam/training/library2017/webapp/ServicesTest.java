package com.epam.training.library2017.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.library2017.datamodel.Book;
import com.epam.training.library2017.services.IBookService;

public class ServicesTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

        IBookService service = context.getBean(IBookService.class);

        // System.out.println(service.get(1));
        // System.out.println(service.getAll());

        Book book = new Book();
        book.setTitle("new book from java");
        service.save(book);

        System.out.println("Saved book:" + book);

        System.out.println(service.get(book.getId()));
        service.delete(book.getId());
        System.out.println(service.get(book.getId()));
    }
}
