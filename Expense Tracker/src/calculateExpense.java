import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Expense {
    double amount;
    String date;
    String category;

    public Expense(double amount, String date, String category) {

        this.amount = amount;
        this.date = date;
        this.category = category;
    }
}

public class calculateExpense {

    public static void  updateCategoryTotal(String category,double amount){
        categoryTotal.put(category,categoryTotal.getOrDefault(category,0.0)+amount);
    }
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static HashMap<String,Double> categoryTotal = new HashMap<>();

    public static void addExpense(Scanner sc) {
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Date:YYYY-MM-DD");
        String date = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        expenses.add(new Expense(amount,date,category));
        updateCategoryTotal(category,amount);


    }
    public static void viewExpense(){
        System.out.println("\nView Expense");
        for (int i = 0; i< expenses.size();i++){
            Expense expense = expenses.get(i);
            System.out.printf("%n%d. Amount: Rs.%.2f  Date: %s  Category: %s%n ",i+1,expense.amount,expense.date,expense.category);

        }
    }
    public static void categorizeExpense(Scanner sc){
        System.out.println("Enter Expense Number to Categorize");
        int expenseNumber = sc.nextInt();
        sc.nextLine();//consume new line

        if(expenseNumber<1 || expenseNumber>expenses.size()){
            System.out.println("Invalid Expense Number");
            return;
        }

        System.out.print("Enter New Category for the expense: ");
        String newCategory = sc.nextLine();

        Expense expenseToUpdate = expenses.get(expenseNumber-1);
        String oldCategory = expenseToUpdate.category;

        expenseToUpdate.category = newCategory;

        updateCategoryTotal(oldCategory,-expenseToUpdate.amount);
        updateCategoryTotal(newCategory,expenseToUpdate.amount);

        System.out.println("Expense Categorized Successfully");


    }
    public static double calculateTotalExpense(){
        double totalExpenses = 0.0;
        for(Expense expense:expenses){
            totalExpenses = totalExpenses+expense.amount;
        }
        return totalExpenses;
    }

    public static void viewSummaryReport() {
        System.out.println("\nSummary Report");
        System.out.println("Category\t\t|Total Amount");
        System.out.println("...........\t\t|..............");
        for (String category: categoryTotal.keySet()){
            System.out.printf("%-16s| Rs.%.2f%n",category,categoryTotal.get(category));
        }
    }
}