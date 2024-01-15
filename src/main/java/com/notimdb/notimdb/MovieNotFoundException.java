package com.notimdb.notimdb;

public class MovieNotFoundException extends Throwable {
    public MovieNotFoundException(String message) {
        super(message);
        System.out.println("MovieNotFoundException: " + message);
    }
}
