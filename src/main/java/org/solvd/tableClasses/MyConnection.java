package org.solvd.tableClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MyConnection {
//    ResourceBundle resourceBundle = ResourceBundle.getBundle("mySQL");
//    String url = resourceBundle.getString("url");
//    String user = resourceBundle.getString("user");
//    String password = resourceBundle.getString("password");

//    String url = "jdbc:mysql://127.0.0.1/taxi";
//    String user = "alex00987";
//    String password = "Aa200987";

   // String driver = "com.mysql.cj.jdbc.Driver";


    public Connection getConnection() {
        try {

            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/mySQL.properties"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(driver);

            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
