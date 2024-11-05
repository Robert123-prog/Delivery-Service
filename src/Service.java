import model.*;
import model.Package;
import repository.IRepository;

public class Service {

    protected static final int depozitLimit = 1000;

    private final IRepository<Store> storeIRepository;
    private final IRepository<Package> pachageIRepository;
    private final IRepository<Order> orderIRepository;
    private final IRepository<Customer> customerIRepository;
    private final IRepository<Department> departmentIRepository;
    private final IRepository<Employee> employeeIRepository;
    private final IRepository<Delivery> deliveryIRepository;
    private final IRepository<Deposit> depositIRepository;
    private final IRepository<Delivery_Person> deliveryPersonIRepository;
    private final IRepository<Personal_Vehicle> personalVehicleIRepository
            ;


    public Service(IRepository<Store> storeIRepository, IRepository<Package> pachageIRepository, IRepository<Order> orderIRepository, IRepository<Customer> customerIRepository, IRepository<Department> departmentIRepository, IRepository<Employee> employeeIRepository, IRepository<Delivery> deliveryIRepository, IRepository<Deposit> depositIRepository, IRepository<Delivery_Person> deliveryPersonIRepository, IRepository<Personal_Vehicle> personalVehicleIRepository) {
        this.storeIRepository = storeIRepository;
        this.pachageIRepository = pachageIRepository;
        this.orderIRepository = orderIRepository;
        this.customerIRepository = customerIRepository;
        this.departmentIRepository = departmentIRepository;
        this.employeeIRepository = employeeIRepository;
        this.deliveryIRepository = deliveryIRepository;
        this.depositIRepository = depositIRepository;
        this.deliveryPersonIRepository = deliveryPersonIRepository;
        this.personalVehicleIRepository = personalVehicleIRepository;
    }
}
