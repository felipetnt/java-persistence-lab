package org.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class FactoryConnection {
    private static final String url = "jdbc:mysql://localhost:3306/cursojavabasico";
    private static final String user = "root";
    private static final String password = "root";
//    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}

