package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Manager {

    private SimpleIntegerProperty managerID;
    private SimpleStringProperty managerFName;
    private SimpleStringProperty managerLName;
    private SimpleStringProperty managerUsername;
    private SimpleStringProperty managerEmail;
    private SimpleStringProperty managerPassword;
    private SimpleStringProperty managerPhone;
    private SimpleStringProperty managerAddress;
    private SimpleStringProperty managerStatus;
    private SimpleStringProperty managerDOB;
    //private static Status status;

    public Manager(Integer managerID, String managerFName, String managerLName, String managerUsername, String managerEmail, String managerPassword, String managerPhone, String managerAddress, String managerStatus, String managerDOB) {
        this.managerID = new SimpleIntegerProperty(managerID);
        this.managerFName = new SimpleStringProperty(managerFName);
        this.managerLName = new SimpleStringProperty(managerLName);
        this.managerUsername = new SimpleStringProperty(managerUsername);
        this.managerEmail = new SimpleStringProperty(managerEmail);
        this.managerPassword = new SimpleStringProperty(managerPassword);
        this.managerPhone = new SimpleStringProperty(managerPhone);
        this.managerAddress = new SimpleStringProperty(managerAddress);
        this.managerStatus = new SimpleStringProperty(managerStatus);
        this.managerDOB = new SimpleStringProperty(managerDOB);
    }

    public Manager(String managerFName, String managerLName, String managerUsername, String managerEmail, String managerPassword, String managerPhone, String managerAddress, String managerStatus, String managerDOB) {
        this.managerFName = new SimpleStringProperty(managerFName);
        this.managerLName = new SimpleStringProperty(managerLName);
        this.managerUsername = new SimpleStringProperty(managerUsername);
        this.managerEmail = new SimpleStringProperty(managerEmail);
        this.managerPassword = new SimpleStringProperty(managerPassword);
        this.managerPhone = new SimpleStringProperty(managerPhone);
        this.managerAddress = new SimpleStringProperty(managerAddress);
        this.managerStatus = new SimpleStringProperty(managerStatus);
        this.managerDOB = new SimpleStringProperty(managerDOB);
    }

    public int getManagerID() {
        return managerID.get();
    }

    public SimpleIntegerProperty managerIDProperty() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID.set(managerID);
    }

    public String getManagerFName() {
        return managerFName.get();
    }

    public SimpleStringProperty managerFNameProperty() {
        return managerFName;
    }

    public void setManagerFName(String managerFName) {
        this.managerFName.set(managerFName);
    }

    public String getManagerLName() {
        return managerLName.get();
    }

    public SimpleStringProperty managerLNameProperty() {
        return managerLName;
    }

    public void setManagerLName(String managerLName) {
        this.managerLName.set(managerLName);
    }

    public String getManagerUsername() {
        return managerUsername.get();
    }

    public SimpleStringProperty managerUsernameProperty() {
        return managerUsername;
    }

    public void setManagerUsername(String managerUsername) {
        this.managerUsername.set(managerUsername);
    }

    public String getManagerEmail() {
        return managerEmail.get();
    }

    public SimpleStringProperty managerEmailProperty() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail.set(managerEmail);
    }

    public String getManagerPassword() {
        return managerPassword.get();
    }

    public SimpleStringProperty managerPasswordProperty() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword.set(managerPassword);
    }

    public String getManagerPhone() {
        return managerPhone.get();
    }

    public SimpleStringProperty managerPhoneProperty() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone.set(managerPhone);
    }

    public String getManagerAddress() {
        return managerAddress.get();
    }

    public SimpleStringProperty managerAddressProperty() {
        return managerAddress;
    }

    public void setManagerAddress(String managerAddress) {
        this.managerAddress.set(managerAddress);
    }

    public String getManagerStatus() {
        return managerStatus.get();
    }

    public SimpleStringProperty managerStatusProperty() {
        return managerStatus;
    }

    public void setManagerStatus(String managerStatus) {
        this.managerStatus.set(managerStatus);
    }

    public String getManagerDOB() {
        return managerDOB.get();
    }

    public SimpleStringProperty managerDOBProperty() {
        return managerDOB;
    }

    public void setManagerDOB(String managerDOB) {
        this.managerDOB.set(managerDOB);
    }


    /*
    public static Status getStatus() {
        return status;
    }

    public static void setStatus(Status status) {
        Manager.status = status;
    }
     */
}
