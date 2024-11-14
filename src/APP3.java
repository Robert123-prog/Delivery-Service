import model.*;
import repository.IRepository;
import repository.InMemoryRepo;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
/**
 * Main application class for the delivery management system.
 * This class provides a console-based user interface for interacting with different
 * aspects of the delivery system including users, sellers, customers, employees,
 * and delivery persons.
 */
public class APP3{
    private Controller controller;
    private Scanner scanner;
    /**
     * Constructs a new APP3 instance with the specified controller.
     *
     * @param controller The controller instance to handle business logic
     */
    public APP3(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
        createUI();
    }
    /**
     * Creates and manages the main user interface loop.
     * Displays the main menu and handles user input for navigation between different menus.
     */
    private void createUI() {
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. User");
            System.out.println("2. Seller");
            System.out.println("3. Customer");
            System.out.println("4. Employee");
            System.out.println("5. Delivery Person");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    userMenu();
                    break;
                case 2:
                    sellerMenu();
                    break;
                case 3:
                    customerMenu();
                    break;
                case 4:
                    employeeMenu();
                    break;
                case 5:
                    deliveryPersonMenu();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    /**
     * Manages the user menu interface.
     * Provides functionality for viewing transportation types and managing user accounts.
     */
    private void userMenu() {
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. View All Transportation Types");
            System.out.println("2. Delete Customer");
            System.out.println("3. Delete Employee");
            System.out.println("4. Delete Delivery Person");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<String> transportationTypes = controller.getAllTransportationTypes();
                    controller.viewAllTransportationTypes(transportationTypes);
                    break;
                case 2:
                    controller.viewAllCustomers();
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    controller.deleteCustomer(customerId);
                    controller.viewAllCustomers();
                    break;
                case 3:
                    controller.viewAllEmployees();
                    System.out.print("Enter Employee ID: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    controller.deleteEmployee(employeeId);
                    break;
                case 4:
                    controller.viewAllDeliveryPersons();
                    System.out.print("Enter Delivery Person ID: ");
                    int deliveryPersonId = scanner.nextInt();
                    scanner.nextLine();
                    controller.deleteDeliveryPerson(deliveryPersonId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    /**
     * Manages the seller menu interface.
     * Provides functionality for managing stores, deposits, and packages.
     */
    private void sellerMenu() {
        while (true) {
            System.out.println("Seller Menu:");
            System.out.println("1. View All Stores");
            System.out.println("2. Create Store");
            System.out.println("3. Register Deposit");
            System.out.println("4. View All Deposits");
            System.out.println("5. Delete Store");
            System.out.println("6. Delete Deposit");
            System.out.println("7. Create Package");
            System.out.println("8. Remove Package");
            System.out.println("9. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    controller.viewAllStores();
                    break;
                case 2:
                    System.out.print("Enter Store Name: ");
                    String storeName = scanner.nextLine();
                    System.out.print("Enter Store Address: ");
                    String storeAddress = scanner.nextLine();
                    System.out.print("Enter Store Contact: ");
                    String storeContact = scanner.nextLine();
                    controller.createStore(storeName, storeAddress, storeContact);
                    break;
                case 3:
                    System.out.print("Enter Store ID: ");
                    int storeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Deposit Address: ");
                    String depositAddress = scanner.nextLine();
                    System.out.print("Enter Deposit Status: ");
                    String depositStatus = scanner.nextLine();
                    controller.registerDeposit(storeId, depositAddress, depositStatus);
                    break;
                case 4:
                    controller.viewAllDeposits();
                    break;
                case 5:
                    System.out.print("Enter Store ID: ");
                    int deleteStoreId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    controller.deleteStore(deleteStoreId);
                    break;
                case 6:
                    System.out.print("Enter Store ID: ");
                    int storeIdForDeposit = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Deposit ID: ");
                    int depositId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    controller.deleteDeposit(storeIdForDeposit, depositId);
                    break;
                case 7:
                    System.out.print("Enter Package Cost: ");
                    int cost = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Package Weight: ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Package Dimensions: ");
                    String dimensions = scanner.nextLine();
                    controller.createPackage(cost, weight, dimensions);
                    break;
                case 8:
                    System.out.print("Enter Package ID: ");
                    int packageId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    // Assuming there's a method to remove a package
                    //controller.removePackage(packageId);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    /**
     * Manages the customer menu interface.
     * Provides functionality for customer management and order processing.
     */
    private void customerMenu() {
        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1. View All Customers");
            System.out.println("2. Create Customer");
            System.out.println("3. Make an Order");
            System.out.println("4. Remove an Order");
            System.out.println("5. View Personal Orders");
            System.out.println("6. Calculate Order Cost");
            System.out.println("7. Schedule Delivery Date");
            System.out.println("8. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    controller.viewAllCustomers();
                    break;
                case 2:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    controller.createLoggedInCustomer(name, address, phone, email);
                    break;
                case 3:
                    try {
                        System.out.print("Enter customer ID: ");
                        Integer customerId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter order date (yyyy-mm-dd): ");
                        String orderDateString = scanner.nextLine();
                        Date orderDate = Date.valueOf(orderDateString);

                        System.out.print("Enter delivery date (yyyy-mm-dd): ");
                        String deliveryDateString = scanner.nextLine();
                        System.out.print("Enter delivery time (HH:mm): ");
                        String deliveryTimeString = scanner.nextLine();
                        LocalDateTime deliveryDateTime = LocalDateTime.parse(deliveryDateString + "T" + deliveryTimeString);

                        System.out.print("Enter cost: ");
                        double cost = Double.parseDouble(scanner.nextLine());

                        System.out.print("Enter status: ");
                        String status = scanner.nextLine();

                        controller.makeAnOrder(customerId, orderDate, deliveryDateTime, cost, status);
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Customer ID: ");
                    int removeCustomerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Order ID: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    controller.removeAnOrder(removeCustomerId, orderId);
                    break;
                case 5:
                    System.out.print("Enter Customer ID: ");
                    int personalCustomerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    List<Order> personalOrders = controller.getPersonalOrders(personalCustomerId);
                    controller.viewPersonalOrders(personalOrders);
                    break;
                case 6:
                    System.out.print("Enter Order ID: ");
                    int orderCostId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Order order = controller.getSelectedOrder(orderCostId);
                    if (order != null) {
                        List<Packages> packages = controller.getPackagesFromOrder(orderCostId);
                        double totalCost = controller.calculateOrderCost(packages);
                        System.out.println("Total Order Cost: " + totalCost);
                    } else {
                        System.out.println("Order not found.");
                    }
                    break;
                case 7:
                    try {
                        System.out.print("Enter order ID: ");
                        Integer orderIdForSchedule = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter delivery date (yyyy-mm-dd): ");
                        String deliveryDateStringForSchedule = scanner.nextLine();
                        System.out.print("Enter delivery time (HH:mm): ");
                        String deliveryTimeStringForSchedule = scanner.nextLine();
                        LocalDateTime deliveryDateTimeForSchedule = LocalDateTime.parse(deliveryDateStringForSchedule + "T" + deliveryTimeStringForSchedule);

                        controller.scheduleDeliveryDate(orderIdForSchedule, deliveryDateTimeForSchedule);
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again.");
                    }
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    /**
     * Manages the employee menu interface.
     * Provides functionality for employee management and delivery assignments.
     */
    private void employeeMenu() {
        while (true) {
            System.out.println("Employee Menu:");
            System.out.println("1. View All Employees");
            System.out.println("2. Create Employee");
            System.out.println("3. View My Deliveries");
            System.out.println("4. Drop Delivery");
            System.out.println("5. View Available Personal Vehicles");
            System.out.println("6. Assign Personal Vehicle");
            System.out.println("7. View All Departments");
            System.out.println("8. Pick Delivery");
            System.out.println("9. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    controller.viewAllEmployees();
                    break;
                case 2:
                    System.out.print("Enter Department ID: ");
                    int departmentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter License: ");
                    String license = scanner.nextLine();
                    controller.createEmployee(departmentId, name, phone, license);
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    List<Delivery> deliveries = controller.getDeliveriesForEmployee(employeeId);
                    System.out.println("Deliveries for Employee ID " + employeeId + ":");
                    deliveries.forEach(delivery -> System.out.println(delivery.toString()));
                    break;
                case 4:
                    System.out.print("Enter Employee ID: ");
                    int empId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Delivery ID: ");
                    int delId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (controller.validateSelectedDelivery(delId)) {
                        controller.dropDelivery(empId, delId);
                    } else {
                        System.out.println("Invalid Delivery ID.");
                    }
                    break;
                case 5:
                    List<Personal_Vehicle> availableVehicles = controller.getAllAvailablePersonalVehicles();
                    controller.viewAvailablePersonalVehicles(availableVehicles);
                    break;
                case 6:
                    System.out.print("Enter Delivery Person ID: ");
                    int deliveryPersonId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Personal Vehicle ID: ");
                    int personalVehicleId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    controller.assignPersonalVehicle(deliveryPersonId, personalVehicleId);
                    break;
                case 7:
                    controller.viewAllDepartments();
                    break;
                case 8:
                    System.out.print("Enter Employee ID: ");
                    int empIdForDelivery = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Delivery ID: ");
                    int deliveryIdForEmployee = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    controller.assignEmployeeToUnassignedDelivery(empIdForDelivery, deliveryIdForEmployee);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    /**
     * Manages the delivery person menu interface.
     * Provides functionality for delivery person management and delivery assignments.
     */
    private void deliveryPersonMenu() {
        while (true) {
            System.out.println("Delivery Person Menu:");
            System.out.println("1. View All Deliveries");
            System.out.println("2. Create Delivery Person");
            System.out.println("3. Pick Delivery by Person");
            System.out.println("4. Assign Personal Vehicle");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    controller.viewAllDeliveries();
                    break;
                case 2:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter License: ");
                    String license = scanner.nextLine();
                    controller.createDeliveryPerson(name, phone, license);
                    break;
                case 3:
                    System.out.print("Enter Delivery Person ID: ");
                    int deliveryPersonId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Delivery ID: ");
                    int deliveryId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (controller.validateSelectedDelivery(deliveryId)) {
                        controller.pickDeliveryByPerson(deliveryPersonId, deliveryId);
                    } else {
                        System.out.println("Invalid Delivery ID.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Delivery Person ID: ");
                    int dpId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Personal Vehicle ID: ");
                    int pvId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    controller.assignPersonalVehicle(dpId, pvId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    /**
     * Creates and initializes an in-memory repository for Customer entities.
     *
     * @return Initialized IRepository instance for Customer entities
     */
    private static IRepository<Customer> createInMemoryCustomerRepository() {
        IRepository<Customer> customerIRepository = new InMemoryRepo<>();
        customerIRepository.create(new Customer(1, "Dorel", "Cluj-Napoca", "0774596204", "dorel@gmail.com"));
        customerIRepository.create(new Customer(2, "Balintescu", "Mioveni", "0734682134", "balintescu@gmail.com"));
        customerIRepository.create(new Customer(3, "Andrei", "Zalau", "0797794239", "andrei@gmail.com"));
        return customerIRepository;
    }

    private static IRepository<Employee> createInMemoryEmployeeRepository() {
        IRepository<Employee> employeeIRepository = new InMemoryRepo<>();
        employeeIRepository.create(new Employee(1, 1, "Eminovici", "0742092989", "part time"));
        employeeIRepository.create(new Employee(2, 1, "Stefan", "071998491", "full time"));
        employeeIRepository.create(new Employee(3, 2, "David", "077636274", "full time"));
        return employeeIRepository;

    }

    private static IRepository<Delivery> createInMemoryDeliveryRepository() {
        IRepository<Delivery> deliveryIRepository = new InMemoryRepo<>();
        deliveryIRepository.create(new Delivery(1, 1, Timestamp.valueOf(LocalDateTime.of(2024, 6, 6, 10, 0))));
        deliveryIRepository.create(new Delivery(2, 2, Timestamp.valueOf(LocalDateTime.of(2024, 7, 8, 15, 30))));
        deliveryIRepository.create(new Delivery(3, 2, Timestamp.valueOf(LocalDateTime.of(2024, 7, 9, 15, 30))));
        return deliveryIRepository;
    }

    private static IRepository<Delivery_Person> createInMemoryDeliveryPersonRepository() {
        IRepository<Delivery_Person> deliveryPersonIRepository = new InMemoryRepo<>();
        deliveryPersonIRepository.create(new Delivery_Person(1, "0742092989", "Eminovici", "part time"));
        deliveryPersonIRepository.create(new Delivery_Person(2, "071998491", "Stefan", "full time"));
        deliveryPersonIRepository.create(new Delivery_Person(3, "077636274", "David", "full time"));
        return deliveryPersonIRepository;
    }

    private static IRepository<Department> createInMemoryDepartmentRepository() {
        IRepository<Department> departmentIRepository = new InMemoryRepo<>();
        departmentIRepository.create(new Department(1, "Business Intelligence", "Develop Business"));
        return departmentIRepository;
    }

    private static IRepository<Deposit> createInMemoryDepositRepository() {
        IRepository<Deposit> depositIRepository = new InMemoryRepo<>();
        depositIRepository.create(new Deposit(1, "Str. Ploiesti", "Full", 1));
        depositIRepository.create(new Deposit(2, "Str. Constanta", "Empty", 2));
        depositIRepository.create(new Deposit(3, "Str. Fabricii", "Not full", 3));
        return depositIRepository;

    }

    //LocalDateTime
    private static IRepository<Order> createInMemoryOrderRepository() {
        IRepository<Order> orderIRepository = new InMemoryRepo<>();
        orderIRepository.create(new Order(1, java.sql.Date.valueOf("2024-06-06"), LocalDateTime.of(2024, 6, 10, 12, 0), 150.75, "Processing"));
        orderIRepository.create(new Order(2, java.sql.Date.valueOf("2024-06-07"), LocalDateTime.of(2024, 6, 12, 14, 30), 200.50, "Shipped"));
        orderIRepository.create(new Order(3, Date.valueOf("2024-06-08"), LocalDateTime.of(2024, 6, 15, 9, 0), 100.25, "Delivered"));
        return orderIRepository;
    }

    private static IRepository<Packages> createInMemoryPackageRepository() {
        IRepository<Packages> packagesIRepository = new InMemoryRepo<>();
        packagesIRepository.create(new Packages(1, 100.5, "4x4x4", 100));
        packagesIRepository.create(new Packages(2, 20.8, "2x4x3", 50));
        packagesIRepository.create(new Packages(3, 10.2, "5x2x3", 120));
        return packagesIRepository;
    }

    private static IRepository<Personal_Vehicle> createInMemoryPersonalVehicleRepository() {
        IRepository<Personal_Vehicle> personalVehicleIRepository = new InMemoryRepo<>();
        personalVehicleIRepository.create(new Personal_Vehicle(1, 10, 20, Transportation_Type.Ground));
        personalVehicleIRepository.create(new Personal_Vehicle(2, 50, 1100, Transportation_Type.Aerial));
        personalVehicleIRepository.create(new Personal_Vehicle(3, 30, 9345, Transportation_Type.Naval));
        return personalVehicleIRepository;
    }

    private static IRepository<Store> createInMemoryStoreRepository() {
        IRepository<Store> storeIRepository = new InMemoryRepo<>();
        storeIRepository.create(new Store(1, "Auchan", "Str. Posada", "Alexandru"));
        storeIRepository.create(new Store(2, "Dedeman", "Str. Livezii", "Stefan"));
        storeIRepository.create(new Store(3, "Kaufland", "Calea Manastur", "Mihai"));
        return storeIRepository;
    }
    /**
     * Main entry point of the application.
     * Initializes all necessary repositories, creates service and controller instances,
     * and starts the application.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Assuming the repositories are implemented and passed to the Service constructor
        IRepository<Customer> customerIRepository = createInMemoryCustomerRepository();
        IRepository<Employee> employeeIRepository = createInMemoryEmployeeRepository();
        IRepository<Delivery> deliveryIRepository = createInMemoryDeliveryRepository();
        IRepository<Delivery_Person> deliveryPersonIRepository = createInMemoryDeliveryPersonRepository();
        IRepository<Deposit> depositIRepository = createInMemoryDepositRepository();
        IRepository<Personal_Vehicle> personalVehicleIRepository = createInMemoryPersonalVehicleRepository();
        IRepository<Department> departmentIRepository = createInMemoryDepartmentRepository();
        IRepository<Order> orderIRepository = createInMemoryOrderRepository();
        IRepository<Store> storeIRepository = createInMemoryStoreRepository();
        IRepository<Packages> packagesIRepository = createInMemoryPackageRepository();
        Service service = new Service(storeIRepository,packagesIRepository,orderIRepository,customerIRepository,departmentIRepository,employeeIRepository,deliveryIRepository,depositIRepository,deliveryPersonIRepository,personalVehicleIRepository);
        Controller controller = new Controller(service);
        new APP3(controller);
    }
}