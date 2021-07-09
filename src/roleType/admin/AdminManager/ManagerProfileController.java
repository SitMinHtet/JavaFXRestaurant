package roleType.admin.AdminManager;

import entity.Manager;
import entity.ManagerHolder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerProfileController implements Initializable {

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

        ManagerHolder managerHolder = ManagerHolder.getManagerHolder();
        Manager manager = managerHolder.getManager();

        lblId.setText(String.valueOf(manager.getManagerID()));
        lblFName.setText(manager.getManagerFName());
        lblLName.setText(manager.getManagerLName());
        lblUserName.setText(manager.getManagerUsername());
        lblEmail.setText(manager.getManagerEmail());
        lblPassword.setText(manager.getManagerPassword());
        lblPhone.setText(manager.getManagerPhone());
        lblAddress.setText(manager.getManagerAddress());
        lblStatus.setText(manager.getManagerStatus());
        lblDOB.setText(manager.getManagerDOB());

    }
}
