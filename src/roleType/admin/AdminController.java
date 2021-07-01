package roleType.admin;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class AdminController {

    @FXML
    void processDrink(MouseEvent event) throws IOException {
        Stage drinkStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../admin/AdminDrink/adminDrinkUI.fxml"));
        drinkStage.setTitle("DRINK");
        drinkStage.setScene(new Scene(root));
        drinkStage.show();
    }

    @FXML
    void processFood(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../admin/AdminFood/adminFoodUI.fxml"));
        stage.setTitle("FOOD");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void processLogout(MouseEvent event) throws IOException {
        Stage adminStage = (Stage) ((ImageView) event.getSource()).getScene().getWindow();
        adminStage.hide();
        Parent adminRoot = FXMLLoader.load(getClass().getResource("../../main/loginUI.fxml"));
        adminStage.setTitle("ADMIN MAIN");
        adminStage.setScene(new Scene(adminRoot));
        adminStage.show();
    }

    @FXML
    void processManager(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../admin/AdminManager/adminManagerUI.fxml"));
        stage.setTitle("Manager");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void processSale(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../admin/AdminSale/adminSaleUI.fxml"));
        stage.setTitle("Sale");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void processStaff(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../admin/AdminStaff/adminStaffUI.fxml"));
        stage.setTitle("Staff");
        stage.setScene(new Scene(root));
        stage.show();
    }


}
