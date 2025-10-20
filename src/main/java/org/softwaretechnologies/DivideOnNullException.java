package org.softwaretechnologies;

public class DivideOnNullException extends Exception {
    // Можно добавить конструкторы для лучшего описания ошибки
    public DivideOnNullException() {
        super("Division by zero is not allowed");
    }

    public DivideOnNullException(String message) {
        super(message);
    }
}