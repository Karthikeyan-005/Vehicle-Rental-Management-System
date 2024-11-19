package vrm.com;

import java.sql.*;
import java.util.Scanner;

public class AdminOperations {
    public static void addVehicle(Scanner scanner) {
        System.out.print("Enter Vehicle Type (Car/Bike/Truck): ");
        String type = scanner.nextLine();
        System.out.print("Enter Vehicle Number: ");
        String number = scanner.nextLine();
        System.out.print("Enter Rental Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Total Count: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO vehicles (type, number, price_per_day, total_count) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, type);
            stmt.setString(2, number);
            stmt.setDouble(3, price);
            stmt.setInt(4, count);
            stmt.executeUpdate();
            System.out.println("Vehicle added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateVehicle(Scanner scanner) {
        System.out.print("Enter Vehicle ID to Update: ");
        int vehicleId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new Vehicle Type (Car/Bike/Truck): ");
        String type = scanner.nextLine();
        System.out.print("Enter new Vehicle Number: ");
        String number = scanner.nextLine();
        System.out.print("Enter new Rental Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter new Total Count: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE vehicles SET type = ?, number = ?, price_per_day = ?, total_count = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, type);
            stmt.setString(2, number);
            stmt.setDouble(3, price);
            stmt.setInt(4, count);
            stmt.setInt(5, vehicleId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Vehicle updated successfully!");
            } else {
                System.out.println("Vehicle not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void deleteVehicle(Scanner scanner) {
        System.out.print("Enter Vehicle ID to Delete: ");
        int vehicleId = scanner.nextInt();
        scanner.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM vehicles WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, vehicleId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Vehicle deleted successfully!");
            } else {
                System.out.println("Vehicle not found.");
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
