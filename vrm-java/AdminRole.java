package vrm.com;

import java.util.Scanner;

public class AdminRole extends Role {
    @Override
    public void showMenu(Scanner scanner) {
        System.out.println("Admin Menu:");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Update Vehicle");
        System.out.println("3. Delete Vehicle");
        System.out.println("4. View All Vehicles");
        System.out.println("5. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> AdminOperations.addVehicle(scanner);
            case 2 -> AdminOperations.updateVehicle(scanner);
            case 3 -> AdminOperations.deleteVehicle(scanner);
            case 4 -> AdminOperations.viewVehicles();
            case 5 -> System.exit(0);
            default -> System.out.println("Invalid choice.");
        }
    }
}
