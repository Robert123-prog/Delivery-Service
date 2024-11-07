import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        System.out.println("======Welcome to the Delivery-Service Application======");
        System.out.println("=======================================================");
        System.out.println("Please choose one of the following:");
        System.out.println("=======================================================");
        System.out.println("1. Handle Customers");
        System.out.println("2. Handle Deliveries");
        System.out.println("3. Handle Delivery People");
        System.out.println("4. Handle Departments");
        System.out.println("5. Handle Deposits");
        System.out.println("6. Handle Employees");
        System.out.println("7. Handle Orders");
        System.out.println("8. Handle Packages");
        System.out.println("9. Handle Stores");
        System.out.println("10. Handle Personal Vehicles");
        System.out.println("=======================================================");

        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:
                customerMenu();
                break;
            case 2:
                deliveryMenu();
                break;
            case 3:
                deliveryPeopleMenu();
                break;
            case 4:
                departmentsMenu();
                break;
            case 5:
                depositsMenu();
                break;
            case 6:
                employeesMenu();
                break;
            case 7:
                ordersMenu();
                break;
            case 8:
                packagesMenu();
                break;
            case 9:
                storesMenu();
                break;
            case 10:
                personalVehiclesMenu();
                break;
            default:
                System.out.println("Invalid Choice!!");
                mainMenu();
        }
    }

    public static void customerMenu(){
        System.out.println("======Customer Menu======");
        System.out.println("=======================================================");
        System.out.println("Choose one of the following:");
        System.out.println("1. View all customers");
        System.out.println("2. Create customer");
        System.out.println("3. Edit a customer");
        System.out.println("4. Delete a customer");
        System.out.println("=======================================================");

        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Invalid Choice!!");
                customerMenu();
        }
    }

    public static void deliveryMenu(){
        System.out.println("======Delivery Menu======");
        System.out.println("=======================================================");
        System.out.println("Choose one of the following:");
        System.out.println("1. View all Deliveries");
        System.out.println("2. Create delivery");
        System.out.println("3. Edit a delivery");
        System.out.println("4. Delete a delivery");
        System.out.println("5. Schedule a delivery");
        System.out.println("=======================================================");

        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                System.out.println("Invalid Choice!!");
                deliveryMenu();
        }
    }

    public static void deliveryPeopleMenu(){
        System.out.println("======Delivery People Menu======");
        System.out.println("=======================================================");
        System.out.println("Choose one of the following:");
        System.out.println("1. View all delivery people");
        System.out.println("2. Create a delivery person");
        System.out.println("3. Edit a delivery person");
        System.out.println("4. Delete a delivery person");
        System.out.println("=======================================================");

        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Invalid Choice!!");
                deliveryPeopleMenu();
        }
    }

    public static void departmentsMenu(){
        System.out.println("======Departments Menu======");
        System.out.println("=======================================================");
        System.out.println("Choose one of the following:");
        System.out.println("1. View all departments");
        System.out.println("2. Create a department");
        System.out.println("3. Edit a department");
        System.out.println("4. Delete a department");
        System.out.println("=======================================================");

        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Invalid Choice!!");
                departmentsMenu();
        }
    }

    public static void depositsMenu(){
        System.out.println("======Deposits Menu======");
        System.out.println("=======================================================");
        System.out.println("Choose one of the following:");
        System.out.println("1. View all deposits");
        System.out.println("2. Create a deposit");
        System.out.println("3. Edit a deposit");
        System.out.println("4. Delete a deposit");
        System.out.println("=======================================================");

        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Invalid Choice!!");
                depositsMenu();
        }
    }

    public static void employeesMenu(){
        System.out.println("======Employees Menu======");
        System.out.println("=======================================================");
        System.out.println("Choose one of the following:");
        System.out.println("1. View all employees");
        System.out.println("2. Create an employee");
        System.out.println("3. Edit an employee");
        System.out.println("4. Delete an employee");
        System.out.println("=======================================================");

        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Invalid Choice!!");
                employeesMenu();
        }
    }

    public static void ordersMenu(){
        System.out.println("======Orders Menu======");
        System.out.println("=======================================================");
        System.out.println("Choose one of the following:");
        System.out.println("1. View all orders");
        System.out.println("2. Create an order");
        System.out.println("3. Edit an order");
        System.out.println("4. Delete an order");
        System.out.println("=======================================================");

        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Invalid Choice!!");
                ordersMenu();
        }
    }

    public static void packagesMenu(){
        System.out.println("======Packages Menu======");
        System.out.println("=======================================================");
        System.out.println("Choose one of the following:");
        System.out.println("1. View all packages");
        System.out.println("2. Create a package");
        System.out.println("3. Edit a package");
        System.out.println("4. Delete a package");
        System.out.println("=======================================================");

        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Invalid Choice!!");
                packagesMenu();
        }
    }

    public static void personalVehiclesMenu(){
        System.out.println("======Personal Vehicles Menu======");
        System.out.println("=======================================================");
        System.out.println("Choose one of the following:");
        System.out.println("1. View all personal vehicles");
        System.out.println("2. Create a personal vehicle");
        System.out.println("3. Edit a personal vehicle");
        System.out.println("4. Delete a personal vehicle");
        System.out.println("=======================================================");

        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Invalid Choice!!");
                personalVehiclesMenu();
        }
    }

    public static void storesMenu(){
        System.out.println("======Stores Menu======");
        System.out.println("=======================================================");
        System.out.println("Choose one of the following:");
        System.out.println("1. View all stores");
        System.out.println("2. Create a store");
        System.out.println("3. Edit a store");
        System.out.println("4. Delete a store");
        System.out.println("=======================================================");

        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Invalid Choice!!");
                storesMenu();
        }
    }
}