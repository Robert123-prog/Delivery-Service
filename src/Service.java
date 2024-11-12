import model.*;

import repository.IRepository;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Service class that manages the business logic for a delivery management system.
 * This class handles operations related to stores, packages, orders, customers,
 * departments, employees, deliveries, deposits, and delivery personnel.
 */
public class Service {
    /**
     * Maximum limit for deposits
     */
    protected static final int depozitLimit = 1000;

    /**
     * Constructs a new Service with all required repositories
     *
     * @param storeIRepository Repository for Store entities
     * @param packageIRepository Repository for Package entities
     * @param orderIRepository Repository for Order entities
     * @param customerIRepository Repository for Customer entities
     * @param departmentIRepository Repository for Department entities
     * @param employeeIRepository Repository for Employee entities
     * @param deliveryIRepository Repository for Delivery entities
     * @param depositIRepository Repository for Deposit entities
     * @param deliveryPersonIRepository Repository for DeliveryPerson entities
     * @param personalVehicleIRepository Repository for PersonalVehicle entities
     */
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


    public Service(IRepository<Store> storeIRepository, IRepository<Packages> packageIRepository, IRepository<Order> orderIRepository, IRepository<Customer> customerIRepository, IRepository<Department> departmentIRepository, IRepository<Employee> employeeIRepository, IRepository<Delivery> deliveryIRepository, IRepository<Deposit> depositIRepository, IRepository<Delivery_Person> deliveryPersonIRepository, IRepository<Personal_Vehicle> personalVehicleIRepository) {
        this.storeIRepository = storeIRepository;
        this.packageIRepository = packageIRepository;
        this.orderIRepository = orderIRepository;
        this.customerIRepository = customerIRepository;
        this.departmentIRepository = departmentIRepository;
        this.employeeIRepository = employeeIRepository;
        this.deliveryIRepository = deliveryIRepository;
        this.depositIRepository = depositIRepository;
        this.deliveryPersonIRepository = deliveryPersonIRepository;
        this.personalVehicleIRepository = personalVehicleIRepository;
    }

    /**
     * Retrieves all employees from the repository
     *
     * @return List of all employees
     */
    public List<Employee> getEmployees() {
        return employeeIRepository.readAll();
    }
    /**
     * Retrieves all packages associated with a specific order
     *
     * @param order The order to get packages for
     * @return List of packages in the order
     */
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

    public List<Deposit> getDeposits(){
        return depositIRepository.readAll();
    }

    public List<String> getTransportationTypes(){
        List<String> enumNames = Stream.of(Transportation_Type.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        return enumNames;
    }
    /**
     * Places a new order in the system
     *
     * @param CustomerId Customer's unique identifier
     * @param orderID Order's unique identifier
     * @param orderDate Date when the order was placed
     * @param deliveryDateTime Scheduled delivery date and time
     * @param cost Total cost of the order
     * @param status Current status of the order
     */
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
    /**
     * Schedules a delivery for a specific order
     *
     * @param orderId ID of the order to schedule delivery for
     * @param deliveryDateTime Date and time when delivery should occur
     * @throws IllegalArgumentException if order with specified ID is not found
     */
    public void scheduleDelivery(Integer orderId, LocalDateTime deliveryDateTime) {
        Order order = orderIRepository.get(orderId);
        if (order != null) {
            order.setDeliveryDateTime(deliveryDateTime);
            orderIRepository.update(order);
        } else {
            throw new IllegalArgumentException("Order with ID " + orderId + " not found.");
        }
    }

    public void deleteCustomer(Integer customerId) {
        Customer customer = customerIRepository.get(customerId);
        if (customer != null) {
            customerIRepository.delete(customerId);
        }
    }
    /**
     * Registers a new delivery person in the system
     *
     * @param deliveryPersonId Unique identifier for the delivery person
     * @param name Full name of the delivery person
     * @param phone Contact phone number
     * @param license Driver's license number
     */
    public void enrollAsDriver(Integer deliveryPersonId, String name, String phone, String license) {
    // Create a new DeliveryPerson instance
    Delivery_Person deliveryPerson = new Delivery_Person(deliveryPersonId,name,phone,license);
    // Add the DeliveryPerson instance to both repositories if needed
    deliveryPersonIRepository.create(deliveryPerson);
    employeeIRepository.create(deliveryPerson);
    }
    /**
     * Registers a new store in the system
     *
     * @param storeId Unique identifier for the store
     * @param name Name of the store
     * @param address Physical address of the store
     * @param contact Contact information for the store
     * @throws IllegalArgumentException if any required field is null or empty
     */
    public void registerStore(Integer storeId, String name, String address, String contact) {
        if (storeId == null || name == null || name.isEmpty() || address == null || address.isEmpty() || contact == null || contact.isEmpty()) {
            throw new IllegalArgumentException("All fields are required for shop registration.");
        }
        Store newStore = new Store(storeId, name, address, contact);
        storeIRepository.create(newStore);
    }

    public void registerDeposit(Integer depositId, Integer storeId, String address, String status) {
        if (depositId == null || storeId == null ||
                address == null || address.isEmpty() ||
                status == null || status.isEmpty()) {
            throw new IllegalArgumentException("All fields are required for deposit registration.");
        }
        Deposit newDeposit = new Deposit(depositId, address, status, storeId);
        depositIRepository.create(newDeposit);
        Store store = storeIRepository.get(storeId);
        if (store != null) {
            store.addDeposit(newDeposit);
        } else {
            throw new IllegalArgumentException("Depozit with ID " + storeId + " not found.");
        }
    }

    public void removeStore(Integer storeId) {
        Store store = storeIRepository.get(storeId);
        if (store != null) {
            storeIRepository.delete(storeId);
        }
    }

    public void removeDeposit(Integer storeId, Integer depositId) {
        //Deposit deposit = depositIRepository.get(depositId);
        Store store = storeIRepository.get(storeId);
        store.getDeposits().removeIf(deposit -> deposit.getDepositID() == depositId);
            depositIRepository.delete(depositId);
            storeIRepository.update(store);
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
            throw new IllegalArgumentException("Department with ID " + departmentId + " not found.");
        }
    }
    public void pickDelivery(Integer employeeId ,Integer deliveryId) {
        Delivery delivery = deliveryIRepository.get(deliveryId);
        Employee employee = employeeIRepository.get(employeeId);
        if (delivery != null && employee != null) {
            employee.addDelivery(delivery);
            delivery.setEmployeeID(employeeId);
            employeeIRepository.update(employee);
            deliveryIRepository.update(delivery);
        }
        else
            throw new IllegalArgumentException("Delivery with ID " + deliveryId + " not found.");
    }

