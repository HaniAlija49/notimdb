package com.notimdb.notimdb;

public class InvalidActorIdException extends Throwable {
    public InvalidActorIdException(String s) {
        super(s);
        System.out.println("InvalidActorIdException" + s);
    }
}
