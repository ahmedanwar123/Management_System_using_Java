package Console;

import java.util.Scanner;

public class TestProgram {
    public static void main(String[] args) {
        // Test the Management System
        ManagementSystem system = new ManagementSystem();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nManagement System Test Menu");
            System.out.println("1. Add User");
            System.out.println("2. Display Data");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addUser(system, scanner);
                    break;
                case 2:
                    system.displayData();
                    break;
                case 3:
                    updateUser(system, scanner);
                    break;
                case 4:
                    deleteUser(system, scanner);
                    break;
                case 5:
                    System.out.println("Exiting the test program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addUser(ManagementSystem system, Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        System.out.print("Enter user role: ");
        String role = scanner.nextLine();

        system.addUser(name, role);
    }

    private static void updateUser(ManagementSystem system, Scanner scanner) {
        System.out.print("Enter user name to update: ");
        String nameToUpdate = scanner.nextLine();

        boolean userExists = system.isUserExists(nameToUpdate);

        if (userExists) {
            System.out.print("Enter new role: ");
            String newRole = scanner.nextLine();
            system.updateUser(nameToUpdate, newRole);
            System.out.println("User data updated successfully!");
        } else {
            System.out.println("User not found. Update failed.");
        }
    }

    private static void deleteUser(ManagementSystem system, Scanner scanner) {
        System.out.print("Enter user name to delete: ");
        String nameToDelete = scanner.nextLine();

        boolean userExists = system.isUserExists(nameToDelete);

        if (userExists) {
            system.deleteUser(nameToDelete);
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found. Deletion failed.");
        }
    }
}
