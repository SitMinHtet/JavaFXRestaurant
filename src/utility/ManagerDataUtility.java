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

    //instead of prepared Statements
    public boolean saveManager(Manager manager) throws SQLException {

        connection = DBConnection.getConnection();

        String createQuery = "INSERT INTO `restaurantdb`.`manager` (" +
                "`managerFirstName`, `managerLastName`," +
                " `managerUsername`, `managerEmail`," +
                " `managerPassword`, `managerPhone`, " +
                "`managerAddress`, `managerStatus`, `managerDOB`) VALUES (" +
                "'"+manager.getManagerFName()+"'," +
                "'"+manager.getManagerLName()+"',"+
                "'"+manager.getManagerUsername()+"',"+
                "'"+manager.getManagerEmail()+"',"+
                "'"+manager.getManagerPassword()+"',"+
                "'"+manager.getManagerPhone()+"',"+
                "'"+manager.getManagerAddress()+"',"+
                "'"+manager.getManagerStatus()+"',"+
                "'"+manager.getManagerDOB()+"'"+
                ");";


        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            statement.execute(createQuery);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }

    }


    public boolean updateManager(Manager manager) throws SQLException{
        connection = DBConnection.getConnection();

        String updateQuery = "UPDATE `restaurantdb`.`manager` SET " +
                " `managerFirstName` = " +"'"+manager.getManagerFName()+"'," +
                "`managerLastName` =  " +"'"+manager.getManagerLName()+"',"+
                "`managerUsername` =  " + "'"+manager.getManagerUsername()+"',"+
                "`managerEmail` = " + "'"+manager.getManagerEmail()+"',"+
                "`managerPassword` =  " + "'"+manager.getManagerPassword()+"',"+
                "`managerPhone` = " + "'"+manager.getManagerPhone()+"',"+
                "`managerAddress` =  " + "'"+manager.getManagerAddress()+"',"+
                "`managerStatus` = " +  "'"+manager.getManagerStatus()+"',"+
                "`managerDOB` =  " + "'"+manager.getManagerDOB()+"'"+
                "WHERE (`managerId` =" + "'"+manager.getManagerID()+"'"+ ");";




        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            statement.execute(updateQuery);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }


    }



    public boolean deleteManager(Manager manager) throws SQLException{

        connection = DBConnection.getConnection();

        String deleteQuery=" delete from restaurantdb.manager where managerId=" + "'"+manager.getManagerID()+"'"+";";



        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            statement.execute(deleteQuery);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }
    }




    /*
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

    //Update Manager
    public int updateManager(Manager manager) throws SQLException{

        connection = DBConnection.getConnection();

        String updateQuery = "UPDATE `restaurantdb`.`manager` SET " +
                " `managerFirstName` = ?, " +
                "`managerLastName` = ?, " +
                "`managerUsername` = ?, " +
                "`managerEmail` = ?, " +
                "`managerPassword` = ?, " +
                "`managerPhone` = ?, " +
                "`managerAddress` = ?, " +
                "`managerStatus` = ? ," +
                "`managerDOB` = ? " +
                "WHERE (`managerId` = ?);";
        preStmt = connection.prepareStatement(updateQuery);



        preStmt.setString(1,manager.getManagerFName());
        preStmt.setString(2,manager.getManagerLName());
        preStmt.setString(3,manager.getManagerUsername());
        preStmt.setString(4,manager.getManagerEmail());
        preStmt.setString(5,manager.getManagerPassword());
        preStmt.setString(6,manager.getManagerPhone());
        preStmt.setString(7,manager.getManagerAddress());
        preStmt.setString(8,manager.getManagerStatus());
        preStmt.setDate(9, Date.valueOf(manager.getManagerDOB()));
        preStmt.setString(10, String.valueOf(manager.getManagerID()));

        //get update data
        Integer rowUpdate = preStmt.executeUpdate();
        connection.close();

        return rowUpdate;
    }

    //Delete Manager by row
    public boolean deleteManager(Manager manager) throws SQLException{

        connection = DBConnection.getConnection();

        String deleteQuery=" delete from restaurantdb.manager where managerId=?;";
        preStmt = connection.prepareStatement(deleteQuery);

        preStmt.setString(1, String.valueOf(manager.getManagerID()));

        boolean isDeleteOk = preStmt.execute();
        connection.close();
        return  isDeleteOk;
    }

     */

}

