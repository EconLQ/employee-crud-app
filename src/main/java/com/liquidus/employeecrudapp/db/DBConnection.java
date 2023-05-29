package com.liquidus.employeecrudapp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static Connection connection = getConnection();

    public static Connection getConnection() {
        // TODO: Replace print statements with logging from Log4j
        System.out.println("Start getConnection");
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            if (connection != null) {
                System.out.println("Connected");
                return connection;
            } else {
                System.out.println("Connection issue");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Exception in DB connection ==> " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
