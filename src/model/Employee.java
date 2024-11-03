package model;

import java.util.List;

public class Employee {
    private final int employeeID;
    private int departmentID;
    private String name;
    private String phone;
    private String license;
    private List<Delivery> deliveries;

    /*
    Department - Employee: composition => department initialized in constructor
    Employee - Delivery: aggregation => deliveries not initialized in constructor
     */

    public Employee(int employeeID, int departmentID, String name, String phone, String license){
        this.employeeID = employeeID;
        this.departmentID = departmentID;
        this.name = name;
        this.phone = phone;
        this.license = license;
    }

    public Employee(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", departmentID=" + departmentID +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", license='" + license + '\'' +
                ", deliveries=" + deliveries +
                '}';
    }
}
