package main;

import service.ExpenseService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseService service = new ExpenseService();

        while(true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Filter by Category");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch(choice) {

                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    service.addExpense(title, amount, category);
                    break;

                case 2:
                    service.viewExpenses();
                    break;

                case 3:
                    service.totalExpense();
                    break;

                case 4:
                    service.viewExpenses();
                    System.out.print("Enter index to delete: ");
                    int index = sc.nextInt();
                    sc.nextLine();

                    service.deleteExpense(index);
                    break;

                case 5:
                    System.out.print("Enter category: ");
                    String cat = sc.nextLine();
                    service.filterByCategory(cat);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}