package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Staff {

    private SimpleIntegerProperty staffID;
    private SimpleStringProperty staffFName;
    private SimpleStringProperty staffLName;
    private SimpleStringProperty staffUsername;
    private SimpleStringProperty staffEmail;
    private SimpleStringProperty staffPassword;
    private SimpleStringProperty staffPhone;
    private SimpleStringProperty staffAddress;
    private SimpleStringProperty staffStatus;
    private SimpleStringProperty staffDOB;

    public Staff(Integer staffID, String staffFName, String staffLName, String staffUsername, String staffEmail, String staffPassword, String staffPhone, String staffAddress, String staffStatus, String staffDOB) {
        this.staffID = new SimpleIntegerProperty(staffID);
        this.staffFName = new SimpleStringProperty(staffFName);
        this.staffLName = new SimpleStringProperty(staffLName);
        this.staffUsername = new SimpleStringProperty(staffUsername);
        this.staffEmail = new SimpleStringProperty(staffEmail);
        this.staffPassword = new SimpleStringProperty(staffPassword);
        this.staffPhone = new SimpleStringProperty(staffPhone);
        this.staffAddress = new SimpleStringProperty(staffAddress);
        this.staffStatus = new SimpleStringProperty(staffStatus);
        this.staffDOB = new SimpleStringProperty(staffDOB);
    }

    public Staff(String staffFName, String staffLName, String staffUsername, String staffEmail, String staffPassword, String staffPhone, String staffAddress, String staffStatus, String staffDOB) {
        this.staffFName = new SimpleStringProperty(staffFName);
        this.staffLName = new SimpleStringProperty(staffLName);
        this.staffUsername = new SimpleStringProperty(staffUsername);
        this.staffEmail = new SimpleStringProperty(staffEmail);
        this.staffPassword = new SimpleStringProperty(staffPassword);
        this.staffPhone = new SimpleStringProperty(staffPhone);
        this.staffAddress = new SimpleStringProperty(staffAddress);
        this.staffStatus = new SimpleStringProperty(staffStatus);
        this.staffDOB = new SimpleStringProperty(staffDOB);

    }

    public int getStaffID() {
        return staffID.get();
    }

    public SimpleIntegerProperty staffIDProperty() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID.set(staffID);
    }

    public String getStaffFName() {
        return staffFName.get();
    }

    public SimpleStringProperty staffFNameProperty() {
        return staffFName;
    }

    public void setStaffFName(String staffFName) {
        this.staffFName.set(staffFName);
    }

    public String getStaffLName() {
        return staffLName.get();
    }

    public SimpleStringProperty staffLNameProperty() {
        return staffLName;
    }

    public void setStaffLName(String staffLName) {
        this.staffLName.set(staffLName);
    }

    public String getStaffUsername() {
        return staffUsername.get();
    }

    public SimpleStringProperty staffUsernameProperty() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername.set(staffUsername);
    }

    public String getStaffEmail() {
        return staffEmail.get();
    }

    public SimpleStringProperty staffEmailProperty() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail.set(staffEmail);
    }

    public String getStaffPassword() {
        return staffPassword.get();
    }

    public SimpleStringProperty staffPasswordProperty() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword.set(staffPassword);
    }

    public String getStaffPhone() {
        return staffPhone.get();
    }

    public SimpleStringProperty staffPhoneProperty() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone.set(staffPhone);
    }

    public String getStaffAddress() {
        return staffAddress.get();
    }

    public SimpleStringProperty staffAddressProperty() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress.set(staffAddress);
    }

    public String getStaffStatus() {
        return staffStatus.get();
    }

    public SimpleStringProperty staffStatusProperty() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus.set(staffStatus);
    }

    public String getStaffDOB() {
        return staffDOB.get();
    }

    public SimpleStringProperty staffDOBProperty() {
        return staffDOB;
    }

    public void setStaffDOB(String staffDOB) {
        this.staffDOB.set(staffDOB);
    }
}
