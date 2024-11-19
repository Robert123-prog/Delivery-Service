//
//import model.*;
//import repository.IRepository;
//import repository.InMemoryRepo;
//
//import java.sql.Date;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.time.LocalDateTime;
//
//public class APP2 {
//    private final Controller controller;
//    static Scanner scanner;
//
//    public APP2(Controller controller) {
//        this.controller = controller;
//        this.scanner = new Scanner(System.in);
//        createUI();
//    }
//
//    private static IRepository<Customer> createInMemoryCustomerRepository() {
//        IRepository<Customer> customerIRepository = new InMemoryRepo<>();
//        customerIRepository.create(new Customer(1, "Dorel", "Cluj-Napoca", "0774596204", "dorel@gmail.com"));
//        customerIRepository.create(new Customer(2, "Balintescu", "Mioveni", "0734682134", "balintescu@gmail.com"));
//        customerIRepository.create(new Customer(3, "Andrei", "Zalau", "0797794239", "andrei@gmail.com"));
//        return customerIRepository;
//    }
//
//    private static IRepository<Employee> createInMemoryEmployeeRepository() {
//        IRepository<Employee> employeeIRepository = new InMemoryRepo<>();
//        employeeIRepository.create(new Employee(1, 1, "Eminovici", "0742092989", "part time"));
//        employeeIRepository.create(new Employee(2, 1, "Stefan", "071998491", "full time"));
//        employeeIRepository.create(new Employee(3, 2, "David", "077636274", "full time"));
//        return employeeIRepository;
//
//    }
//
//    private static IRepository<Delivery> createInMemoryDeliveryRepository() {
//        IRepository<Delivery> deliveryIRepository = new InMemoryRepo<>();
//        deliveryIRepository.create(new Delivery(1));  //Timestamp.valueOf(LocalDateTime.of(2024, 6, 6, 10, 0))));
//        deliveryIRepository.create(new Delivery(2));  //Timestamp.valueOf(LocalDateTime.of(2024, 7, 8, 15, 30))));
//        deliveryIRepository.create(new Delivery(3)); //Timestamp.valueOf(LocalDateTime.of(2024, 7, 9, 15, 30))));
//        return deliveryIRepository;
//    }
//
//    private static IRepository<Delivery_Person> createInMemoryDeliveryPersonRepository() {
//        IRepository<Delivery_Person> deliveryPersonIRepository = new InMemoryRepo<>();
//        deliveryPersonIRepository.create(new Delivery_Person(1, "0742092989", "Eminovici"));
//        deliveryPersonIRepository.create(new Delivery_Person(2, "071998491", "Stefan"));
//        deliveryPersonIRepository.create(new Delivery_Person(3, "077636274", "David"));
//        return deliveryPersonIRepository;
//    }
//
//    private static IRepository<Department> createInMemoryDepartmentRepository() {
//        IRepository<Department> departmentIRepository = new InMemoryRepo<>();
//        departmentIRepository.create(new Department(1, "Business Intelligence", "Develop Business"));
//        departmentIRepository.create(new Department(2, "Data Science", "Develop AI"));
//        departmentIRepository.create(new Department(3, "Web Development", "Develop Web Applications"));
//        return departmentIRepository;
//    }
//
//    private static IRepository<Deposit> createInMemoryDepositRepository() {
//        IRepository<Deposit> depositIRepository = new InMemoryRepo<>();
//        depositIRepository.create(new Deposit(1, "Str. Ploiesti", "Full", 1));
//        depositIRepository.create(new Deposit(2, "Str. Constanta", "Empty", 2));
//        depositIRepository.create(new Deposit(3, "Str. Fabricii", "Not full", 3));
//        return depositIRepository;
//
//    }
//
//    //LocalDateTime
//    private static IRepository<Order> createInMemoryOrderRepository() {
//        IRepository<Order> orderIRepository = new InMemoryRepo<>();
//        orderIRepository.create(new Order(1, 1, java.sql.Date.valueOf("2024-06-06"), LocalDateTime.of(2024, 6, 10, 12, 0)));
//        orderIRepository.create(new Order(2,  2, java.sql.Date.valueOf("2024-06-07"), LocalDateTime.of(2024, 6, 12, 14, 30)));
//        orderIRepository.create(new Order(3, 3, Date.valueOf("2024-06-08"), LocalDateTime.of(2024, 6, 15, 9, 0)));
//        return orderIRepository;
//    }
//
//    private static IRepository<Packages> createInMemoryPackageRepository() {
//        IRepository<Packages> packagesIRepository = new InMemoryRepo<>();
//        packagesIRepository.create(new Packages(1, 100.5, "4x4x4", 100));
//        packagesIRepository.create(new Packages(2, 20.8, "2x4x3", 50));
//        packagesIRepository.create(new Packages(3, 10.2, "5x2x3", 120));
//        return packagesIRepository;
//    }
//
//    private static IRepository<Personal_Vehicle> createInMemoryPersonalVehicleRepository() {
//        IRepository<Personal_Vehicle> personalVehicleIRepository = new InMemoryRepo<>();
//        personalVehicleIRepository.create(new Personal_Vehicle(1, 10, 20, Transportation_Type.Ground));
//        personalVehicleIRepository.create(new Personal_Vehicle(2, 50, 1100, Transportation_Type.Aerial));
//        personalVehicleIRepository.create(new Personal_Vehicle(3, 30, 9345, Transportation_Type.Naval));
//        return personalVehicleIRepository;
//    }
//
//    private static IRepository<Store> createInMemoryStoreRepository() {
//        IRepository<Store> storeIRepository = new InMemoryRepo<>();
//        storeIRepository.create(new Store(1, "Auchan", "Str. Posada", "Alexandru"));
//        storeIRepository.create(new Store(2, "Dedeman", "Str. Livezii", "Stefan"));
//        storeIRepository.create(new Store(3, "Kaufland", "Calea Manastur", "Mihai"));
//        return storeIRepository;
//    }
//
//    public void createUI(){
//        while (true) {
//            printMainMenu();
//            int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice) {
//                case 1 -> createCustomer();
//                case 2 -> createStore();
//                case 3 -> deleteStore();
//                case 4 -> viewAllStores();
//                case 5 -> registerDeposit();
//                case 6 -> deleteDeposit();
//                case 7 -> viewAllDeposits();
//                case 8 -> createEmployee();
//                case 9 -> deleteEmployee();
//                case 10 -> createDeliveryPerson();
//                case 11 -> deleteDeliveryPerson();
//                case 12 -> makeAnOrder();
//                case 13 -> removeAnOrder();
//                case 14 -> viewAllCustomers();
//                case 15 -> viewAllDepartments();
//                case 16 -> viewAllEmployees();
//                case 17 -> viewAllDeliveryPersons();
//                case 18 -> viewAllDeliveries();
//                case 19 -> createPackage();
//                case 20 -> viewAllPackages();
//                case 21 -> assignPersonalVehicle();
//                case 22 -> viewAllTransportationTypes();
//                case 23 -> viewOrder();
//                case 24 -> exit();
//                default -> System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static void printMainMenu() {
//        System.out.println("\nMain Menu:");
//        System.out.println("1. Create Customer");
//        System.out.println("2. Create Store");
//        System.out.println("3. Delete Store");
//        System.out.println("4. View All Stores");
//        System.out.println("5. Register Deposit");
//        System.out.println("6. Delete Deposit");
//        System.out.println("7. View All Deposits");
//        System.out.println("8. Create Employee");
//        System.out.println("9. Delete Employee");
//        System.out.println("10. Create Delivery Person");
//        System.out.println("11. Delete Delivery Person");
//        System.out.println("12. Make an Order");
//        System.out.println("13. Remove an Order");
//        System.out.println("14. View All Customers");
//        System.out.println("15. View All Departments");
//        System.out.println("16. View All Employees");
//        System.out.println("17. View All Delivery Persons");
//        System.out.println("18. View All Deliveries");
//        System.out.println("19. Create Package");
//        System.out.println("20. View All Packages");
//        System.out.println("21. Assign Personal Vehicle");
//        System.out.println("22. View All Transportation Types");
//        System.out.println("23. View Order");
//        System.out.println("24. Exit");
//        System.out.print("Enter your choice: ");
//    }
//
//    private void createCustomer() {
//        System.out.print("Enter name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter address: ");
//        String address = scanner.nextLine();
//        System.out.print("Enter phone: ");
//        String phone = scanner.nextLine();
//        System.out.print("Enter email: ");
//        String email = scanner.nextLine();
//        controller.createLoggedInCustomer(name, address, phone, email);
//    }
//
//    private void createStore() {
//        System.out.print("Enter name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter address: ");
//        String address = scanner.nextLine();
//        System.out.print("Enter contact: ");
//        String contact = scanner.nextLine();
//        controller.createStore(name, address, contact);
//    }
//
//    private void deleteStore() {
//        System.out.print("Enter store ID: ");
//        Integer storeId = Integer.parseInt(scanner.nextLine());
//        controller.deleteStore(storeId);
//    }
//
//    private void viewAllStores() {
//        controller.viewAllStores();
//    }
//
//    private void registerDeposit() {
//        System.out.print("Enter store ID: ");
//        Integer storeId = Integer.parseInt(scanner.nextLine());
//        System.out.print("Enter deposit address: ");
//        String depositAddress = scanner.nextLine();
//        System.out.print("Enter deposit status: ");
//        String depositStatus = scanner.nextLine();
//        controller.registerDeposit(storeId, depositAddress, depositStatus);
//    }
//
//    private void deleteDeposit() {
//        System.out.print("Enter store ID: ");
//        Integer storeId = Integer.parseInt(scanner.nextLine());
//        System.out.print("Enter deposit ID: ");
//        Integer depositId = Integer.parseInt(scanner.nextLine());
//        controller.deleteDeposit(storeId, depositId);
//    }
//
//    private void viewAllDeposits() {
//        controller.viewAllDeposits();
//    }
//
//    private void createEmployee() {
//        System.out.print("Enter department ID: ");
//        Integer departmentId = Integer.parseInt(scanner.nextLine());
//        System.out.print("Enter name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter phone: ");
//        String phone = scanner.nextLine();
//        System.out.print("Enter license: ");
//        String license = scanner.nextLine();
//        controller.createEmployee(departmentId, name, phone, license);
//    }
//
//    private void deleteEmployee() {
//        System.out.print("Enter employee ID: ");
//        Integer employeeId = Integer.parseInt(scanner.nextLine());
//        controller.deleteEmployee(employeeId);
//    }
//
//    private void createDeliveryPerson() {
//        System.out.print("Enter name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter phone: ");
//        String phone = scanner.nextLine();
//        System.out.print("Enter license: ");
//        String license = scanner.nextLine();
//        controller.createDeliveryPerson(name, phone, license);
//    }
//
//    private void deleteDeliveryPerson() {
//        System.out.print("Enter delivery person ID: ");
//        Integer deliveryPersonId = Integer.parseInt(scanner.nextLine());
//        controller.deleteDeliveryPerson(deliveryPersonId);
//    }
//
//    private void makeAnOrder() {
//        try {
//            System.out.print("Enter customer ID: ");
//            Integer customerId = Integer.parseInt(scanner.nextLine());
//
//            System.out.print("Enter order date (yyyy-mm-dd): ");
//            String orderDateString = scanner.nextLine();
//            Date orderDate = Date.valueOf(orderDateString);
//
//            System.out.print("Enter delivery date (yyyy-mm-dd): ");
//            String deliveryDateString = scanner.nextLine();
//            System.out.print("Enter delivery time (HH:mm): ");
//            String deliveryTimeString = scanner.nextLine();
//            LocalDateTime deliveryDateTime = LocalDateTime.parse(deliveryDateString + "T" + deliveryTimeString);
//
//            System.out.println("Here are all the packages that you can add on your order: ");
//            controller.viewAllPackages();
//            System.out.println("Enter how many packages you would like to add: ");
//            int numberOfPackages = scanner.nextInt();
//            List<Integer> packageIds = new ArrayList<>();
//
//            while (numberOfPackages > 0){
//                controller.viewAllPackages();
//                System.out.println("Package ID: ");
//                Integer packageId = scanner.nextInt();
//                packageIds.add(packageId);
//                numberOfPackages--;
//            }
//
//            boolean packagesExist = controller.validatePackages(packageIds);
//
//            if (!packagesExist) throw new RuntimeException("One or more packages dont exist");
//
//            controller.makeAnOrder(customerId, orderDate, deliveryDateTime, packageIds);
//            createUI();
//
//        } catch (Exception e) {
//            System.out.println("Invalid input. Please try again.");
//        }
//    }
//
//    private void removeAnOrder() {
//        System.out.print("Enter customer ID: ");
//        Integer customerId = Integer.parseInt(scanner.nextLine());
//        System.out.print("Enter order ID: ");
//        Integer orderId = Integer.parseInt(scanner.nextLine());
//        controller.removeAnOrder(customerId, orderId);
//    }
//
//    private void viewAllCustomers() {
//        controller.viewAllCustomers();
//    }
//
//    private void viewAllDepartments() {
//        controller.viewAllDepartments();
//    }
//
//    private void viewAllEmployees() {
//        controller.viewAllEmployees();
//    }
//
//    private void viewAllDeliveryPersons() {
//        controller.viewAllDeliveryPersons();
//    }
//
//    private void viewAllDeliveries() {
//        controller.viewAllDeliveries();
//        createUI();
//    }
//
//    private void createPackage() {
//        System.out.print("Enter cost: ");
//        int cost = Integer.parseInt(scanner.nextLine());
//        System.out.print("Enter weight: ");
//        double weight = Double.parseDouble(scanner.nextLine());
//        System.out.print("Enter dimensions: ");
//        String dimensions = scanner.nextLine();
//        controller.createPackage(cost, weight, dimensions);
//    }
//
//    private void viewAllPackages() {
//        controller.getAllPackages();
//    }
//
//    private void assignPersonalVehicle() {
//        System.out.print("Enter delivery person ID: ");
//        Integer deliveryPersonId = Integer.parseInt(scanner.nextLine());
//        System.out.print("Enter personal vehicle ID: ");
//        Integer personalVehicleId = Integer.parseInt(scanner.nextLine());
//        controller.assignPersonalVehicle(deliveryPersonId, personalVehicleId);
//    }
//
//    private void viewAllTransportationTypes() {
//        List<String> transportationTypes = controller.getAllTransportationTypes();
//        controller.viewAllTransportationTypes(transportationTypes);
//    }
//
//    private void viewOrder() {
//        System.out.print("Enter order ID: ");
//        Integer orderId = Integer.parseInt(scanner.nextLine());
//        controller.viewOrder(orderId);
//    }
//
//    private static void exit() {
//        System.out.println("Exiting...");
//        System.exit(0);
//    }
//
//
//
//    public static void main(String[] args) {
//        IRepository<Customer> customerIRepository = createInMemoryCustomerRepository();
//        IRepository<Employee> employeeIRepository = createInMemoryEmployeeRepository();
//        IRepository<Delivery> deliveryIRepository = createInMemoryDeliveryRepository();
//        IRepository<Delivery_Person> deliveryPersonIRepository = createInMemoryDeliveryPersonRepository();
//        IRepository<Deposit> depositIRepository = createInMemoryDepositRepository();
//        IRepository<Personal_Vehicle> personalVehicleIRepository = createInMemoryPersonalVehicleRepository();
//        IRepository<Department> departmentIRepository = createInMemoryDepartmentRepository();
//        IRepository<Order> orderIRepository = createInMemoryOrderRepository();
//        IRepository<Store> storeIRepository = createInMemoryStoreRepository();
//        IRepository<Packages> packagesIRepository = createInMemoryPackageRepository();
//        Service service = new Service(storeIRepository,packagesIRepository,orderIRepository,customerIRepository,departmentIRepository,employeeIRepository,deliveryIRepository,depositIRepository,deliveryPersonIRepository,personalVehicleIRepository);
//        Controller controller = new Controller(service);
//        new APP2(controller);
//    }
//}
