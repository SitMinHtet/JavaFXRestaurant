package db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String url = "jdbc:mysql://localhost:3306/restaurantdb?useSSL=false";
    private static String username = "root";
    private static String password = "adminofroot";

    public static Connection getConnection() throws SQLException {
        Connection connection;

        connection = DriverManager.getConnection(url, username, password);

        return connection;

    }

}

