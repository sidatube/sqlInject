package com.example.sqlinject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection connection;

    public synchronized static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/sqlinjection?createDatabaseIfNotExist=true";
        String user = "root";
        String pass = "";
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, pass);
                System.out.println("Success");
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }

        return connection;
    }
}
