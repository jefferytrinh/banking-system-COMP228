package banking_system;

import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[3];

        System.out.println("=== BANK ACCOUNT CREATION ===");

        for (int i = 0; i < accounts.length; i++) {

            while (true) {

                try {
                    System.out.println("\nEnter information for Account " + (i + 1));

                    System.out.print("Account Number (9 digits): ");
                    String accNo = input.nextLine();

                    System.out.print("Account Name: ");
                    String name = input.nextLine();

                    System.out.print("Initial Balance: ");
                    double balance = Double.parseDouble(input.nextLine());

                    accounts[i] = new BankAccount(accNo, name, balance);

                    System.out.println("Account created successfully!");
                    break;

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number entered.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        System.out.println("\n=== TRANSACTION PROCESSING ===");

        for (int i = 0; i < accounts.length; i++) {

            System.out.println("\nAccount " + (i + 1));
            accounts[i].displayAccount();

            try {

                System.out.print("Enter deposit amount: ");
                double depositAmount = Double.parseDouble(input.nextLine());
                accounts[i].deposit(depositAmount);

                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = Double.parseDouble(input.nextLine());
                accounts[i].withdraw(withdrawalAmount);

            } catch (NumberFormatException e) {
                System.out.println("Invalid numeric input.");
            } catch (IllegalArgumentException e) {
                System.out.println("Transaction Error: " + e.getMessage());
            } catch (InsufficientFundsException e) {
                System.out.println("Banking Error: " + e.getMessage());
            } finally {
                System.out.println("Transaction processed.");
            }
        }

        System.out.println("\n=== FINAL ACCOUNT DETAILS ===");

        for (BankAccount account : accounts) {
            account.displayAccount();
        }

        input.close();
    }
}