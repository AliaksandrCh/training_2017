package com.epam.training.library2017.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.library2017.datamodel.Book;
import com.epam.training.library2017.services.IBookService;

public class TransactionsTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

        IBookService service = context.getBean(IBookService.class);

        Book book1 = new Book();
        book1.setTitle("new book in transaction 1");

        Book book2 = new Book();
        book2.setTitle("new book in transaction lllllllllllaaaaaaaaaaaaaargeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

        service.saveMultiple(book1, book2);

    }
}
