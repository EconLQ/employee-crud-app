package com.liquidus.employeecrudapp.db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnectionTest {

    @Test
    void getConnection() throws SQLException {
        Connection conn = DBConnection.getConnection();
        assert conn != null;
        boolean reachable = conn.isValid(10);
    }
}