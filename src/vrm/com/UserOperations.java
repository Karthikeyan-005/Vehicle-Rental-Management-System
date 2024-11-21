package vrm.com;

import java.sql.*;
import java.util.Scanner;

public class UserOperations {
    public static void rentVehicle(Scanner scanner) {
        System.out.print("Enter Vehicle Type (Car/Bike/Truck): ");
        String type = scanner.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String displaySql = "SELECT * FROM vehicles WHERE type = ? AND total_count > 0";
            PreparedStatement displayStmt = conn.prepareStatement(displaySql);
            displayStmt.setString(1, type);
            ResultSet rs = displayStmt.executeQuery();

            boolean hasVehicles = false;
            System.out.println("Available Vehicles:");
            System.out.printf("%-5s %-10s %-10s %-10s %-10s%n", "ID", "Type", "Number", "Price/Day", "Count");
            while (rs.next()) {
                hasVehicles = true;
                System.out.printf(
                        "%-5d %-10s %-10s %-10.2f %-10d%n",
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("number"),
                        rs.getDouble("price_per_day"),
                        rs.getInt("total_count")
                );
            }

            if (!hasVehicles) {
                System.out.println("No vehicles available for the selected type.");
                return;
            }

            System.out.print("Enter the ID of the vehicle you want to rent: ");
            int vehicleId = scanner.nextInt();
            scanner.nextLine();


            String checkSql = "SELECT * FROM vehicles WHERE id = ? AND total_count > 0";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, vehicleId);
            ResultSet checkRs = checkStmt.executeQuery();

            if (checkRs.next()) {
                String number = checkRs.getString("number");
                double pricePerDay = checkRs.getDouble("price_per_day");

                System.out.print("Enter the number of days you want to rent: ");
                int days = scanner.nextInt();
                scanner.nextLine();

                double totalAmount = pricePerDay * days;
                System.out.printf("Total Rental Price: %.2f%n", totalAmount);

                System.out.print("Enter the payment amount: ");
                double payment = scanner.nextDouble();
                scanner.nextLine();

                if (payment >= totalAmount) {
                    System.out.println("Payment Successful!");
                    System.out.println("Vehicle rented: " + type + " (Number: " + number + ")");

                    String updateSql = "UPDATE vehicles SET total_count = total_count - 1 WHERE id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                    updateStmt.setInt(1, vehicleId);
                    updateStmt.executeUpdate();
                } else {
                    System.out.println("Payment failed. Incorrect amount entered.");
                }
            } else {
                System.out.println("Invalid ID or vehicle not available.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void returnVehicle(Scanner scanner) {
        System.out.print("Enter Vehicle ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE vehicles SET total_count = total_count + 1 WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Vehicle returned successfully!");
            } else {
                System.out.println("Invalid vehicle ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewVehicles() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM vehicles";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") + ", " +
                                "Type: " + rs.getString("type") +
                                ", Number: " + rs.getString("number") +
                                ", Price: " + rs.getDouble("price_per_day") +
                                ", Count: " + rs.getInt("total_count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
