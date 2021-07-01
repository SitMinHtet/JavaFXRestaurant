package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import utility.CheckUserCredentials;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

        @FXML
        private TextField tfEmail;

        @FXML
        private PasswordField tfPassword;

        @FXML
        private ComboBox<String> cob;

        @FXML
        private Label lblFailStatus;

        private final CheckUserCredentials checkeUser = new CheckUserCredentials();

        @FXML
        void processLogin(ActionEvent event) throws IOException, SQLException {
            String email = tfEmail.getText().trim();
            String password = tfPassword.getText();
            String role = cob.getSelectionModel().getSelectedItem().toLowerCase();
            String loginType = "Email";

            if (checkeUser.isUserValid(email, password, role, loginType)) {

                switch (role) {
                    case "admin":
                        Stage adminStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                        adminStage.hide();
                        Parent adminRoot = FXMLLoader.load(getClass().getResource("../roleType/admin/adminMainUI.fxml"));
                        adminStage.setTitle("LOGIN");
                        adminStage.setScene(new Scene(adminRoot));
                        adminStage.show();
                        break;
                    case "manager":
                        Stage managerStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                        managerStage.hide();
                        Parent managerRoot = FXMLLoader.load(getClass().getResource("../roleType/manager/managerMainUI.fxml"));
                        managerStage.setTitle("ADMIN");
                        managerStage.setScene(new Scene(managerRoot));
                        managerStage.show();
                        break;
                    case "staff":
                        Stage staffStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                        staffStage.hide();
                        Parent staffRoot = FXMLLoader.load(getClass().getResource("../roleType/staff/staffMainUI.fxml"));
                        staffStage.setTitle("ADMIN");
                        staffStage.setScene(new Scene(staffRoot));
                        staffStage.show();
                        break;
                }


            } else {

                lblFailStatus.setVisible(true);
                lblFailStatus.setTextFill(Paint.valueOf("Red"));
                lblFailStatus.setText("Invalid Email or Password");
            }
        }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> role = FXCollections.observableArrayList(
                "Admin", "Manager", "Staff"
        );

        cob.setItems(role);
        tfEmail.setText("aa@gmail.com");
        tfPassword.setText("aa");
        cob.setValue("Admin");
    }
}








