 // SystemNetworkAnalyzer.java
import java.util.Scanner;

public class SystemNetworkAnalyzer {
    public static void main(String[] args) {
        // Instantiate classes from other files and interact with them here
        NetworkOperations networkOperations = new NetworkOperations();
        NetworkInterfaceDetails networkInterfaceDetails = new NetworkInterfaceDetails();
        RoutingTable routingTable = new RoutingTable();
        // 

        // Display user menu and perform actions based on user input
        displayMenu(networkOperations, networkInterfaceDetails, routingTable);
    }

    public static void displayMenu(NetworkOperations networkOperations,
                                   NetworkInterfaceDetails networkInterfaceDetails,
                                   RoutingTable routingTable) {
        Scanner scanner = new Scanner(System.in);
        PortScanner portScanner = new PortScanner();
        int choice;

        do {
            System.out.println("User Menu for System Network Analyzer:");
            System.out.println("1. Perform a network ping");
            System.out.println("2. Show NIC (Network Interface Card) details");
            System.out.println("3. Perform a port scan on your local computer and show ports");
            System.out.println("4. Show the routing table");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    networkOperations.performAction();
                    break;
                case 2:
                    networkInterfaceDetails.displayDetails();
                    break;
                case 3:
                	 portScanner.performPortScan("127.0.0.1", 1, 1024); 
                    break;

                case 4:
                    routingTable.displayRoutingTable();
                    break;
                case 0:
                    System.out.println("Exiting System Network Analyzer. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}
