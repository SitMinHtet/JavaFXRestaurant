package roleType.admin.AdminManager;

import entity.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import utility.ManagerDataUtility;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Observable;
import java.util.ResourceBundle;

public class AdminManagerController implements Initializable {

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
    private TableView<Manager> managerTable;

    @FXML
    private TableColumn<Manager, Integer> managerId;

    @FXML
    private TableColumn<Manager, String> managerFName;

    @FXML
    private TableColumn<Manager, String> managerLName;

    @FXML
    private TableColumn<Manager, String> managerUsername;

    @FXML
    private TableColumn<Manager, String> managerEmail;

    @FXML
    private TableColumn<Manager, String> managerPassword;

    @FXML
    private TableColumn<Manager, String> managerPhone;

    @FXML
    private TableColumn<Manager, String> managerStatus;

    @FXML
    private TableColumn<Manager, String> managerDOB;

    @FXML
    private TableColumn<Manager, String> managerAddress;

    @FXML
    private TextField tfSearch;

    private final ManagerDataUtility managerDataUtility = new ManagerDataUtility();
    private boolean isNewButtonClick = false;

    public AdminManagerController() throws SQLException {
    }

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
    void processSave(ActionEvent event) throws SQLException {
        String fName = tfFName.getText().trim();
        String lName = tfLName.getText().trim();
        String username = tfUsername.getText().trim();
        String email =tfEmail.getText().trim();
        String password = tfPassword.getText();
        String phone = tfPhone.getText().trim();
        String address = tfAddress.getText().trim();
        String status = cobStatus.getValue();
        String dob = dbDOB.getValue().toString();

        if (isNewButtonClick){
            Manager manager = new Manager(fName,lName,username,email,password,phone,address,status,dob);
            System.out.println(manager.toString());
            boolean isSaveOk= managerDataUtility.saveManager(manager);

            if (!isSaveOk){
                System.out.println("SuccessFully Saved"+ managerUsername +" to DB");
                showTable("select * from restaurantdb.manager");
            }
            else {
                System.out.println("Fail Save"+ managerUsername +" to DB");
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
        ObservableList<String> status = FXCollections.observableArrayList(
                "Enable","Disable"
        );
        cobStatus.setItems(status);
        disableAllField();
        showTable("select * from restaurantdb.manager");

    }

    public void clearAllField(){
        tfFName.clear();
        tfLName.clear();
        tfUsername.clear();
        tfEmail.clear();
        tfPassword.clear();
        tfPhone.clear();
        tfAddress.clear();
        //cobStatus.setValue("Status");
        cobStatus.getSelectionModel().clearSelection();
        dbDOB.setValue(LocalDate.now());

    }
    public void  disableAllField(){
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

    public void  enableAllField(){
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


    public void showTable(String query){

        managerId.setCellValueFactory(new PropertyValueFactory<>("managerID"));
        managerFName.setCellValueFactory(new PropertyValueFactory<>("managerFName"));
        managerLName.setCellValueFactory(new PropertyValueFactory<>("managerLName"));
        managerUsername.setCellValueFactory(new PropertyValueFactory<>("managerUsername"));
        managerEmail.setCellValueFactory(new PropertyValueFactory<>("managerEmail"));
        managerPassword.setCellValueFactory(new PropertyValueFactory<>("managerPassword"));
        managerPhone.setCellValueFactory(new PropertyValueFactory<>("managerPhone"));
        managerAddress.setCellValueFactory(new PropertyValueFactory<>("managerAddress"));
        managerStatus.setCellValueFactory(new PropertyValueFactory<>("managerStatus"));
        managerDOB.setCellValueFactory(new PropertyValueFactory<>("managerDOB"));

        try {
            managerTable.setItems(managerDataUtility.getAllManagers(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
