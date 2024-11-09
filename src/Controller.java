import model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public boolean verifyDeliveryPerson(Integer deliveryPersonId) {
        boolean isValid = service.verifyDeliveryPersonLicense(deliveryPersonId);
        if (isValid) {
            return true;
        } else {
            return false;
        }
    }

    public void createDeliveryPerson(String name, String phone, String license){
        Integer deliveryPersonId = service.getNewDeliveryPersonId();
        boolean verified = verifyDeliveryPerson(deliveryPersonId);
        service.enrollAsDriver(deliveryPersonId, verified, name, phone, license);
        System.out.println("Registered delivery person " + deliveryPersonId + " to deposit " + verified);
    }

    public void deleteEmployee(Integer employeeId){
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

    public void makeAnOrder(Integer CustomerId, Date orderDate, LocalDateTime deliveryDateTime, double cost, String status){
        Integer orderID = service.getNewOrderId();
        service.placeOrder(CustomerId, orderID, orderDate, deliveryDateTime, cost, status);
        System.out.println("Order with id " + orderID + "by customer with id " + CustomerId + " successfully");
    }

    public void removeAnOrder(Integer CustomerId, Integer orderID){
        service.removeOrder(CustomerId, orderID);
        System.out.println("Order with id " + orderID + "by customer with id" + CustomerId + " removed successfully");
    }

    public Integer getLastLoggedInCustomerId(){
        return service.getLastLoggedInCustomerId();
    }

    public void getAllPackages(){
        System.out.println(service.getPackages());
    }

    public boolean validatePackages(List<Integer> Ids){
        List<Packages> packages = service.getPackages();

        for (Integer id : Ids) {
            boolean found = false;
            for (Packages packageItem : packages) {
                if (packageItem.getId().equals(id)) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    public List<Packages> getValidatedPackages(List<Integer> packageIds){
        List<Packages> allPackages = service.getPackages();
        List<Packages> selectedPackages = new ArrayList<>();

        for (Integer id : packageIds) {
            for (Packages packages : allPackages) {
                if (packages.getId().equals(id)) {
                    selectedPackages.add(packages);
                    break;
                }
            }
        }
        return selectedPackages;
    }

    public double calculateOrderCost(List<Packages> packages){
        return service.calculateOrderCostOnPackages(packages);
    }

    public List<Order> getPersonalOrders(Integer customerId){
        List<Order> orders = service.getOrders();
        List<Order> personalOrders = new ArrayList<>();

        for (Order order: orders){
            if (order.getCustomerID() == customerId){
                personalOrders.add(order);
            }
        }
        return personalOrders;
    }

    public void viewPersonalOrders(List<Order> orders){
        StringBuilder output = new StringBuilder("Available Departments:\n");
        orders.forEach(order -> output.append(order.toString()).append("\n"));
        System.out.println(output);
    }

    public boolean validateSelectedOrder(Integer Id){
        List<Order> orders = service.getOrders();

        for (Order order: orders){
            if (Objects.equals(order.getId(), Id)){
                return true;
            }
        }
        return false;
    }

    public Order getSelectedOrder(Integer orderId){
        List<Order> orders = service.getOrders();

        for(Order order: orders){
            if (Objects.equals(order.getId(), orderId)){
                return order;
            }
        }
        return null;
    }

    public void removeSelectedOrder(Integer customerId, Integer orderId){
        service.removeOrder(customerId, orderId);
    }

    public void viewAllEmployees(){
        StringBuilder output = new StringBuilder("All Employees:\n");
        service.getEmployees().forEach(employee -> output.append(employee.toString()).append("\n"));
        System.out.println(output);
    }

    public void viewAllDeliveries(){
        StringBuilder output = new StringBuilder("All Deliveries:\n");
        service.getDelivery().forEach(delivery -> output.append(delivery.toString()).append("\n"));
        System.out.println(output);
    }

    public void createPackage(int cost, double weight, String dimensions){
        Integer packageId = service.getNewPackageId();
        service.createPackage(packageId, cost, weight, dimensions);
    }

    public List<Delivery> getUnassignedDeliveries(){
        List<Delivery> deliveries = service.getDelivery();
        List<Delivery> unassignedDeliveries = new ArrayList<>();

        for (Delivery delivery: deliveries){
            if (delivery.getEmployeeID() == null){
                unassignedDeliveries.add(delivery);
            }
        }
        return unassignedDeliveries;
    }

    public void viewUnassignedDeliveries(List<Delivery> deliveries){
        StringBuilder output = new StringBuilder("Unassigned Deliveries:\n");
        deliveries.forEach(delivery -> output.append(delivery.toString()).append("\n"));
        System.out.println(output);
    }

    public boolean validateSelectedDelivery(Integer deliveryId){
        List<Delivery> deliveries = service.getDelivery();

        for (Delivery delivery: deliveries){
            if (Objects.equals(delivery.getDeliveryID(), deliveryId)){
                return true;
            }
        }
        return false;
    }

    public void assignEmployeeToUnassignedDelivery(Integer employeeId, Integer deliveryId){
        service.pickDelivery(employeeId, deliveryId);
    }

    public Integer getLastLoggedInEmployeeId(){
        return service.getLastLoggedInEmployeeId();
    }

}
