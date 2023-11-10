package com.example.courseproject_oop2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/OOP_Server";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "oopbaza";

    public static Connection connect() {
        try {

            return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
