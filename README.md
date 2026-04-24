## Features
- Add, View, Delete Expenses
- Category-based Filtering
- Total Expense Calculation
- Persistent Storage using File Handling

## Tech Stack
- Java
- OOP (Object-Oriented Programming)
- File Handling
- ArrayList

## Project Structure
- model → Data classes
- service → Business logic
- main → User interaction

## Sample Output
1. Add Expense
2. View Expenses
3. Total Expense
4. Delete Expense
5. Filter by Category
6. Exit
Enter choice: 1
Enter title: food
Enter amount: 2000
Enter category: daily
Expense added successfully!

1. Add Expense
2. View Expenses
3. Total Expense
4. Delete Expense
5. Filter by Category
6. Exit
Enter choice: 1
Enter title: travel
Enter amount: 5000
Enter category: transport
Expense added successfully!

1. Add Expense
2. View Expenses
3. Total Expense
4. Delete Expense
5. Filter by Category
6. Exit
Enter choice: 2
No    Title           Category        Amount    
-------------------------------------------------------
1     FOOD            DAILY           ₹250.00
2     TRAVEL          TRANSPORT       ₹100.00
3     food            daily           ₹2000.00
4     travel          transport       ₹5000.00

1. Add Expense
2. View Expenses
3. Total Expense
4. Delete Expense
5. Filter by Category
6. Exit
Enter choice: 3
Total Expense: ₹7350.00

1. Add Expense
2. View Expenses
3. Total Expense
4. Delete Expense
5. Filter by Category
6. Exit
Enter choice: 5
Enter category: daily
FOOD - ₹250.0
food - ₹2000.0

