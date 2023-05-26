package org.example.database;

import org.example.exceptions.DatabaseConnectionException;
import org.example.exceptions.DatabaseDisconnectException;

import java.sql.*;

public class DatabaseManager implements DatabaseConnection {
    private static DatabaseManager single_instance = null;
    private Connection connection;
    private String driver = "oracle.jdbc.OracleDriver";
    private String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String login = "sys as SYSDBA";
    private String password = "sys123";

    private DatabaseManager(){}
    @Override
    public void connect() throws DatabaseConnectionException {
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(jdbc_url, login, password);
        }catch (Exception e){
            e.printStackTrace();
            throw new DatabaseConnectionException("UNABLE TO CONNECT TO DATABASE. CHECK LOGIN DATA");
        }
    }
    @Override
    public void disconnect() throws DatabaseDisconnectException {
        try{
            this.connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new DatabaseDisconnectException("UNABLE TO DISCONNECT FROM DATABASE. CHECK FOR ACTIVE QUERY");
        }
    }

    @Override
    public boolean isConnected() {
        return isConnected;
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    public static synchronized DatabaseManager getInstance()
    {
        if (single_instance == null)
            single_instance = new DatabaseManager();

        return single_instance;
    }
}
