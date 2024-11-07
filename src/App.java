import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        System.out.println("======Welcome to the Delivery-Service Application======");
        System.out.println("=======================================================");
        System.out.println("Please choose one of the following actions:");
        System.out.println("=======================================================");
        System.out.println("1. Log-in as customer");
        System.out.println("2. Log-in as employee");
        System.out.println("3. Log-in as seller");
        System.out.println("4. Log-in as delivery person");
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
                mainMenu();
        }
    }

    public static void customerMenu(){
        System.out.println("==================== Customer Menu =====================");
        System.out.println("Choose one of the following actions:");
        System.out.println("=======================================================");
        System.out.println("1. Place order");
        System.out.println("2. Schedule a delivery");
        System.out.println("3. Remove an order");
        System.out.println("4. See all your orders");

        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:

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

    public static void employeeMenu(){
        System.out.println("==================== Employee Menu =====================");
        System.out.println("Choose one of the following actions:");
        System.out.println("=======================================================");
        System.out.println("1. View all employees");
        System.out.println("2. View all departments");
        System.out.println("3. View all deliveries");
        System.out.println("4. Enroll as an employee");
        System.out.println("5. Process a delivery");

        int userChoice = scanner.nextInt();

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

    public static void sellerMenu(){
        System.out.println("==================== Seller Menu =====================");
        System.out.println("Choose one of the following actions:");
        System.out.println("=======================================================");
        System.out.println("1. Register shop");
        System.out.println("2. Remove shop");
        System.out.println("3. Register deposit");
        System.out.println("4. Remove deposit");
        System.out.println("5. View all Packages");
        System.out.println("6. View all Deposits");
        System.out.println("7. View all Stores");
        System.out.println("8. See all your customers");


        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            default:
                System.out.println("Invalid Choice!");
                sellerMenu();
        }
    }

    public static void deliveryPersonMenu(){
        System.out.println("==================== Delivery Person Menu =====================");
        System.out.println("Choose one of the following actions:");
        System.out.println("=======================================================");
        System.out.println("1. Enroll as driver");
        System.out.println("2. Process a delivery");
        System.out.println("3. Assign vehicle");
        System.out.println("4. Select preferred transportation type");

        int userChoice = scanner.nextInt();

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