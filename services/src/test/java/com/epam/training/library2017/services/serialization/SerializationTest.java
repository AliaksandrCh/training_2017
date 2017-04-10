package com.epam.training.library2017.services.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;
import java.util.Date;

import com.epam.training.library2017.datamodel.Book;
import com.epam.training.library2017.datamodel.NotSerializable;

public class SerializationTest {

    public static void main(String[] args) {
        write();

        read();
    }

    private static void read() {
        // read object from file
        try (FileInputStream fileIn = new FileInputStream("d:/book.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);) {

            Book bookFromFile = (Book) in.readObject();
            System.out.println("book from file" + bookFromFile);
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
    }

    private static void write() {
        Book book = new Book();
        book.setCreated(new Timestamp(new Date().getTime()));
        book.setId(1);
        book.setNotSerObj(new NotSerializable());
        System.out.println("new book" + book);

        // write object to file
        try (FileOutputStream fileOut = new FileOutputStream("d:/book.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);) {
            out.writeObject(book);
            System.out.println("Serialized");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
