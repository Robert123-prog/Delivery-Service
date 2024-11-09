import model.Customer;
import model.Department;
import model.Deposit;
import model.Store;

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
    }

    public void createStore(String name, String address, String contact){
        Integer Id = service.getNewStoreId();
        service.registerStore(Id, name, address, contact);
    }

    public void removeStore(Integer Id){
        service.removeStore(Id);
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
    }

    public void removeDeposit(Integer depositId){
        service.removeDeposit(depositId);
    }

    public void viewAllDeposits(){
        StringBuilder output = new StringBuilder("Available Stores:\n");
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
        StringBuilder output = new StringBuilder("Available Stores:\n");
        service.getCustomers().forEach(customer -> output.append(customer.toString()).append("\n"));
        System.out.println(output);
    }

    public void viewAllDepartments(){
        StringBuilder output = new StringBuilder("Available Stores:\n");
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
    }

    public boolean verifyDeliveryPerson(){
        return true;
    }

    public void createDeliveryPerson(String name, String phone, String license){
        Integer deliveryPersonId = service.getNewDeliveryPersonId();
        boolean verified = verifyDeliveryPerson();
        service.enrollAsDriver(deliveryPersonId, verified, name, phone, license);
    }

    public Integer getLastLoggedInCustomerId(){
        return service.getLastLoggedInCustomerId();
    }

}
