package banking_system;
public class BankAccount {

    private String accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(String accountNumber, String accountName, double balance) {
        if (accountNumber == null || accountNumber.length() != 9) {
            throw new IllegalArgumentException("Account number must be exactly 9 digits.");
        }

        if (accountName == null || accountName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account name cannot be blank.");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        
        balance += amount;
        System.out.printf("Deposit successful. New Balance: %.2f%n", balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {

        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient funds. Available Balance: " + balance);
        }

        balance -= amount;
        System.out.printf("Withdrawal successful. New Balance: %.2f%n", balance);
    }

    public void displayAccount() {
        System.out.printf(
                "Account No: %s | Name: %s | Balance: %.2f%n",
                accountNumber, accountName, balance);
    }
}