    public void pickDeliveryToPerson(Integer deliverPersonId, Integer deliveryId) {
        Delivery delivery = deliveryIRepository.get(deliveryId);
        Delivery_Person deliveryPerson = deliveryPersonIRepository.get(deliverPersonId);
        if (delivery != null && deliveryPerson != null) {
            deliveryPerson.addDelivery(delivery);
            deliveryPersonIRepository.update(deliveryPerson);
            delivery.setDeliveryPeronID(deliverPersonId);
            deliveryIRepository.update(delivery);
        }
    }

    public void removeDelivery(Integer deliveryId) {
        Delivery delivery = deliveryIRepository.get(deliveryId);
        Employee employee = employeeIRepository.get(delivery.getEmployeeID());
        employee.getDeliveries().removeIf(d -> d.getDeliveryID().equals(deliveryId));
        employeeIRepository.update(employee);
        deliveryIRepository.delete(deliveryId);
    }
    public void removeDeliveryToPerson(Integer deliveryId) {
        Delivery delivery = deliveryIRepository.get(deliveryId);
        Delivery_Person deliveryPerson = deliveryPersonIRepository.get(delivery.getDeliveryPeronID());
        deliveryPerson.getDeliveries().removeIf(d -> d.getDeliveryID().equals(deliveryId));
        deliveryPersonIRepository.update(deliveryPerson);
        deliveryIRepository.delete(deliveryId);
    }
    /**
     * Calculates and updates the total cost of an order based on its packages
     *
     * @param orderId ID of the order to calculate cost for
     */
    public void calculateAndUpdateOrderCost(Integer orderId) {
        Order order = orderIRepository.get(orderId);
        double totalCost = order.getPackages().stream()
                .mapToDouble(Packages::getCost)
                .sum();
        order.setCost(totalCost);
        orderIRepository.update(order);
    }
    /**
     * Calculates the total cost of a list of packages
     *
     * @param packages List of packages to calculate total cost for
     * @return Total cost of all packages
     */
    public double calculateOrderCostOnPackages(List<Packages> packages){
        double total = 0.0;

        for (Packages packages1: packages){
            total += packages1.getCost();
        }
        return total;
    }
    /**
     * Verifies if a delivery person's license is valid
     *
     * @param deliveryPersonId ID of the delivery person
     * @param license License to verify
     * @return true if license is valid, false otherwise
     */
    public boolean verifyDeliveryPersonLicense(Integer deliveryPersonId,String license) {
        Delivery_Person deliveryPerson = deliveryPersonIRepository.get(deliveryPersonId);
        if (isLicenseCategoryValid(license)) {
            System.out.println("License for delivery person " + deliveryPersonId + " is valid.");
            return true;
        } else {
            System.out.println("License for delivery person " + deliveryPersonId + " is not valid.");
            return false;
        }
    }
    /**
     * Helper method to validate license categories
     *
     * @param licenseCategory Category of license to validate
     * @return true if license category is valid, false otherwise
     */
    private boolean isLicenseCategoryValid(String licenseCategory) {
        Set<String> validCategories = Set.of("B", "BE", "C", "CE");
        return validCategories.contains(licenseCategory);
    }

