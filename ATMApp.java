import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String pin;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with balance: " + initialBalance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposited: " + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrew: " + amount);
            return true;
        }
        return false;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    private void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
}

class ATM {
    private List<Account> accounts;
    private Account currentAccount;

    public ATM() {
        accounts = new ArrayList<>();
        // Adding a sample account for testing
        accounts.add(new Account("123456789", "1234", 1000.00));
    }

    public boolean authenticate(String accountNumber, String pin) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.validatePin(pin)) {
                currentAccount = account;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        currentAccount = null;
    }

    public double checkBalance() {
        if (currentAccount != null) {
            return currentAccount.getBalance();
        }
        return -1;
    }

    public boolean deposit(double amount) {
        if (currentAccount != null) {
            currentAccount.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (currentAccount != null) {
            return currentAccount.withdraw(amount);
        }
        return false;
    }

    public List<String> getTransactionHistory() {
        if (currentAccount != null) {
            return currentAccount.getTransactionHistory();
        }
        return null;
    }
}

public class ATMApp {
    private static ATM atm = new ATM();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the ATM!");
            System.out.print("Enter your account number: ");
            String accountNumber = scanner.nextLine();
            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();

            if (atm.authenticate(accountNumber, pin)) {
                boolean loggedIn = true;

                while (loggedIn) {
                    System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Transaction History\n5. Logout\n");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Current balance: " + atm.checkBalance());
                            break;
                        case 2:
                            System.out.print("Enter deposit amount: ");
                            double depositAmount = scanner.nextDouble();
                            if (atm.deposit(depositAmount)) {
                                System.out.println("Deposit successful.");
                            } else {
                                System.out.println("Deposit failed.");
                            }
                            break;
                        case 3:
                            System.out.print("Enter withdrawal amount: ");
                            double withdrawAmount = scanner.nextDouble();
                            if (atm.withdraw(withdrawAmount)) {
                                System.out.println("Withdrawal successful.");
                            } else {
                                System.out.println("Insufficient balance.");
                            }
                            break;
                        case 4:
                            System.out.println("Transaction History:");
                            for (String transaction : atm.getTransactionHistory()) {
                                System.out.println(transaction);
                            }
                            break;
                        case 5:
                            atm.logout();
                            loggedIn = false;
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                }
            } else {
                System.out.println("Invalid account number or PIN.");
            }

            System.out.print("Do you want to exit? (yes/no): ");
            String exitChoice = scanner.next();
            if (exitChoice.equalsIgnoreCase("yes")) {
                exit = true;
            }
            scanner.nextLine(); // consume the leftover newline
        }

        scanner.close();
        System.out.println("Thank you for using the ATM. Goodbye!");
    }
}
