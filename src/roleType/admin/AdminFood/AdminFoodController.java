package roleType.admin.AdminFood;

import entity.Food;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import utility.FoodDataUtility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminFoodController implements Initializable {

    @FXML
    private ImageView foodImage;

    @FXML
    private TextField tfFoodName;

    @FXML
    private ComboBox<String> cobPrefix;

    @FXML
    private TextField tfFoodCode;

    @FXML
    private TextField tfFoodQuantity;

    @FXML
    private TextField tfFoodPrice;

    @FXML
    private ComboBox<String> cbFoodType;

    @FXML
    private TableView<Food> foodTable;

    @FXML
    private TableColumn<Food, Integer> foodId;

    @FXML
    private TableColumn<Food, String> foodName;

    @FXML
    private TableColumn<Food, String> foodCode;

    @FXML
    private TableColumn<Food, Integer> foodQuantity;

    @FXML
    private TableColumn<Food, Double> foodPrice;

    @FXML
    private TableColumn<Food, String> foodType;

    @FXML
    private TableColumn<Food, String> foodImageName;

    @FXML
    private TextField tfFoodSearch;

    private final FoodDataUtility foodDataUtility = new FoodDataUtility();
    boolean isNewButtonClick = false;
    private String imageName;
    private Integer foodUpdateId;

    @FXML
    void processImage(MouseEvent event) {
        FileChooser imageChooser = new FileChooser();
        imageChooser.setInitialDirectory(new File("/Users/sitminhtet/"));
        ExtensionFilter extensionFilter = new ExtensionFilter("Images","*.png","*.jpg","*.jpeg","*ico");
        imageChooser.getExtensionFilters().add(extensionFilter);

        File imageFile=imageChooser.showOpenDialog(null);
        if (imageFile!=null){

            InputStream is;
            Image image = new Image(imageFile.toURI().toString());
            foodImage.setImage(image);
            this.imageName= imageFile.getName();
        }
    }

    @FXML
    void processClear(ActionEvent event) {

    }

    @FXML
    void processDelete(ActionEvent event) {

    }

    @FXML
    void processEdit(ActionEvent event) {
        isNewButtonClick = false;
        enableAllField();
        Food food = foodTable.getSelectionModel().getSelectedItem();

        tfFoodName.setText(food.getFoodName());
        tfFoodCode.setText(food.getFoodCode().substring(4));
        tfFoodQuantity.setText(String.valueOf(food.getFoodQuantity()));
        tfFoodPrice.setText(String.valueOf(food.getFoodPrice()));
        cobPrefix.setValue(food.getFoodCode().substring(0,3));
        cbFoodType.setValue("Food Types");

        foodImage.setImage(new Image(getClass().getResourceAsStream("../src/image/food/")+food.getFoodImageName()));

        foodUpdateId = food.getId();
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
    void processSave(ActionEvent event) throws SQLException, IOException {
       String name  =tfFoodName.getText().trim();
       String code = cobPrefix.getValue()+"-"+tfFoodCode.getText().trim();
       Integer quantity = Integer.parseInt(tfFoodQuantity.getText());
       Double price = Double.parseDouble(tfFoodPrice.getText().trim());
       String type = cbFoodType.getValue();
            Integer index = this.imageName.indexOf(".");
       String image = this.imageName.substring(0,index)+".jpg";

       if (isNewButtonClick){
           Food food = new Food(name,code,quantity,price,type,image);

           boolean isSaveOk = foodDataUtility.saveFood(food);
           if (!isSaveOk){
                //showTable("select * from food where foodStatus ='Active';");

                File imageFile = new File("/src/image/food/"+image);
                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(this.foodImage.getImage(),null);
                ImageIO.write(bufferedImage,"jpg",imageFile);
           }
       }
       clearAllFields();
    }

    @FXML
    void processSearch(ActionEvent event) {

    }

    @FXML
    void processView(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> foodTypes = FXCollections.observableArrayList(
                "Fast Food","Fried Food","Diary & Produced","Traditional Food",
                        "European Food", "Chinese Food", "Korea Food","Japanese Food","India Food"
        );
        cbFoodType.setItems(foodTypes);
        ObservableList<String> prefixCode = FXCollections.observableArrayList(
                "faf","frf","dap","trf","euf","chf","kof","jpf","inf"
        );
        cobPrefix.setItems(prefixCode);

        /*
        foodId.setCellValueFactory(new PropertyValueFactory<>("id"));
        foodName.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        foodCode.setCellValueFactory(new PropertyValueFactory<>("foodCode"));
        foodQuantity.setCellValueFactory(new PropertyValueFactory<>("foodQuantity"));
        foodPrice.setCellValueFactory(new PropertyValueFactory<>("foodPrice"));
        foodType.setCellValueFactory(new PropertyValueFactory<>("foodType"));
        foodImageName.setCellValueFactory(new PropertyValueFactory<>("foodImageName"));

        showTable("select * from food where foodStatus = 'Active';");
        disableAllFields();

         */

    }


    public void showTable(String query){
        try {
            foodTable.setItems(foodDataUtility.getAllFood(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disableAllFields(){
        tfFoodCode.setDisable(true);
        tfFoodName.setDisable(true);
        tfFoodPrice.setDisable(true);
        tfFoodQuantity.setDisable(true);
        cobPrefix.setDisable(true);
        cbFoodType.setDisable(true);
        foodImage.setDisable(true);
    }

    public void enableAllField(){
        tfFoodCode.setDisable(false);
        tfFoodName.setDisable(false);
        tfFoodPrice.setDisable(false);
        tfFoodQuantity.setDisable(false);
        cobPrefix.setDisable(false);
        cbFoodType.setDisable(false);
        foodImage.setDisable(false);
    }

    public void clearAllFields(){
        tfFoodCode.clear();
        tfFoodName.clear();
        tfFoodQuantity.clear();
        tfFoodPrice.clear();
        cobPrefix.setValue("");
        //cobPrefix.getSelectionModel().clearSelection();
        cbFoodType.setValue("Type");
        //cbFoodType.getSelectionModel().clearSelection();
        foodImage.setImage(new Image(getClass().getResourceAsStream("../src/image/food/photo.png")));
    }
}
