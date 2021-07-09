package entity;

public class StaffHolder {

    private Staff staff;

    private final  static StaffHolder STAFF_HOLDER = new StaffHolder();

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public static StaffHolder getStaffHolder() {
        return STAFF_HOLDER;
    }
}
