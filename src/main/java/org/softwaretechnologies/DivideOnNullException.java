package org.softwaretechnologies;

public class DivideOnNullException extends Exception {

    public DivideOnNullException() {
        super("Division by zero is not allowed");
    }

    public DivideOnNullException(String message) {
        super(message);
    }
}