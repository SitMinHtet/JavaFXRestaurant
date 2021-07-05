package db;

import java.sql.*;

public class DBConnection {

    private static String url = "jdbc:mysql://localhost:3306/restaurantdb?useSSL=false";
    private static String username = "root";
    private static String password = "adminofroot";

    public static Connection getConnection() throws SQLException {
        Connection connection;

        connection = DriverManager.getConnection(url, username, password);

        return connection;

    }

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    public ResultSet executeQuery(String query){

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }


    public boolean executeAction(String qu){

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            statement.execute(qu);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }

    }



}

