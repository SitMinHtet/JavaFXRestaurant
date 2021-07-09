package entity;

public final class ManagerHolder {

    private Manager manager;

    private final static ManagerHolder MANAGER_HOLDER = new ManagerHolder();  //getter only

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public static ManagerHolder getManagerHolder() {
        return MANAGER_HOLDER;
    }
}
