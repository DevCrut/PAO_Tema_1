package org.example.exceptions;

public class DatabaseQueryException extends  Exception{
    public DatabaseQueryException(String error){
        super(error);
    }
}
