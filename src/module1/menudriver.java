package module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

class CustomerOperations {
    private Connection con;
    private Scanner sc;

    public CustomerOperations() {
        sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/symbiosys", "root", "8i9njd9fvr");
            System.out.println("Connection successful...");
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public void insertCustomer() {
        try {
            System.out.println("\nEnter Customer ID:");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.println("Enter Name:");
            String name = sc.nextLine();
            System.out.println("Enter Email:");
            String email = sc.nextLine();
            System.out.println("Enter Phone Number:");
            long phone = sc.nextLong();
            sc.nextLine(); // consume newline
            System.out.println("Enter PAN Number:");
            String pan = sc.nextLine();

            String query = "INSERT INTO customer VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, email);
            pst.setLong(4, phone);
            pst.setString(5, pan);

            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                System.out.println("Failed to insert record.");
            }
            pst.close();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    public void updateCustomer() {
        try {
            System.out.println("\nEnter Customer ID to update:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter new email:");
            String email = sc.nextLine();
            System.out.println("Enter new phone number:");
            long phone = sc.nextLong();
            sc.nextLine();
            System.out.println("Enter new PAN Number:");
            String pan = sc.nextLine();

            String query = "UPDATE customer SET email = ?, phoneno = ?, pan = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setLong(2, phone);
            pst.setString(3, pan);
            pst.setInt(4, id);

            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("Customer not found.");
            }
            pst.close();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    public void deleteCustomer() {
        try {
            System.out.println("\nEnter Customer ID to delete:");
            int id = sc.nextInt();
            sc.nextLine();

            String query = "DELETE FROM customer WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);

            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("Customer not found.");
            }
            pst.close();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    public void close() {
        try {
            con.close();
            sc.close();
            System.out.println("Exiting.");
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}

public class menudriver {
    public static void main(String[] args) {
        CustomerOperations co = new CustomerOperations();
        Scanner sc = new Scanner(System.in);

        System.out.println("\nChoose an operation:");
        System.out.println("1. Insert");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                co.insertCustomer();
                break;
            case 2:
                co.updateCustomer();
                break;
            case 3:
                co.deleteCustomer();
                break;
            default:
                System.out.println("Invalid choice.");
        }

        co.close();
        sc.close();
    }
}
