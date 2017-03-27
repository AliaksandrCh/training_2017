package com.epam.training.library2017.services.exception.samples;

public class WrongEmailException extends Exception {

    public WrongEmailException() {
        super();
    }

    public WrongEmailException(String message) {
        super(message);
    }

}
