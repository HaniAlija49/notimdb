package com.notimdb.notimdb;

public class GenreNotFoundException extends IllegalArgumentException{
    public GenreNotFoundException(String s) {
        super(s);
        System.out.println("GenreNotFoundException: " + s);
    }
}
