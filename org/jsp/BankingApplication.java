package org.jsp;

import java.util.Scanner;

public class BankingApplication {
    private static final int EXIT = 0;
    private static final int CHECK_BALANCE = 1;
    private static final int DEPOSIT = 2;
    private static final int WITHDRAWAL = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0;
        int choice;

        while (true) {
            System.out.println("\nWelcome to the Banking Application!");
            System.out.println("Please choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("0. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case CHECK_BALANCE:
                    System.out.println("Your current balance is: " + balance);
                    break;
                case DEPOSIT:
                    System.out.println("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    System.out.println("Deposit successful! Your new balance is: " + balance);
                    break;
                case WITHDRAWAL:
                    System.out.println("Enter the amount to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    if (withdrawalAmount > balance) {
                        System.out.println("Insufficient balance! Please try again.");
                    } else {
                        balance -= withdrawalAmount;
                        System.out.println("Withdrawal successful! Your new balance is: " + balance);
                    }
                    break;
                case EXIT:
                    System.out.println("Thank you for using the Banking Application!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
