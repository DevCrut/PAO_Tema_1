package org.example.exceptions;

import org.example.database.DatabaseConnection;

public class DatabaseConnectionException extends Exception{
    public DatabaseConnectionException(String error){
        super(error);
    }
}
