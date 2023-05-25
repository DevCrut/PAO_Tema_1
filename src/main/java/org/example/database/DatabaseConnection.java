package org.example.database;

import org.example.exceptions.DatabaseConnectionException;
import org.example.exceptions.DatabaseDisconnectException;

import java.sql.Connection;

public interface DatabaseConnection {
    Connection connection = null;
    boolean isConnected = false;

    void connect() throws DatabaseConnectionException;
    void disconnect() throws DatabaseDisconnectException;

    boolean isConnected();

    Connection getConnection();
}
