package com.epam.training.library2017.services.exception;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileDemo {
    public static void main(String[] args) {
        // Specify the path of the file here
        File file = new File("C://myfile.txt");

        try (FileInputStream fis = new FileInputStream(file); BufferedInputStream bis = new BufferedInputStream(fis)) {

            while (bis.available() > 0) {
                System.out.print((char) bis.read());
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("The specified file not found" + fnfe);
        } catch (IOException ioe) {
            System.out.println("I/O Exception: " + ioe);
        }
    }
}