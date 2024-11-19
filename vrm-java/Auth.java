package vrm.com;

import java.util.Scanner;

public class Auth {
    public static boolean login(Scanner scanner) {
        System.out.println("Are you an Admin? (yes/no): ");
        String role = scanner.nextLine();
        if (role.equalsIgnoreCase("yes")) {
            System.out.print("Enter Admin Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Admin Password: ");
            String password = scanner.nextLine();
            return username.equals("admin") && password.equals("admin123");
        } else {
            return false;
        }
    }
}
