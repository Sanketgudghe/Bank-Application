package Bank_management_system;
import java.util.Scanner;

public class mainmenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankOperation bank = new BankService(); 

        while (true) {
            System.out.println("\n===== Bank Application =====");
            System.out.println("1. New Registration");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter Initial Amount: ");
                    double balance = sc.nextDouble();
                    BankAccount acc = new BankAccount(name, contact, address, balance);
                    bank.register(acc);
                }
                case 2 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Deposit Amount: ");
                    double amount = sc.nextDouble();
                    bank.deposit(id, amount);
                }
                case 3 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Withdraw Amount: ");
                    double amount = sc.nextDouble();
                    bank.withdraw(id, amount);
                }
                case 4 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    bank.checkBalance(id);
                }
                case 5 -> {
                    System.out.println("Thank you for using Bank Application!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
