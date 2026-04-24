package service;

import model.Expense;
import java.util.*;
import java.io.*;

public class ExpenseService {

    ArrayList<Expense> expenses = new ArrayList<>();

    public ExpenseService() {
        loadFromFile();
    }

    //  Add Expense
    public void addExpense(String title, double amount, String category) {
        expenses.add(new Expense(title, amount, category));

        try(FileWriter fw = new FileWriter("expenses.txt", true)) {
            fw.write(title + "," + amount + "," + category + "\n");
        } catch(IOException e) {
            System.out.println("Error saving expense!");
        }

        System.out.println("Expense added successfully!");
    }

    //  View Expenses
    public void viewExpenses() {
        if(expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.printf("%-5s %-15s %-15s %-10s\n", "No", "Title", "Category", "Amount");
        System.out.println("-------------------------------------------------------");

        for(int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);

            System.out.printf("%-5d %-15s %-15s ₹%.2f\n",
                    (i+1),
                    e.getTitle(),
                    e.getCategory(),
                    e.getAmount()
            );
        }
    }

    //  Total Expense
    public void totalExpense() {
        double sum = 0;

        for(Expense e : expenses) {
            sum += e.getAmount();
        }

        System.out.printf("Total Expense: ₹%.2f\n", sum);
    }

    // Delete Expense
    public void deleteExpense(int index) {
        if(index > 0 && index <= expenses.size()) {
            expenses.remove(index - 1);
            rewriteFile();
            System.out.println("Expense deleted!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    //  Filter by Category
    public void filterByCategory(String category) {
        boolean found = false;

        for(Expense e : expenses) {
            if(e.getCategory().equalsIgnoreCase(category)) {
                System.out.println(e.getTitle() + " - ₹" + e.getAmount());
                found = true;
            }
        }

        if(!found) {
            System.out.println("No expenses found in this category.");
        }
    }

    // Load from file
    public void loadFromFile() {
        try(BufferedReader br = new BufferedReader(new FileReader("expenses.txt"))) {

            String line;

            while((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                //  Safety check
                if(parts.length == 3) {
                    try {
                        String title = parts[0];
                        double amount = Double.parseDouble(parts[1]);
                        String category = parts[2];

                        expenses.add(new Expense(title, amount, category));
                    } catch(Exception e) {
                        continue; // skip invalid line
                    }
                }
            }

        } catch(IOException e) {
            System.out.println("No previous data found.");
        }
    }

    //  Rewrite file after delete
    public void rewriteFile() {
        try(FileWriter fw = new FileWriter("expenses.txt")) {

            for(Expense e : expenses) {
                fw.write(e.getTitle() + "," + e.getAmount() + "," + e.getCategory() + "\n");
            }

        } catch(IOException e) {
            System.out.println("Error updating file!");
        }
    }
}