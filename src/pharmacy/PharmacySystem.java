package pharmacy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PharmacySystem {

    static Connection con = DBConnection.getConnection();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        if (con == null) {
            System.out.println("Database connection failed. Program stopped.");
            return;
        }

        int choice;

        do {
            System.out.println("\nPHARMACY MANAGEMENT SYSTEM");
            System.out.println("1 Add Medicine");
            System.out.println("2 View Medicines");
            System.out.println("3 Update Medicine");
            System.out.println("4 Delete Medicine");
            System.out.println("5 Sell Medicine");
            System.out.println("6 Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    viewMedicines();
                    break;
                case 3:
                    updateMedicine();
                    break;
                case 4:
                    deleteMedicine();
                    break;
                case 5:
                    sellMedicine();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 6);
    }

    public static void addMedicine() {
        try {
            sc.nextLine();

            System.out.print("Enter medicine name: ");
            String medicineName = sc.nextLine();

            System.out.print("Enter company name: ");
            String company = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            System.out.print("Enter stock: ");
            int stock = sc.nextInt();

            String query = "INSERT INTO medicine (medicine_name, company, price, stock) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, medicineName);
            pst.setString(2, company);
            pst.setDouble(3, price);
            pst.setInt(4, stock);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Medicine added successfully.");
            } else {
                System.out.println("Medicine not added.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void viewMedicines() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM medicine");

            System.out.println("\nMedicine List:");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("medicine_id") + " | " +
                    rs.getString("medicine_name") + " | " +
                    rs.getString("company") + " | " +
                    rs.getDouble("price") + " | " +
                    rs.getInt("stock")
                );
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void updateMedicine() {
        try {
            System.out.print("Enter medicine ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new medicine name: ");
            String medicineName = sc.nextLine();

            System.out.print("Enter new company name: ");
            String company = sc.nextLine();

            System.out.print("Enter new price: ");
            double price = sc.nextDouble();

            System.out.print("Enter new stock: ");
            int stock = sc.nextInt();

            String query = "UPDATE medicine SET medicine_name=?, company=?, price=?, stock=? WHERE medicine_id=?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, medicineName);
            pst.setString(2, company);
            pst.setDouble(3, price);
            pst.setInt(4, stock);
            pst.setInt(5, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Medicine updated successfully.");
            } else {
                System.out.println("Medicine ID not found.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deleteMedicine() {
        try {
            System.out.print("Enter medicine ID to delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM medicine WHERE medicine_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Medicine deleted successfully.");
            } else {
                System.out.println("Medicine ID not found.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void sellMedicine() {
        try {
            System.out.print("Enter medicine ID to sell: ");
            int id = sc.nextInt();

            System.out.print("Enter quantity to sell: ");
            int qty = sc.nextInt();

            String checkQuery = "SELECT stock, price, medicine_name FROM medicine WHERE medicine_id=?";
            PreparedStatement checkStmt = con.prepareStatement(checkQuery);
            checkStmt.setInt(1, id);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                int stock = rs.getInt("stock");
                double price = rs.getDouble("price");
                String name = rs.getString("medicine_name");

                if (stock >= qty) {
                    int newStock = stock - qty;
                    double total = price * qty;

                    String updateQuery = "UPDATE medicine SET stock=? WHERE medicine_id=?";
                    PreparedStatement updateStmt = con.prepareStatement(updateQuery);
                    updateStmt.setInt(1, newStock);
                    updateStmt.setInt(2, id);
                    updateStmt.executeUpdate();

                    System.out.println("Medicine sold successfully.");
                    System.out.println("Medicine Name: " + name);
                    System.out.println("Quantity Sold: " + qty);
                    System.out.println("Total Price: " + total);
                    System.out.println("Remaining Stock: " + newStock);
                } else {
                    System.out.println("Not enough stock available.");
                }
            } else {
                System.out.println("Medicine ID not found.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}