    public void unenrollEmployee(Integer employeeId) {
        Employee employee = employeeIRepository.get(employeeId);
        Department department = departmentIRepository.get(employee.getDepartmentID());
        if (department != null) {
            department.removeEmployee(employee);
        }
        employeeIRepository.delete(employeeId);

    }
    public void unenrollDeliveryPerson(Integer deliveryPersonId) {
        Delivery_Person deliveryPerson = deliveryPersonIRepository.get(deliveryPersonId);
        deliveryIRepository.delete(deliveryPersonId);
    }
    /**
     * Generates a new unique customer ID
     *
     * @return Next available customer ID
     */
    public Integer getNewCustomerId() {
        int maxId = 0;
        for (Integer Id : customerIRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId + 1;
    }

    public Integer getLastLoggedInCustomerId() {
        int maxId = 0;
        for (Integer Id : customerIRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId;
    }


    public Integer getNewDepositId() {
        int maxId = 0;
        for (Integer Id : depositIRepository.getKeys()) {
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

    public Integer getNewOrderId() {
        int maxId = 0;
        for (Integer Id : orderIRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId + 1;
    }

    public Integer getNewPackageId(){
        int maxId = 0;
        for (Integer Id : packageIRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId + 1;
    }

    public void createPackage(Integer packageId, int cost, double weight, String dimensions){
        Packages packages = new Packages(packageId, weight, dimensions, cost);
        packageIRepository.create(packages);
    }

    public Integer getLastLoggedInEmployeeId() {
        int maxId = 0;
        for (Integer Id : employeeIRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId;
    }

    public Integer getLastLoggedInDeliveryPersonId() {
        int maxId = 0;
        for (Integer Id : deliveryPersonIRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId;
    }
    /**
     * Assigns a personal vehicle to a delivery person
     *
     * @param deliveryPersonId ID of the delivery person
     * @param personalVehicleId ID of the personal vehicle to assign
     */
    public void assignPersonalVehicle(Integer deliveryPersonId, Integer personalVehicleId){
        Delivery_Person deliveryPerson = deliveryPersonIRepository.get(deliveryPersonId);
        Personal_Vehicle personalVehicle = personalVehicleIRepository.get(personalVehicleId);

        deliveryPerson.setPersonalVehicleId(personalVehicleId);
        personalVehicle.setDeliveryPersonID(deliveryPersonId);

        deliveryPersonIRepository.update(deliveryPerson);
        personalVehicleIRepository.update(personalVehicle);
    }

    public Delivery_Person getLastLoggedInDeliveryPerson() {
        Integer Id = getLastLoggedInDeliveryPersonId();
        Delivery_Person deliveryPerson = deliveryPersonIRepository.get(Id);

        return deliveryPerson;
    }

    public Personal_Vehicle getPersonalVehicle(Integer Id){
        return personalVehicleIRepository.get(Id);
    }
    /**
     * Retrieves all deliveries assigned to a specific employee
     *
     * @param employeeId ID of the employee
     * @return List of deliveries assigned to the employee
     */
    public List<Delivery> getDeliveriesForEmployee(Integer employeeId) {
        Employee employee = employeeIRepository.get(employeeId);
        return employee.getDeliveries();
    }
    /**
     * Removes a delivery assignment from an employee
     *
     * @param employeeId ID of the employee
     * @param deliveryId ID of the delivery to remove
     * @throws IllegalArgumentException if employee or delivery not found
     */
    public void dropDelivery(Integer employeeId, Integer deliveryId) {
        Employee employee = employeeIRepository.get(employeeId);
        Delivery delivery = deliveryIRepository.get(deliveryId);
        if (employee != null && delivery != null) {
            employee.removeDeliv(deliveryId);
            delivery.setEmployeeID(null);
            employeeIRepository.update(employee);
            deliveryIRepository.update(delivery);
        } else {
            throw new IllegalArgumentException("Employee or Delivery not found.");
        }
    }
}
