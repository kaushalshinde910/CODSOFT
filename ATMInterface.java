import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    private String username;
    private String password;
    private double balance;

    // Constructor
    public BankAccount(String username, String password, double initialBalance) {
        this.username = username;
        this.password = password;
        this.balance = initialBalance;
    }

    // Accessor methods
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Balance methods
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew ₹" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
}

class ATM {
    private Map<String, BankAccount> accounts;

    // Constructor
    public ATM() {
        accounts = new HashMap<>();
        // Adding some users to the ATM
        accounts.put("kaushal shinde", new BankAccount("kaushal shinde", "admin@123", 5000.0));
        accounts.put("john doe", new BankAccount("john doe", "password123", 3000.0));
        accounts.put("jane smith", new BankAccount("jane smith", "mypassword", 10000.0));
    }

    // Method for user authentication
    private BankAccount authenticateUser(String username, String password) {
        BankAccount account = accounts.get(username.toLowerCase());
        if (account != null && account.getPassword().equals(password)) {
            System.out.println("Authentication successful! Welcome " + username + "!");
            return account;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }

    // Main ATM interface
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        BankAccount account = authenticateUser(username, password);
        if (account == null) return;

        // Menu options
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current balance: ₹" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
