package roleType.admin.AdminStaff;

import entity.Manager;
import entity.ManagerHolder;
import entity.Staff;
import entity.StaffHolder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffProfileController implements Initializable {

    @FXML
    private Label lblId;

    @FXML
    private Label lblFName;

    @FXML
    private Label lblLName;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblDOB;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        StaffHolder staffHolder = StaffHolder.getStaffHolder();
        Staff staff = staffHolder.getStaff();

        lblId.setText(String.valueOf(staff.getStaffID()));
        lblFName.setText(staff.getStaffFName());
        lblLName.setText(staff.getStaffLName());
        lblUserName.setText(staff.getStaffUsername());
        lblEmail.setText(staff.getStaffEmail());
        lblPassword.setText(staff.getStaffPassword());
        lblPhone.setText(staff.getStaffPhone());
        lblAddress.setText(staff.getStaffAddress());
        lblStatus.setText(staff.getStaffStatus());
        lblDOB.setText(staff.getStaffDOB());


    }
}
