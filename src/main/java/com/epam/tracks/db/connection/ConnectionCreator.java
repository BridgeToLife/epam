package com.epam.tracks.db.connection;

import com.epam.tracks.exception.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private static final String URL = "jdbc:mysql://localhost:3306/shop?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;


    public static Connection getConnection() throws ConnectionException{

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        }catch (ClassNotFoundException | SQLException  ignored){
            throw new ConnectionException(ignored.getMessage(), ignored);
        }
    }
}
