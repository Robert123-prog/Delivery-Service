import model.*;
import repository.IRepository;
import repository.InMemoryRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {

    private final Controller controller;
    public App(Controller controller){
        this.controller = controller;
    }

    static Scanner integerScanner = new Scanner(System.in);
    static Scanner fieldScanner = new Scanner(System.in);

    public void main(String[] args) {
        /*
        sample data
         */
        runSample();
        mainMenu();
    }

    private static IRepository<Customer> createInMemoryCustomerRepository() {
        IRepository<Customer> customerIRepository = new InMemoryRepo<>();
        customerIRepository.create(new Customer(1, "Dorel" ,"Cluj-Napoca","0774596204","dorel@gmail.com"));
        customerIRepository.create(new Customer(2,"Balintescu","Mioveni","0734682134","balintescu@gmail.com"));
        customerIRepository.create(new Customer(3,"Andrei","Zalau","0797794239","andrei@gmail.com"));
        return customerIRepository;
    }
    private static IRepository<Employee> createInMemoryEmployeeRepository() {
        IRepository<Employee> employeeIRepository = new InMemoryRepo<>();
        employeeIRepository.create(new Employee(3,1,"Eminovici","0742092989","part time"));
        employeeIRepository.create(new Employee(3,1,"Stefan","071998491","full time"));
        employeeIRepository.create(new Employee(3,2,"David","077636274","full time"));
        return employeeIRepository;

    }


    private static IRepository<Delivery> createInMemoryDeliveryRepository() {
        IRepository<Delivery> deliveryIRepository = new InMemoryRepo<>();
        //deliveryIRepository.create(new Delivery(1, ));
        //deliveryIRepository.create(new Delivery());
        //deliveryIRepository.create(new Delivery());
        return deliveryIRepository;
    }



    private static IRepository<Delivery_Person> createInMemoryDeliveryPersonRepository() {
        IRepository<Delivery_Person> deliveryPersonIRepository = new InMemoryRepo<>();
        //deliveryPersonIRepository.create(new Delivery_Person(3,1,"Eminovici","0742092989","part time"));
        //deliveryPersonIRepository.create(new Delivery_Person(3,1,"Stefan","071998491","full time"));
        //deliveryPersonIRepository.create(new Delivery_Person(3,2,"David","077636274","full time"));
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


    //LocalDateTime ???
    private static IRepository<Order> createInMemoryOrderRepository() {
        IRepository<Order> orderIRepository = new InMemoryRepo<>();
        //orderIRepository.create(new Order(1, new Date(2020, 11, 10,)));
        //orderIRepository.create(new Order());
        //orderIRepository.create(new Order());
        return orderIRepository;
    }



    private static IRepository<Packages> createInMemoryPackageRepository() {
        IRepository<Packages> packagesIRepository = new InMemoryRepo<>();
        //packagesIRepository.create(new Packages(1, 100.5, "4x4x4"));
        //packagesIRepository.create(new Packages(2, 20.8, "2x4x3"));
        //packagesIRepository.create(new Packages(3, 10.2, "5x2x3"));
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

    private static void runSample() {
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
    }

    public void mainMenu(){
        System.out.println("======Welcome to the Delivery-Service Application======");
        System.out.println("=======================================================");
        System.out.println("Please choose one of the following actions:");
        System.out.println("=======================================================");
        System.out.println("1. Log-in as customer");
        System.out.println("2. Log-in as employee");
        System.out.println("3. Log-in as seller");
        System.out.println("4. Log-in as delivery person");
        System.out.println("=======================================================");

        int userChoice = integerScanner.nextInt();

        switch (userChoice){
            case 1:
                System.out.println("=======================================================");
                System.out.println("Please complete the following fields:");
                System.out.println("=======================================================");

                System.out.println("Name: ");
                String name = fieldScanner.nextLine();

                System.out.println("Address: ");
                String address = fieldScanner.nextLine();

                System.out.println("Phone: ");
                String phone = fieldScanner.nextLine();

                System.out.println("Email: ");
                String email = fieldScanner.nextLine();

                this.controller.createLoggedInCustomer(name, address, phone, email);
                customerMenu();
                break;
            case 2:
                System.out.println("=======================================================");
                System.out.println("Please complete the following fields:");
                System.out.println("=======================================================");
                System.out.println("=======================================================");
                System.out.println("Please enter the Id of the desired department: ");
                System.out.println("=======================================================");

                controller.viewAllDepartments();

                Integer departmentId = integerScanner.nextInt();
                boolean existsDepartment = controller.departmentSelection(departmentId);

                if (!existsDepartment) throw new IllegalArgumentException("No department found");

                System.out.println("Name: ");
                String employeeName = fieldScanner.nextLine();

                System.out.println("Phone: ");
                String employeePhone = fieldScanner.nextLine();

                System.out.println("License: ");
                String employeeLicense = fieldScanner.nextLine();

                controller.createEmployee(departmentId, employeeName, employeePhone, employeeLicense);
                break;
            case 3:
                sellerMenu();
                break;
            case 4:
                System.out.println("=======================================================");
                System.out.println("Please complete the following fields:");
                System.out.println("=======================================================");

                System.out.println("Name: ");
                String deliveryPersonName = fieldScanner.nextLine();

                System.out.println("Phone: ");
                String deliveryPersonPhone = fieldScanner.nextLine();

                System.out.println("License: ");
                String deliveryPersonLicense = fieldScanner.nextLine();

                controller.createDeliveryPerson(deliveryPersonName, deliveryPersonPhone, deliveryPersonLicense);
                break;
            default:
                System.out.println("Invalid Choice!!");
                mainMenu();
        }
    }

    public void customerMenu(){
        System.out.println("==================== Customer Menu =====================");
        System.out.println("Choose one of the following actions:");
        System.out.println("=======================================================");
        System.out.println("1. Place order");
        System.out.println("2. Reschedule an order delivery");
        System.out.println("3. Remove an order");
        System.out.println("4. See all your orders");

        int userChoice = integerScanner.nextInt();

        switch (userChoice){
            case 1:
                System.out.println("=======================================================");
                System.out.println("Please complete the following fields:");
                System.out.println("=======================================================");
                System.out.println("!Order date will be set automatically!");
                System.out.println("=======================================================");

                Integer customerId = controller.getLastLoggedInCustomerId();

                LocalDate currentDate = LocalDate.now();
                Date orderDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());


                System.out.println("Delivery Date and Time: ");
                System.out.println("=======================================================");
                System.out.println("Please enter the date and time in the following format: yyyy-MM-ddThh:mm,");
                System.out.println("Where:");
                System.out.println("y = year");
                System.out.println("M = month");
                System.out.println("d = day");
                System.out.println("h = hour");
                System.out.println("m = minutes");
                System.out.println("=======================================================");
                System.out.println("!!!IF YOU DONT WANT THE SPECIFIC MINUTES, ENTER: hh:00");
                System.out.println("=======================================================");
                System.out.println("DISCLAIMER: The order might not arrive in the exact specified minute");
                System.out.println("=======================================================");

                LocalDateTime dateTime = LocalDateTime.parse(fieldScanner.nextLine());

                System.out.println("In the following, please enter the Id's of desired packages");
                controller.getAllPackages();

                List<Integer> packageIds = new ArrayList<>();
                boolean allPackagesExist = controller.validatePackages(packageIds);

                if (!allPackagesExist) throw new IllegalArgumentException("One or more packages don't exist!");

                List<Packages> packages = controller.getValidatedPackages(packageIds);

                double orderCost = controller.calculateOrderCost(packages);

                System.out.println("Status: ");
                String orderStatus = fieldScanner.nextLine();

                controller.makeAnOrder(customerId, orderDate, dateTime, orderCost, orderStatus);
                break;
            case 2:
                System.out.println("=======================================================");
                System.out.println("Please enter the Id of the desired order to reschedule");
                System.out.println("=======================================================");


                Integer customerID = controller.getLastLoggedInCustomerId();

                List<Order> personalOrders = controller.getPersonalOrders(customerID);
                controller.viewPersonalOrders(personalOrders);

                Integer orderId = integerScanner.nextInt();
                boolean orderExists = controller.validateSelectedOrder(orderId);

                if (!orderExists) throw new IllegalArgumentException("One or more packages don't exist!");

                Order order = controller.getSelectedOrder(orderId);

                System.out.println("=======================================================");
                System.out.println("New delivery date and time: ");
                System.out.println("=======================================================");
                System.out.println("Please enter the date and time in the following format: yyyy-MM-ddThh:mm,");
                System.out.println("Where:");
                System.out.println("y = year");
                System.out.println("M = month");
                System.out.println("d = day");
                System.out.println("h = hour");
                System.out.println("m = minutes");
                System.out.println("=======================================================");
                System.out.println("!!!IF YOU DONT WANT THE SPECIFIC MINUTES, ENTER: hh:00");
                System.out.println("=======================================================");
                System.out.println("DISCLAIMER: The order might not arrive in the exact specified minute");
                System.out.println("=======================================================");

                LocalDateTime newOrderDateTime = LocalDateTime.parse(fieldScanner.nextLine());

                order.setDeliveryDateTime(newOrderDateTime);
                break;
            case 3:
                System.out.println("=======================================================");
                System.out.println("Please enter the Id of the desired order to remove");
                System.out.println("=======================================================");

                Integer customerID2 = controller.getLastLoggedInCustomerId();

                List<Order> personalOrders2 = controller.getPersonalOrders(customerID2);
                controller.viewPersonalOrders(personalOrders2);

                Integer orderToRemoveId = integerScanner.nextInt();
                boolean orderExists2 = controller.validateSelectedOrder(orderToRemoveId);

                if (!orderExists2) throw new IllegalArgumentException("One or more packages don't exist!");

                Order orderToRemove = controller.getSelectedOrder(orderToRemoveId);

                controller.removeSelectedOrder(customerID2, orderToRemoveId);
                break;
            case 4:
                Integer customerID3 = controller.getLastLoggedInCustomerId();

                List<Order> personalOrdersToView = controller.getPersonalOrders(customerID3);
                controller.viewPersonalOrders(personalOrdersToView);
                break;
            default:
                System.out.println("Invalid Choice!");
                customerMenu();
        }

    }

    public void employeeMenu(){
        System.out.println("==================== Employee Menu =====================");
        System.out.println("Choose one of the following actions:");
        System.out.println("=======================================================");
        System.out.println("1. View all employees");
        System.out.println("2. View all departments");
        System.out.println("3. View all deliveries");
        System.out.println("4. Enroll as an employee");
        System.out.println("5. Process a delivery");

        int userChoice = integerScanner.nextInt();

        switch (userChoice){
            case 1:
                controller.viewAllEmployees();
                break;
            case 2:
                controller.viewAllDepartments();
                break;
            case 3:

                break;
            default:
                System.out.println("Invalid Choice!");
                employeeMenu();
        }
    }

    public void sellerMenu(){
        System.out.println("==================== Seller Menu =====================");
        System.out.println("Choose one of the following actions:");
        System.out.println("=======================================================");
        System.out.println("1. Register shop");
        System.out.println("2. Remove shop");
        System.out.println("3. Register deposit");
        System.out.println("4. Remove deposit");
        System.out.println("5. View all your Packages");
        System.out.println("6. View all your Deposits");
        System.out.println("7. View all your Stores");
        System.out.println("8. See all your customers");


        int userChoice = integerScanner.nextInt();

        switch (userChoice){
            case 1:
                System.out.println("=======================================================");
                System.out.println("Please complete the following fields:");
                System.out.println("=======================================================");

                System.out.println("Name: ");
                String name = fieldScanner.nextLine();

                System.out.println("Address: ");
                String address = fieldScanner.nextLine();

                System.out.println("Contact: ");
                String contact = fieldScanner.nextLine();

                controller.createStore(name, address, contact);
                break;
            case 2:
                System.out.println("=======================================================");
                System.out.println("Please complete the following field:");
                System.out.println("=======================================================");

                System.out.println("Store ID: ");
                Integer Id = integerScanner.nextInt();
                controller.deleteStore(Id);

                break;
            case 3:
                System.out.println("=======================================================");
                System.out.println("Please enter the Id of the desired store: ");
                System.out.println("=======================================================");

                this.controller.viewAllStores();

                Integer ID = integerScanner.nextInt();
                boolean storeExists = controller.storeSelection(ID);

                if (!storeExists) throw new IllegalArgumentException("No store found");

                System.out.println("Address: ");
                String depositAddress = fieldScanner.nextLine();

                System.out.println("Status: ");
                String status = fieldScanner.nextLine();

                controller.registerDeposit(ID, depositAddress, status);
                break;
            case 4:
                System.out.println("=======================================================");
                System.out.println("Please enter the Id of the desired deposit to remove: ");
                System.out.println("=======================================================");

                controller.viewAllDeposits();

                Integer depositId = integerScanner.nextInt();
                boolean depositExists = controller.depositSelection(depositId);

                if (!depositExists){
                    throw new IllegalArgumentException("No deposit found");
                }else {
                    controller.deleteDeposit(depositId);
                }
                break;
            case 5:
                /*
                to be continued
                 */
                break;
            case 6:
                /*
                to be continued
                 */
                break;
            case 7:
                /*
                to be continued
                 */
                break;
            case 8:
                controller.viewAllCustomers();
                break;
            default:
                System.out.println("Invalid Choice!");
                sellerMenu();
        }
    }

    /*
    a delivery person cannot do anything, until it gets validated
     */
    public void deliveryPersonMenu(){
        System.out.println("==================== Delivery Person Menu =====================");
        System.out.println("Choose one of the following actions:");
        System.out.println("=======================================================");
        System.out.println("1. Process a delivery");
        System.out.println("2. Assign vehicle");
        System.out.println("3. Select preferred transportation type");
        System.out.println("4. Get verified");

        int userChoice = integerScanner.nextInt();

        switch (userChoice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            default:
                System.out.println("Invalid Choice!");
                deliveryPersonMenu();
        }
    }
}