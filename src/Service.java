import model.*;

import repository.IRepository;
import java.time.LocalDateTime;
import java.util.List;

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
    private final IRepository<Personal_Vehicle> personalVehicleIRepository
            ;


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

    public List<Order> getOrders()
    {
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

    public void placeOrder(Integer CustomerId, Order order)
    {
        Customer customer = customerIRepository.get(CustomerId);
        if(customer != null)
        {
            customer.getOrders().add(order);
        }
        orderIRepository.update(order);
        customerIRepository.update(customer);

    }
    public void removeOrder(Integer CustomerId, Integer orderID)
    {
        Customer customer = customerIRepository.get(CustomerId);
        if(customer != null)
        {
            Order order = orderIRepository.get(orderID);
            if(order != null && customer.getOrders().contains(order)) {
                customer.getOrders().remove(order);
                orderIRepository.delete(orderID);
                customerIRepository.update(customer);
            }
        }
    }
    public void scheduleDelivery(Order order,LocalDateTime deliveryDateTime)
    {
        order.setDeliveryDateTime(deliveryDateTime);
        orderIRepository.update(order);
    }

    public void enrollAsDriver(Integer employeeId) {
        Employee employee = employeeIRepository.get(employeeId);
        if (employee == null) {
            throw new IllegalArgumentException("Employee with ID " + employeeId + " not found.");
        }
        if (employee.getLicense() == null || employee.getLicense().isEmpty()) {
            throw new IllegalArgumentException("Employee with ID " + employeeId + " does not have a valid driver's license.");
        }

        Delivery_Person deliveryPerson = new Delivery_Person(employee.getEmployeeID(), true);
        deliveryPersonIRepository.update(deliveryPerson);
    }

}
