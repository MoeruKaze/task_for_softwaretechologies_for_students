package org.softwaretechnologies;

public class MyException extends Exception {
    // Базовый класс исключения, можно добавить конструкторы при необходимости
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}