package Console;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagementSystem extends Tasks{
    private ArrayList<User> users = new ArrayList<User>();

    private Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        ManagementSystem system = new ManagementSystem();
        system.run();
    }

    private void run() {
        int choice;
        do {
            System.out.println("\nManagement System Menu");
            System.out.println("1. Add User");
            System.out.println("2. Display Data");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addUser("", "");
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    @Override
    public void addUser(String name, String role) {
        User user = new User(name, role);
        users.add(user);
        System.out.println("User added successfully!");
    }

    @Override
    public void displayData() {
        System.out.println("User Data:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Override
    public void updateUser() {
        System.out.print("Enter user name to update: ");
        String nameToUpdate = scanner.nextLine();

        boolean userExists = isUserExists(nameToUpdate);

        if (userExists) {
            System.out.print("Enter new role: ");
            String newRole = scanner.nextLine();
            updateUser(nameToUpdate, newRole);
            System.out.println("User data updated successfully!");
        } else {
            System.out.println("User not found. Update failed.");
        }
    }

    @Override
    public void deleteUser() {
        System.out.print("Enter user name to delete: ");
        String nameToDelete = scanner.nextLine();

        boolean userExists = isUserExists(nameToDelete);

        if (userExists) {
            deleteUser(nameToDelete);
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found. Deletion failed.");
        }
    }

    public boolean isUserExists(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void updateUser(String name, String newRole) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                user.setRole(newRole);
                return;
            }
        }
    }

    public void deleteUser(String name) {
        users.removeIf(user -> user.getName().equals(name));
    }}
