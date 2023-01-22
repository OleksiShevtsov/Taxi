package org.solvd;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private ConnectionPool() {
        //private constructor
    }

    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() {
        Context context;
        Connection connection = null;
        try {
            context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/ConnectionPool");

            connection = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
