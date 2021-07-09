package utility;

import com.sun.org.apache.bcel.internal.generic.INEG;
import db.DBConnection;
import entity.Food;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class FoodDataUtility {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preStat;
    private ResultSet resultSet;

    public ObservableList<Food> getAllFood(String query) throws SQLException {
        connection = DBConnection.getConnection();
        ObservableList<Food> foodList = FXCollections.observableArrayList();

        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            foodList.add(new Food(
                    resultSet.getInt("foodId"),
                    resultSet.getString("foodName"),
                    resultSet.getString("foodCode"),
                    resultSet.getInt("foodQuantity"),
                    resultSet.getDouble("foodPrice"),
                    resultSet.getString("foodType"),
                    resultSet.getString("foodImageName")
            ));
        }

        connection.close();
        return  foodList;
    }

    public boolean saveFood(Food food) throws SQLException {
        connection = DBConnection.getConnection();
        String saveQuery = "INSERT INTO `restaurantdb`.`food` (`foodName`, `foodCode`, `foodQuantity`, `foodPrice`, `foodType`,`foodImageName`,`foodStatus`) VALUES" +
                " (?, ?, ?, ?, ?,?,?);";
        preStat = connection.prepareStatement(saveQuery);
        preStat.setString(1,food.getFoodName());
        preStat.setString(2,food.getFoodCode());
        preStat.setInt(3,food.getFoodQuantity());
        preStat.setDouble(4,food.getFoodPrice());
        preStat.setString(5,food.getFoodType());
        preStat.setString(6,food.getFoodImageName());
        preStat.setString(7,"Active");

        boolean isSaveOk = preStat.execute();
        connection.close();
        return isSaveOk;
    }

    public boolean updateFood(Food food) throws SQLException {
        connection = DBConnection.getConnection();
        String updateQuery = "UPDATE `restaurantdb`.`food` SET" +
                " `foodName` = ?, `foodCode` = ?, `foodQuantity` = ?, `foodPrice` = ?, `foodType` = ?, `foodImageName` = ?  WHERE (`foodId` = ?);";
        preStat = connection.prepareStatement(updateQuery);

        preStat.setString(1,food.getFoodName());
        preStat.setString(2,food.getFoodCode());
        preStat.setInt(3,food.getFoodQuantity());
        preStat.setDouble(4,food.getFoodPrice());
        preStat.setString(5,food.getFoodType());
        preStat.setString(6,food.getFoodImageName());
        preStat.setInt(7,food.getId());

        boolean isUpdateOk = preStat.execute();
        connection.close();
        return isUpdateOk;
    }

    public boolean deleteFlashFood(Integer foodId) throws SQLException {
        connection = DBConnection.getConnection();
        String deleteQuery = " update `food` set `foodStatus`= ? where (`foodId`= ?);";
        preStat = connection.prepareStatement(deleteQuery);

        preStat.setString(1,"Deleted");
        preStat.setInt(2,foodId);

        boolean isDeleteOk = preStat.execute();
        connection.close();
        return isDeleteOk;
    }

    public boolean deleteFood(Integer foodId) throws SQLException {
        connection = DBConnection.getConnection();
        String deleteQuery = " delete from food where (`foodId`= ?);";
        preStat = connection.prepareStatement(deleteQuery);

        preStat.setInt(1,foodId);

        boolean isDeleteOk = preStat.execute();
        connection.close();
        return isDeleteOk;
    }




}
