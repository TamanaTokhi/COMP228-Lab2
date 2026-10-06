package lab2;

public class BankAccount {
	
	

	    private String accountNumber;
	    private String name;
	    private double balance;

	    // Constructor
	    public BankAccount(String accountNumber, String name, double balance) {

	        // Validate account number
	        if (accountNumber == null || !accountNumber.matches("\\d{9}")) {
	            throw new IllegalArgumentException(
	                    "Account number must contain exactly 9 digits."
	            );
	        }

	        // Validate name
	        if (name == null || name.trim().isEmpty()) {
	            throw new IllegalArgumentException(
	                    "Name cannot be blank."
	            );
	        }

	        // Validate balance
	        if (balance < 0) {
	            throw new IllegalArgumentException(
	                    "Balance cannot be negative."
	            );
	        }

	        this.accountNumber = accountNumber;
	        this.name = name;
	        this.balance = round(balance);
	    }

	    // Deposit method
	    public void deposit(double amount) {

	        if (amount <= 0) {
	            throw new IllegalArgumentException(
	                    "Deposit amount must be greater than zero."
	            );
	        }

	        balance += amount;
	        balance = round(balance);
	    }

	    // Withdraw method
	    public void withdraw(double amount)
	            throws InsufficientFundsException {

	        if (amount <= 0) {
	            throw new IllegalArgumentException(
	                    "Withdrawal amount must be greater than zero."
	            );
	        }

	        if (amount > balance) {
	            throw new InsufficientFundsException(
	                    "Insufficient funds. Available balance: $"
	                    + String.format("%.2f", balance)
	            );
	        }

	        balance -= amount;
	        balance = round(balance);
	    }

	    // Getters
	    public String getAccountNumber() {
	        return accountNumber;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    // Round to 2 decimal places
	    private double round(double value) {
	        return Math.round(value * 100.0) / 100.0;
	    }

	    // Display account information
	    public void displayAccount() {

	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Name: " + name);
	        System.out.printf("Balance: $%.2f%n", balance);
	    }
	}


