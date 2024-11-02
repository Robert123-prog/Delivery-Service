package model;

import java.util.List;

public class Department {
    private final int departmentID;
    private String name;
    private String task;
    private List<Employee> employees;

    public Department(int departmentID, String name, String task, List<Employee> employees){
        this.departmentID = departmentID;
        this.name = name;
        this.task = task;
        this.employees = employees;
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

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
