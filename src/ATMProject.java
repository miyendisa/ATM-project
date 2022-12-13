import java.util.Scanner;

public class ATMProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String holdersName = "A", password = "8";
        String scHoldersName, scPassword;
        int operation, balance = 1500, deposit;
        int right = 3;
        while (right > 0) {
            System.out.print("Enter the cardholder's name: ");
            scHoldersName = scanner.nextLine();
            System.out.print("Enter the password: ");
            scPassword = scanner.nextLine();
            if (scHoldersName.equals(holdersName) && scPassword.equals(password)) {
                System.out.println("""
                        Login Successful!
                        *****************************
                          Welcome to the Aslı Bank!
                        *****************************""");
                do {
                    System.out.println("""
                            Which operation would you like to choose ?
                            Choose 1 for Withdraw Cash
                            Choose 2 for Deposit Cash
                            Choose 3 for Check Balance
                            Choose 4 for Exit""");
                    System.out.print("Choose the operation: ");
                    operation = scanner.nextInt();
                    switch (operation) {
                        case 1:
                            System.out.print("Enter the amount to withdraw: ");
                            int withdraw = scanner.nextInt();
                            if (withdraw <= balance) {
                                balance -= withdraw;
                                System.out.println("Please collect your money.");
                            } else {
                                System.out.println("Insufficient Balance.\n" +
                                        "Check your balance and try a different amount.");
                                System.out.println("You are redirected to the operation menu.");
                                System.out.println();
                            }
                            break;
                        case 2:
                            System.out.print("Enter the amount to deposit: ");
                            deposit = scanner.nextInt();
                            balance += deposit;
                            System.out.println("Your money has been successfully deposited\n" +
                                    "Your new balance: " + balance);
                            break;
                        case 3:
                            System.out.println("Your Balance: " + balance);
                            break;
                        case 4:
                            System.out.println("You have successfully logged out.\nThank you.");
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                } while (operation != 4);
                break;
            } else {
                System.out.println("The cardholder's name or password is incorrect.Try again.\n" +
                        (--right) + " attempts left.");
            }
        }
        if (right == 0) {
            System.out.print("Your account has been blocked\nCall the customer service.");
        }
    }
}
