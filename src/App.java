import java.util.Scanner;

public class App {

    private final Controller controller;
    public App(Controller controller){
        this.controller = controller;
    }

    private


    static Scanner integerScanner = new Scanner(System.in);
    static Scanner fieldScanner = new Scanner(System.in);

    public void main(String[] args) {

        mainMenu();
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
                System.out.println("Please enter the Id of the desired store: ");
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
        System.out.println("2. Schedule a delivery");
        System.out.println("3. Remove an order");
        System.out.println("4. See all your orders");

        int userChoice = integerScanner.nextInt();

        switch (userChoice){
            case 1:
                System.out.println("Please complete the following fields:");


                break;
            case 2:

                break;
            case 3:

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

                break;
            case 2:

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



                break;
            case 2:
                System.out.println("=======================================================");
                System.out.println("Please complete the following field:");
                System.out.println("=======================================================");

                System.out.println("Store ID: ");
                Integer Id = integerScanner.nextInt();

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

                controller.createStore(String.valueOf(ID), depositAddress, status);
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
                    controller.removeDeposit(depositId);
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
        System.out.println("1. Enroll as driver");//se face automat in mainMenu()
        System.out.println("2. Process a delivery");
        System.out.println("3. Assign vehicle");
        System.out.println("4. Select preferred transportation type");
        System.out.println("5. Get verified");

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