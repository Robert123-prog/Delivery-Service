import model.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Controller {
    private final Service service;
    public Controller(Service service){
        this.service = service;
    }

    public void createLoggedInCustomer(String name, String address, String phone, String email){
        Integer Id = service.getNewCustomerId();
        service.createCustomer(Id, name, address, phone, email);
        System.out.println("Registered customer with id " + Id + " successfully");
    }

    /*
    alex
     */
//    public void createLoggedInDeliveryPerson(Integer departmentId, String name, String phone, String license){
//        Integer Id = service.getNewEmployeeId();
//        service.createEmployee(Id, departmentId, name, phone, license);
//    }

    public void createStore(String name, String address, String contact){
        Integer Id = service.getNewStoreId();
        service.registerStore(Id, name, address, contact);
        System.out.println("Registered store: " + name);
    }

    public void deleteStore(Integer storeId) {
        service.removeStore(storeId);
        System.out.println("Removed store " + storeId);
    }

    public void viewAllStores(){
        StringBuilder output = new StringBuilder("Available Stores:\n");
        service.getStores().forEach(store -> output.append(store.toString()).append("\n"));
        System.out.println(output);
    }

    public boolean storeSelection(Integer Id){
        List<Store> stores = service.getStores();

        for (Store store: stores){
            if (Objects.equals(store.getId(), Id)){
                return true;
            }
        }
        return false;
    }

    public void registerDeposit(Integer storeId, String depositAddress, String depositStatus){
        Integer depositId = service.getNewDepositId();
        service.registerDeposit(depositId, storeId, depositAddress, depositStatus);
        System.out.println("Registered deposit " + depositId + " to store " + storeId);
    }

    public void deleteDeposit(Integer depositId) {
        service.removeDeposit(depositId);
        System.out.println("Removed deposit " + depositId);
    }

    public void viewAllDeposits(){
        StringBuilder output = new StringBuilder("Available Deposits:\n");
        service.getDeposits().forEach(deposit -> output.append(deposit.toString()).append("\n"));
        System.out.println(output);
    }

    public boolean depositSelection(Integer Id){
        List<Deposit> deposits = service.getDeposits();

        for (Deposit deposit: deposits){
            if (Objects.equals(deposit.getId(), Id)){
                return true;
            }
        }
        return false;
    }

    public void viewAllCustomers(){
        StringBuilder output = new StringBuilder("Available Customers:\n");
        service.getCustomers().forEach(customer -> output.append(customer.toString()).append("\n"));
        System.out.println(output);
    }

    public void viewAllDepartments(){
        StringBuilder output = new StringBuilder("Available Departments:\n");
        service.getDepartments().forEach(department -> output.append(department.toString()).append("\n"));
        System.out.println(output);
    }

    public boolean departmentSelection(Integer Id){
        List<Department> departments = service.getDepartments();

        for (Department department: departments){
            if (Objects.equals(department.getId(), Id)){
                return true;
            }
        }
        return false;
    }

    public void createEmployee(Integer departmentId, String name, String phone, String license){
        Integer employeeId = service.getNewEmployeeId();
        service.createEmployee(employeeId, departmentId, name, phone, license);
        System.out.println("Registered employee " + employeeId + " to deposit " + departmentId);
    }

    public boolean verifyDeliveryPerson(){
        return true;
    }

    public void createDeliveryPerson(String name, String phone, String license){
        Integer deliveryPersonId = service.getNewDeliveryPersonId();
        boolean verified = verifyDeliveryPerson();
        service.enrollAsDriver(deliveryPersonId, verified, name, phone, license);
        System.out.println("Registered delivery person " + deliveryPersonId + " to deposit " + verified);
    }

    public void  deleteEmployee(Integer employeeId){
        service.unenrollEmployee(employeeId);
        System.out.println("Employee with id " + employeeId + " unenrolled successfully");
    }

    public void deleteDeliveryPerson(Integer deliveryPersonId){
        service.unenrollDeliveryPerson(deliveryPersonId);
        System.out.println("Delivery person with id " + deliveryPersonId + " unenrolled successfully");
    }

    public void pickDeliveryByEmployee(Integer employeeId, Integer deliveryId){
        service.pickDelivery(employeeId,deliveryId);
        System.out.println("Picked delivery with id " + deliveryId + "by Employee with id " + employeeId + " successfully");
    }

    public void pickDeliveryByPerson(Integer deliveryPersonId, Integer deliveryId){
        service.pickDeliveryToPerson(deliveryPersonId,deliveryId);
        System.out.println("Picked delivery with id " + deliveryId + "by Person with id " + deliveryPersonId + " successfully");
    }

    public void cancelDeliveryByEmployee(Integer employeeId, Integer deliveryId){
        service.removeDelivery(deliveryId);
        System.out.println("Delivery with id " + deliveryId + " cancelled by Employee with id" + employeeId + " successfully");
    }

    public void cancelDeliveryByPerson(Integer deliveryPersonId, Integer deliveryId){
        service.removeDeliveryToPerson(deliveryId);
        System.out.println("Delivery with id " + deliveryId + " cancelled by Delivery Person with id" + deliveryPersonId + " successfully");
    }

    public void makeAnOrder(Integer CustomerId, Integer orderID, Date orderDate, LocalDateTime deliveryDateTime, double cost, String status){
        service.placeOrder(CustomerId, orderID, orderDate, deliveryDateTime, cost, status);
        System.out.println("Order with id " + orderID + "by customer with id " + CustomerId + " successfully");
    }

    public void removeAnOrder(Integer CustomerId, Integer orderID){
        service.removeOrder(CustomerId, orderID);
        System.out.println("Order with id " + orderID + "by customer with id" + CustomerId + " removed successfully");
    }


}
