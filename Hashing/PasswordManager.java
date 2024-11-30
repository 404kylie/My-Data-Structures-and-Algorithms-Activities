import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PasswordManager {
    public static void main(String[] args) {
        HashMap<String, String> userDatabase = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add User");
            System.out.println("2. Authenticate User");
            System.out.println("3. Exit");

            int choice = 0;
            boolean validInput = false;

            // Loop until valid input is received
            while (!validInput) {
                try {
                    System.out.print("Enter your choice (1-3): ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (choice < 1 || choice > 3) {
                        throw new InputMismatchException(); // Throw exception for invalid choice
                    }
                    validInput = true; // Valid input received
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                    scanner.nextLine(); // Clear the invalid input
                }
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    String hashedPassword = Integer.toString(password.hashCode());
                    userDatabase.put(username, hashedPassword);
                    System.out.println("User  added successfully!");
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String checkUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String checkPassword = scanner.nextLine();
                    String checkHash = Integer.toString(checkPassword.hashCode());

                    if (checkHash.equals(userDatabase.get(checkUsername))) {
                        System.out.println("Authentication successful!");
                    } else {
                        System.out.println("Authentication failed!");
                    }
                    break;
                case 3:
                    System.out.println("Exiting application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}