package com.notimdb.notimdb;

public class UserNotFountException extends IllegalArgumentException {
    public UserNotFountException(String s) {
        super(s);
        System.out.println("UserNotFountException" + s);
    }
}
