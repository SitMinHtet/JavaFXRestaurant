package entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Food {

    private SimpleIntegerProperty id;
    private SimpleStringProperty foodName;
    private SimpleStringProperty foodCode;
    private SimpleIntegerProperty foodQuantity;
    private SimpleDoubleProperty foodPrice;
    private SimpleStringProperty foodType;
    private SimpleStringProperty foodImageName;

    public Food(Integer id, String foodName, String foodCode, Integer foodQuantity, Double foodPrice, String foodType, String foodImageName) {
        this.id = new SimpleIntegerProperty(id);
        this.foodName = new SimpleStringProperty(foodName);
        this.foodCode = new SimpleStringProperty(foodCode);
        this.foodQuantity = new SimpleIntegerProperty(foodQuantity);
        this.foodPrice = new SimpleDoubleProperty(foodPrice);
        this.foodType = new SimpleStringProperty(foodType);
        this.foodImageName = new SimpleStringProperty(foodImageName);
    }

    public Food(String foodName, String foodCode, Integer foodQuantity, Double foodPrice, String foodType, String foodImageName) {
        this.foodName = new SimpleStringProperty(foodName);
        this.foodCode = new SimpleStringProperty(foodCode);
        this.foodQuantity = new SimpleIntegerProperty(foodQuantity);
        this.foodPrice = new SimpleDoubleProperty(foodPrice);
        this.foodType = new SimpleStringProperty(foodType);
        this.foodImageName = new SimpleStringProperty(foodImageName);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFoodName() {
        return foodName.get();
    }

    public SimpleStringProperty foodNameProperty() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName.set(foodName);
    }

    public String getFoodCode() {
        return foodCode.get();
    }

    public SimpleStringProperty foodCodeProperty() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode.set(foodCode);
    }

    public int getFoodQuantity() {
        return foodQuantity.get();
    }

    public SimpleIntegerProperty foodQuantityProperty() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity.set(foodQuantity);
    }

    public double getFoodPrice() {
        return foodPrice.get();
    }

    public SimpleDoubleProperty foodPriceProperty() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice.set(foodPrice);
    }

    public String getFoodType() {
        return foodType.get();
    }

    public SimpleStringProperty foodTypeProperty() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType.set(foodType);
    }

    public String getFoodImageName() {
        return foodImageName.get();
    }

    public SimpleStringProperty foodImageNameProperty() {
        return foodImageName;
    }

    public void setFoodImageName(String foodImageName) {
        this.foodImageName.set(foodImageName);
    }
}

