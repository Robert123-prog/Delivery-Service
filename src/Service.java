import model.*;

import repository.IRepository;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Service {

    protected static final int depozitLimit = 1000;

    private final IRepository<Store> storeIRepository;
    private final IRepository<Packages> packageIRepository;
    private final IRepository<Order> orderIRepository;
    private final IRepository<Customer> customerIRepository;
    private final IRepository<Department> departmentIRepository;
    private final IRepository<Employee> employeeIRepository;
    private final IRepository<Delivery> deliveryIRepository;
    private final IRepository<Deposit> depositIRepository;
    private final IRepository<Delivery_Person> deliveryPersonIRepository;
    private final IRepository<Personal_Vehicle> personalVehicleIRepository;


    public Service(IRepository<Store> storeIRepository, IRepository<Packages> packageIRepository, IRepository<Packages> packageIRepository1, IRepository<Order> orderIRepository, IRepository<Customer> customerIRepository, IRepository<Department> departmentIRepository, IRepository<Employee> employeeIRepository, IRepository<Delivery> deliveryIRepository, IRepository<Deposit> depositIRepository, IRepository<Delivery_Person> deliveryPersonIRepository, IRepository<Personal_Vehicle> personalVehicleIRepository) {
        this.storeIRepository = storeIRepository;
        this.packageIRepository = packageIRepository1;
        this.orderIRepository = orderIRepository;
        this.customerIRepository = customerIRepository;
        this.departmentIRepository = departmentIRepository;
        this.employeeIRepository = employeeIRepository;
        this.deliveryIRepository = deliveryIRepository;
        this.depositIRepository = depositIRepository;
        this.deliveryPersonIRepository = deliveryPersonIRepository;
        this.personalVehicleIRepository = personalVehicleIRepository;
    }


    public List<Employee> getEmployees() {
        return employeeIRepository.readAll();
    }

    public List<Packages> getPackagesFromOrder(Order order) {
        return order.getPackages();
    }

    public List<Order> getOrders() {
        return orderIRepository.readAll();
    }

    public List<Customer> getCustomers() {
        return customerIRepository.readAll();
    }

    public List<Department> getDepartments() {
        return departmentIRepository.readAll();
    }

    public List<Delivery> getDelivery() {
        return deliveryIRepository.readAll();
    }

    public List<Delivery_Person> getDeliveryPerson() {
        return deliveryPersonIRepository.readAll();
    }

    public List<Store> getStores() {
        return storeIRepository.readAll();
    }

    public List<Personal_Vehicle> getPersonalVehicle() {
        return personalVehicleIRepository.readAll();
    }

    public List<Packages> getPackages() {
        return packageIRepository.readAll();
    }

    public void placeOrder(Integer CustomerId, Integer orderID, Date orderDate, LocalDateTime deliveryDateTime, double cost, String status) {
        Customer customer = customerIRepository.get(CustomerId);
        Order order = new Order(orderID,orderDate,deliveryDateTime,cost,status);
        if (customer != null) {
            customer.getOrders().add(order);
        }
        orderIRepository.update(order);
        customerIRepository.update(customer);
    }

    public void removeOrder(Integer CustomerId, Integer orderID) {
        Customer customer = customerIRepository.get(CustomerId);
        if (customer != null) {
            Order order = orderIRepository.get(orderID);
            if (order != null && customer.getOrders().contains(order)) {
                customer.getOrders().remove(order);
                orderIRepository.delete(orderID);
                customerIRepository.update(customer);
            }
        }
    }
/*
    public void scheduleDelivery(Order order, LocalDateTime deliveryDateTime) {
        order.setDeliveryDateTime(deliveryDateTime);
        orderIRepository.update(order);
    }
*/
    public void enrollAsDriver(Integer deliveryPersonId, String name, String phone, String license) {
        if (license == null || license.isEmpty()) {
            throw new IllegalArgumentException("Provided license is not valid.");
        }
        Employee newEmployee = new Employee(name, phone, license);
        employeeIRepository.create(newEmployee);
        Delivery_Person deliveryPerson = new Delivery_Person(deliveryPersonId, true, phone, name, license);
        deliveryPersonIRepository.update(deliveryPerson);
    }

    public void registerStore(Integer storeId, String name, String address, String contact) {
        if (storeId == null || name == null || name.isEmpty() || address == null || address.isEmpty() || contact == null || contact.isEmpty()) {
            throw new IllegalArgumentException("All fields are required for shop registration.");
        }
        Store newStore = new Store(storeId, name, address, contact);
        storeIRepository.create(newStore);
    }

    public void registerDeposit(Integer depositId, Integer storeId, Integer packageId, String address, String status) {
        if (depositId == null || storeId == null || packageId == null ||
                address == null || address.isEmpty() ||
                status == null || status.isEmpty()) {
            throw new IllegalArgumentException("All fields are required for deposit registration.");
        }
        Deposit newDeposit = new Deposit(depositId, address, status);
        depositIRepository.create(newDeposit);
        Store store = storeIRepository.get(storeId);
        if (store != null) {
            store.addDeposit(newDeposit);
        } else {
            throw new IllegalArgumentException("Store with ID " + storeId + " not found.");
        }
    }

    public void removeStore(Integer storeId) {
        Store store = storeIRepository.get(storeId);
        if (store != null) {
            storeIRepository.delete(storeId);
        }
    }

    public void removeDeposit(Integer depositId) {
        Deposit deposit = depositIRepository.get(depositId);
        Store store = storeIRepository.get(depositId);
        if (store != null && store.getDeposits().contains(deposit)) {
            store.getDeposits().remove(deposit);
            depositIRepository.delete(depositId);
            storeIRepository.update(store);
        }
    }


    public void createCustomer(Integer Id, String name, String address, String phone, String email) {
        Customer customer = new Customer(Id, name, address, phone, email);
        customerIRepository.create(customer);
    }

    public void createEmployee(Integer Id, Integer departmentId, String name, String phone, String license) {
        Employee employee = new Employee(Id, departmentId, name, phone, license);
        employeeIRepository.create(employee);
        Department department = departmentIRepository.get(departmentId);
        if (department != null) {
            department.addEmployee(employee);
        } else {
            throw new IllegalArgumentException("Store with ID " + departmentId + " not found.");
        }
    }
    /*
    alex
     */
    //public void createNewDeliveryPerson(Integer Id, boolean verified, )

    public void createStore(Integer Id, String name, String address, String contact) {
        Store store = new Store(Id, name, address, contact);
        storeIRepository.create(store);
    }

    public Integer getNewCustomerId() {
        int maxId = 0;
        for (Integer Id : customerIRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId + 1;
    }

    public Integer getNewEmployeeId() {
        int maxId = 0;
        for (Integer Id : employeeIRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId + 1;
    }

    public Integer getNewDeliveryPersonId() {
        int maxId = 0;
        for (Integer Id : deliveryIRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId + 1;
    }

    public Integer getNewStoreId() {
        int maxId = 0;
        for (Integer Id : storeIRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId + 1;
    }
}
