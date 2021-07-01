package roleType.admin.AdminManager;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminManagerController implements Initializable {

    @FXML
    private VBox tfFname;

    @FXML
    private TextField tfLname;

    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfAddress;

    @FXML
    private ComboBox<?> cobStatus;

    @FXML
    private DatePicker dbDOB;

    @FXML
    private TableColumn<?, ?> managerId;

    @FXML
    private TableColumn<?, ?> managerFName;

    @FXML
    private TableColumn<?, ?> managerLName;

    @FXML
    private TableColumn<?, ?> managerUsername;

    @FXML
    private TableColumn<?, ?> managerEmail;

    @FXML
    private TableColumn<?, ?> managerPhone;

    @FXML
    private TableColumn<?, ?> managerStatus;

    @FXML
    private TableColumn<?, ?> managerDOB;

    @FXML
    private TableColumn<?, ?> managerAddress;

    @FXML
    private TextField tfSearch;

    @FXML
    void processClear(ActionEvent event) {

    }

    @FXML
    void processDelete(ActionEvent event) {

    }

    @FXML
    void processEdit(ActionEvent event) {

    }

    @FXML
    void processNew(ActionEvent event) {

    }

    @FXML
    void processRefresh(ActionEvent event) {

    }

    @FXML
    void processSave(ActionEvent event) {

    }

    @FXML
    void processSearch(ActionEvent event) {

    }

    @FXML
    void processView(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
