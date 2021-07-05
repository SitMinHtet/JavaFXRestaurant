package utility;

import db.DBConnection;
import entity.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ManagerDataUtility{

    private Connection connection;
    private Statement statement;
    private PreparedStatement preStmt;
    private ResultSet resultSet;


    public ObservableList<Manager> getAllManagers(String query) throws SQLException {
        connection = DBConnection.getConnection();
        ObservableList<Manager> managerList = FXCollections.observableArrayList();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);

        while (resultSet.next()){


            managerList.add(new Manager(
                    resultSet.getInt("managerID"),
                    resultSet.getString("managerFirstName"),
                    resultSet.getString("managerLastName"),
                    resultSet.getString("managerUsername"),
                    resultSet.getString("managerEmail"),
                    resultSet.getString("managerPassword"),
                    resultSet.getString("managerPhone"),
                    resultSet.getString("managerAddress"),
                    resultSet.getString("managerStatus"),
                    resultSet.getDate("managerDOB").toString())
            );
        }
        connection.close();
        return managerList;
    }


    //Create New Manager
    public boolean saveManager(Manager manager) throws SQLException {
        connection = DBConnection.getConnection();

        String createQuery = "INSERT INTO `restaurantdb`.`manager` (" +
                "`managerFirstName`, `managerLastName`," +
                " `managerUsername`, `managerEmail`," +
                " `managerPassword`, `managerPhone`, " +
                "`managerAddress`, `managerStatus`, `managerDOB`) VALUES (" +
                "?,?,?,?,?,?,?,?,?);";
        preStmt = connection.prepareStatement(createQuery);

        preStmt.setString(1,manager.getManagerFName());
        preStmt.setString(2,manager.getManagerLName());
        preStmt.setString(3,manager.getManagerUsername());
        preStmt.setString(4,manager.getManagerEmail());
        preStmt.setString(5,manager.getManagerPassword());
        preStmt.setString(6,manager.getManagerPhone());
        preStmt.setString(7,manager.getManagerAddress());
        preStmt.setString(8,manager.getManagerStatus());
        Date date = Date.valueOf(manager.getManagerDOB());
        preStmt.setDate(9, date);




        boolean flag= preStmt.execute();
        connection.close();
        return  flag;
    }


}
