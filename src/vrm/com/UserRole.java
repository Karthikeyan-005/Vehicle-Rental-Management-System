package vrm.com;

import java.util.Scanner;

public class UserRole extends Role {
    public void showMenu(Scanner scanner) {
        
            System.out.println("User Menu:");
            System.out.println("1. Rent Vehicle");
            System.out.println("2. Return Vehicle");
            System.out.println("3. View All Vehicles");
            System.out.println("4. Exit");

            while (true){
            System.out.print("Enter your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> UserOperations.rentVehicle(scanner);
                case 2 -> UserOperations.returnVehicle(scanner);
                case 3 -> UserOperations.viewVehicles();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

}
