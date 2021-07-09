package roleType.admin.AdminStaff;

import db.DBConnection;
import entity.Manager;
import entity.ManagerHolder;
import entity.Staff;
import entity.StaffHolder;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utility.ManagerDataUtility;
import utility.StaffDataUtility;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdminStaffController implements Initializable {

    @FXML
    private TextField tfFName;

    @FXML
    private TextField tfLName;

    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private TextField tfPhone;

    @FXML
    private ComboBox<String> cobStatus;

    @FXML
    private DatePicker dbDOB;

    @FXML
    private TextArea tfAddress;

    @FXML
    private TableView<Staff> staffTable;

    @FXML
    private TableColumn<Staff, Integer> staffID;

    @FXML
    private TableColumn<Staff, String> staffFirst;

    @FXML
    private TableColumn<Staff, String> staffLast;

    @FXML
    private TableColumn<Staff, String> staffUsername;

    @FXML
    private TableColumn<Staff, String> staffEmail;

    @FXML
    private TableColumn<Staff, String> staffPhone;

    @FXML
    private TableColumn<Staff, String> staffStatus;

    @FXML
    private TableColumn<Staff, String> staffDOB;

    @FXML
    private TableColumn<Staff, String> staffAddress;

    @FXML
    private TableColumn<Staff, String> staffPassword;

    @FXML
    private TextField tfSearch;

    DBConnection connection;
    private final StaffDataUtility staffDataUtility = new StaffDataUtility();
    boolean  isNewButton = false;
    private int updateByStaffId,deleteByStaffId;



    @FXML
    void processClear(ActionEvent event) {
        clearAllField();
    }

    @FXML
    void processDelete(ActionEvent event) {
        isNewButton = false;
        disableAllFields();

        Staff staff = staffTable.getSelectionModel().getSelectedItem();
        this.deleteByStaffId = staff.getStaffID();

        String deleteQuery = " delete from restaurantdb.staff WHERE (`staffId` = '"+deleteByStaffId+"');";

        System.out.println(deleteQuery);

        if (connection.executeAction(deleteQuery)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Delete Success " + staff.getStaffUsername());
            alert.showAndWait();
            showStaff("select * from staff");
            return;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Delete Fail");
            alert.showAndWait();
            return;
        }
    }

    @FXML
    void processEdit(ActionEvent event) {
        isNewButton = false;
        enableAllField();

        Staff staff = staffTable.getSelectionModel().getSelectedItem();
        tfFName.setText(staff.getStaffFName());
        tfLName.setText(staff.getStaffLName());
        tfUsername.setText(staff.getStaffUsername());
        tfEmail.setText(staff.getStaffEmail());
        tfPassword.setText(staff.getStaffPassword());
        tfPhone.setText(staff.getStaffPhone());
        tfAddress.setText(staff.getStaffAddress());
        cobStatus.setValue(staff.getStaffStatus());
        dbDOB.setValue(LocalDate.parse(staff.getStaffDOB()));

        this.updateByStaffId = staff.getStaffID();
    }

    @FXML
    void processNew(ActionEvent event) {
        isNewButton = true;
        enableAllField();
    }

    @FXML
    void processRefresh(ActionEvent event) {
        showStaff("select * from staff");
    }

    @FXML
    void processSave(ActionEvent event) {
        String fName = tfFName.getText().trim();
        String lName = tfLName.getText().trim();
        String username = tfUsername.getText().trim();
        String email = tfEmail.getText().trim();
        String password = tfPassword.getText();
        String phone = tfPhone.getText().trim();
        String address = tfAddress.getText();
        String status = cobStatus.getValue();
        String dob = dbDOB.getValue().toString();
        if (isNewButton){
            if (fName.isEmpty()||lName.isEmpty()||username.isEmpty()||email.isEmpty()||password.isEmpty()||phone.isEmpty()|| address.isEmpty()||status.isEmpty()||dob.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please Enter All Fields");
                alert.showAndWait();
                return;
            }
            String insertQuery = "insert into staff (`staffFirstName`, `staffLastName`, `staffUsername`, `staffEmail`, `staffPassword`, `staffPhone`, `staffAddress`, `staffStatus`, `staffDOB`) values ("+
                    "'"+fName+"',"+
                    "'"+lName+"',"+
                    "'"+username+"',"+
                    "'"+email+"',"+
                    "'"+password+"',"+
                    "'"+phone+"',"+
                    "'"+address+"',"+
                    "'"+status+"',"+
                    "'"+dob+"'"+
                    ");";
            System.out.println(insertQuery);

            if (connection.executeAction(insertQuery)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Insert Success");
                alert.showAndWait();
                showStaff("select * from staff");
                return;
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Insert Fail");
                alert.showAndWait();
                return;
            }
        }
        else {

            String updateQuery = "UPDATE `restaurantdb`.`staff` SET " +
                    " `staffFirstName` = '" +fName+"',"+
                    "`staffLastName` = '" +lName+"',"+
                    "`staffUsername` = '" +username+"',"+
                    "`staffEmail`  = '" +email+"',"+
                    "`staffPassword` = '" +password+"',"+
                    "`staffPhone` = '" +phone+"',"+
                    "`staffAddress` = '" +address+"',"+
                    "`staffStatus` = '" +status+"',"+
                    "`staffDOB` =  '" +dob+"'"+
                    " WHERE (`staffId` = '"+updateByStaffId+"');";

            System.out.println(updateQuery);

            if (connection.executeAction(updateQuery)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Update Success");
                alert.showAndWait();
                showStaff("select * from staff");
                return;
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Update Fail");
                alert.showAndWait();
                return;
            }


            /*
            Manager updateManager = new Manager(this.updateManagerId,fName,lName,username,email,password,phone,address,status,dob);

            Integer rowUpdate = managerDataUtility.updateManager(updateManager);

            if (rowUpdate > 0){
                System.out.println("Successfully Updated"+ updateManager.getManagerUsername());
                showTable("select * from restaurantdb.manager");
                clearAllField();
                disableAllField();
            }
            else {
                System.out.println("Fail Update"+updateManager.getManagerUsername());
            }

             */
        }




    }

    @FXML
    void processSearch(ActionEvent event) {
        String search = tfSearch.getText().toLowerCase();
        showStaff("select * from staff where staffUsername= '"+search+"';");
    }

    @FXML
    void processView(ActionEvent event) throws IOException {

        Staff staff = staffTable.getSelectionModel().getSelectedItem();
        StaffHolder staffHolder = StaffHolder.getStaffHolder();
        staffHolder.setStaff(staff);

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("staffProfileUI.fxml"));
        stage.setTitle("Profile");
        stage.setScene(new Scene(root));
        stage.show();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connection = new DBConnection();
        ObservableList<String> status = FXCollections.observableArrayList(
                "Enable","Disable"
        );
        cobStatus.setItems(status);
        disableAllFields();
        showStaff("select * from staff");
    }

    public void showStaff(String query){

        staffID.setCellValueFactory(new PropertyValueFactory<>("staffID"));
        staffFirst.setCellValueFactory(new PropertyValueFactory<>("staffFName"));
        staffLast.setCellValueFactory(new PropertyValueFactory<>("staffLName"));
        staffUsername.setCellValueFactory(new PropertyValueFactory<>("staffUsername"));
        staffEmail.setCellValueFactory(new PropertyValueFactory<>("staffEmail"));
        staffPassword.setCellValueFactory(new PropertyValueFactory<>("staffPassword"));
        staffPhone.setCellValueFactory(new PropertyValueFactory<>("staffPhone"));
        staffAddress.setCellValueFactory(new PropertyValueFactory<>("staffAddress"));
        staffStatus.setCellValueFactory(new PropertyValueFactory<>("staffStatus"));
        staffDOB.setCellValueFactory(new PropertyValueFactory<>("staffDOB"));

        try {
            staffTable.setItems(staffDataUtility.getAllStaff(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disableAllFields(){
        tfFName.setDisable(true);
        tfLName.setDisable(true);
        tfUsername.setDisable(true);
        tfEmail.setDisable(true);
        tfPassword.setDisable(true);
        tfPhone.setDisable(true);
        tfAddress.setDisable(true);
        cobStatus.setDisable(true);
        dbDOB.setDisable(true);
    }

    public void enableAllField(){
        tfFName.setDisable(false);
        tfLName.setDisable(false);
        tfUsername.setDisable(false);
        tfEmail.setDisable(false);
        tfPassword.setDisable(false);
        tfPhone.setDisable(false);
        tfAddress.setDisable(false);
        cobStatus.setDisable(false);
        dbDOB.setDisable(false);
    }

    public void clearAllField(){
        tfFName.clear();
        tfLName.clear();
        tfUsername.clear();
        tfEmail.clear();
        tfPassword.clear();
        tfPhone.clear();
        tfAddress.clear();
        cobStatus.setValue("Status");
        dbDOB.setValue(LocalDate.now());
    }

}











