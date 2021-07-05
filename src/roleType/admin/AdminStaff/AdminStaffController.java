package roleType.admin.AdminStaff;

import com.sun.tools.internal.xjc.model.CDefaultValue;
import db.DBConnection;
import entity.Staff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
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
    private TableColumn<Staff, Integer> staffId;

    @FXML
    private TableColumn<Staff, String> staffFName;

    @FXML
    private TableColumn<Staff, String> staffLName;

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
    private TextField tfStaffSearch;

    DBConnection connection;
    ObservableList<Staff> staffList = FXCollections.observableArrayList();
    private boolean isNewButtonClick = false;

    @FXML
    void processClear(ActionEvent event) {
        clearAllField();
    }

    @FXML
    void processDelete(ActionEvent event) {

    }

    @FXML
    void processEdit(ActionEvent event) {

    }

    @FXML
    void processNew(ActionEvent event) {
        isNewButtonClick = true;
        enableAllField();
    }

    @FXML
    void processRefresh(ActionEvent event) {

    }

    @FXML
    void processSave(ActionEvent event) {
        String fName = tfFName.getText().trim();
        String lName = tfLName.getText().trim();
        String username = tfUsername.getText().trim();
        String email = tfEmail.getText().trim();
        String password = tfPassword.getText();
        String phone = tfPhone.getText().trim();
        String address = tfAddress.getText().trim();
        String status = cobStatus.getValue();
        String dob = dbDOB.getValue().toString();

        if (fName.isEmpty()||lName.isEmpty()||username.isEmpty()||email.isEmpty()||password.isEmpty()||phone.isEmpty()|| address.isEmpty()||status.isEmpty()||dob.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter All Fields");
            alert.showAndWait();
            return;
        }

        showStaff();
        if (isNewButtonClick){
            String insertMemberQuery = "insert into staff (`staffFirstName`, `staffLastName`, `staffUsername`, `staffEmail`, `staffPassword`, `staffPhone`, `staffAddresss`, `staffStatus`, `staffDOB`) values ("+
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
            System.out.println(insertMemberQuery);

            if (connection.executeAction(insertMemberQuery)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Insert Success");
                alert.showAndWait();

                return;
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Fail");
                alert.showAndWait();
                return;
            }
        }
    }

    @FXML
    void processSearch(ActionEvent event) {

    }

    @FXML
    void processView(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connection = new DBConnection();
        ObservableList<String> status = FXCollections.observableArrayList(
                "Enable","Disable"
        );
        cobStatus.setItems(status);

        disableAllFields();
    }

    public void showStaff(){

        staffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        staffFName.setCellValueFactory(new PropertyValueFactory<>("staffFirstName"));
        staffLName.setCellValueFactory(new PropertyValueFactory<>("staffLastName"));
        staffUsername.setCellValueFactory(new PropertyValueFactory<>("staffUsername"));
        staffEmail.setCellValueFactory(new PropertyValueFactory<>("staffEmail"));
        staffPassword.setCellValueFactory(new PropertyValueFactory<>("staffPassword"));
        staffPhone.setCellValueFactory(new PropertyValueFactory<>("staffPhone"));
        staffAddress.setCellValueFactory(new PropertyValueFactory<>("staffAddress"));
        staffStatus.setCellValueFactory(new PropertyValueFactory<>("staffStatus"));
        staffDOB.setCellValueFactory(new PropertyValueFactory<>("staffDOB"));
        String showTableQuery = "SELECT * FROM STAFF";
        ResultSet resultSet = connection.executeQuery(showTableQuery);
        try {
            while (resultSet.next()){
                try {

                    Integer sId = resultSet.getInt("staffId");
                    String fName = resultSet.getString("staffFirstName");
                    String lName = resultSet.getString("staffLastName");
                    String username=resultSet.getString("staffUsername");
                    String email=resultSet.getString("staffEmail");
                    String password=resultSet.getString("staffPassword");
                    String phone=resultSet.getString("staffPhone");
                    String address=resultSet.getString("staffAddresss");
                    String status=resultSet.getString("staffStatus");
                    String dob= String.valueOf(resultSet.getDate("staffDOB"));


                    staffList.add(new Staff(sId,fName,lName,username,email,password,phone,address,status,dob));

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }//try catch end


        staffTable.getItems().setAll(staffList);
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
