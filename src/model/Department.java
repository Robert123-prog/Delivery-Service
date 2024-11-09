package model;

import java.util.List;

public class Department implements HasID{
    private final Integer departmentID;
    private String name;
    private String task;
    private List<Employee> employees;

    public Department(Integer departmentID, String name, String task){
        this.departmentID = departmentID;
        this.name = name;
        this.task = task;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean removeEmployee(Employee employee) {
        boolean removed = employees.remove(employee);
        return removed;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", name='" + name + '\'' +
                ", task='" + task + '\'' +
                ", employees=" + employees +
                '}';
    }
    public Integer getId() {
        return departmentID;
    }
}
