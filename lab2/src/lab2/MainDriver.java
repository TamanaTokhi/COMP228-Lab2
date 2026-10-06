package lab2;
 /*
  * written by TamanaTokhi *
  * */
import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        
        System.out.println("       SIMPLE BANKING SYSTEM");
        System.out.println("                                     ");

        BankAccount[] accounts = new BankAccount[3];

        
        for (int i = 0; i < accounts.length; i++) {

            System.out.println("\nEnter information for Account " + (i + 1));

            boolean accountCreated = false;

            while (!accountCreated) {

                try {

                    System.out.print("Enter 9-digit account number: ");
                    String accountNumber = input.nextLine();

                    System.out.print("Enter account holder name: ");
                    String name = input.nextLine();

                    System.out.print("Enter initial balance: $");
                    double balance = getDouble(input);

                    accounts[i] = new BankAccount(
                            accountNumber,
                            name,
                            balance
                    );

                    accountCreated = true;

                    System.out.println(
                            "Account created successfully!"
                    );

                } catch (IllegalArgumentException e) {

                    System.out.println(
                            "Error: " + e.getMessage()
                    );

                    System.out.println(
                            "Please enter the account information again."
                    );
                }
            }
        }

        // Display all accounts


        System.out.println("        ACCOUNT INFORMATION");
        

        for (int i = 0; i < accounts.length; i++) {

            System.out.println("\nAccount " + (i + 1));
            accounts[i].displayAccount();
        }

        // Perform transactions for each account
        for (int i = 0; i < accounts.length; i++) {

            System.out.println("\n");
            System.out.println(
                    "TRANSACTIONS FOR ACCOUNT " + (i + 1)
            );
           

            // Deposit
            boolean depositSuccessful = false;

            while (!depositSuccessful) {

                try {

                    System.out.print("Enter deposit amount: $");
                    double depositAmount = getDouble(input);

                    accounts[i].deposit(depositAmount);

                    System.out.printf(
                            "Deposit successful! New balance: $%.2f%n",
                            accounts[i].getBalance()
                    );

                    depositSuccessful = true;

                } catch (IllegalArgumentException e) {

                    System.out.println(
                            "Deposit Error: " + e.getMessage()
                    );

                } finally {

                    System.out.println(
                            "Deposit transaction has been processed."
                    );
                }
            }

            // Withdrawal
            boolean withdrawalSuccessful = false;

            while (!withdrawalSuccessful) {

                try {

                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = getDouble(input);

                    accounts[i].withdraw(withdrawalAmount);

                    System.out.printf(
                            "Withdrawal successful! New balance: $%.2f%n",
                            accounts[i].getBalance()
                    );

                    withdrawalSuccessful = true;

                } catch (InsufficientFundsException e) {

                    System.out.println(
                            "Withdrawal Error: " + e.getMessage()
                    );

                    System.out.println(
                            "Please enter a smaller amount."
                    );

                } catch (IllegalArgumentException e) {

                    System.out.println(
                            "Withdrawal Error: " + e.getMessage()
                    );

                } finally {

                    System.out.println(
                            "Withdrawal transaction has been processed."
                    );
                }
            }
        }

        // Final account information
        System.out.println("\n");
        System.out.println("       FINAL ACCOUNT INFORMATION");
        System.out.println("                    ");

        for (int i = 0; i < accounts.length; i++) {

            System.out.println("\nAccount " + (i + 1));
            accounts[i].displayAccount();
        }

        
        System.out.println("Thank you for using the banking system!");
       

        input.close();
    }

    //  get a double value
    public static double getDouble(Scanner input) {

        while (true) {

            try {

                String value = input.nextLine();

                return Double.parseDouble(value);

            } catch (NumberFormatException e) {

                System.out.print(
                        "Invalid number. Please enter a valid amount: $"
                );
            }
        }
    }
}