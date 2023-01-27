package org.solvd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class MyConnection {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("mySQL");
    String url = resourceBundle.getString("url");
    String user = resourceBundle.getString("user");
    String password = resourceBundle.getString("password");

//    String url = "jdbc:mysql://127.0.0.1/taxi";
//    String user = "alex00987";
//    String password = "Aa200987";
    Logger logger = LogManager.getLogger(MyConnection.class);

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
