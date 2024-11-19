package vrm.com;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Vehicle Rental System!");

        boolean isAdmin = Auth.login(scanner);

        Role role;

        if (isAdmin) {
            role = new AdminRole();
        } else {
            role = new UserRole();
        }

        role.showMenu(scanner);
    }
}
