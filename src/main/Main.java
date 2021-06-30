package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loginUI.fxml"));
        primaryStage.setTitle("LOGIN");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }


    public static void main(String[] args) throws SQLException {

        /*
        System.out.println("\n");
        if (getConnection()!=null){
            System.out.println("Successfully Connected to DB");
        }
        else {
            System.out.println("Connection Fail!");
        }

        System.out.println("\n");

         */
        launch(args);


    }
}
