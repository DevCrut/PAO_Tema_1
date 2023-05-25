package org.example.exceptions;

public class DatabaseDisconnectException extends Exception{
    public  DatabaseDisconnectException(String error){
        super(error);
    }
}
