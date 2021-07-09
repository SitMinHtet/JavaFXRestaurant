package utility;

import db.DBConnection;
import entity.Manager;
import entity.Staff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class StaffDataUtility {

    Connection connection;
    Statement statement;
    PreparedStatement preStmt;
    ResultSet resultSet;

    public ObservableList<Staff> getAllStaff(String query) throws SQLException {
        connection = DBConnection.getConnection();
        ObservableList<Staff> staffList = FXCollections.observableArrayList();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);

        while (resultSet.next()){

            staffList.addAll(new Staff(
                    resultSet.getInt("staffID"),
                    resultSet.getString("staffFirstName"),
                    resultSet.getString("staffLastName"),
                    resultSet.getString("staffUsername"),
                    resultSet.getString("staffEmail"),
                    resultSet.getString("staffPassword"),
                    resultSet.getString("staffPhone"),
                    resultSet.getString("staffAddress"),
                    resultSet.getString("staffStatus"),
                    resultSet.getDate("staffDOB").toString()));

        }

        connection.close();
        return staffList;

    }

}
