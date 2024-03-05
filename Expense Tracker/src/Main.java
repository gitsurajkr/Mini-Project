import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

//        calculateExpense cs = new calculateExpense();

        Scanner sc = new Scanner(System.in);
        int choice;


        while (true){
            System.out.println();
            System.out.println("\t\t  Expense Tracker\t\t");
            System.out.println("_________________________________");
            System.out.println("0.Exit from Program");
            System.out.println("1.Add Expense");//done
            System.out.println("2.View Expense");//done
            System.out.println("3.Categorize Expense");//done
            System.out.println("4.Calculate Expense");//done
            System.out.println("5.View Summary Report");//done
            choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    calculateExpense.addExpense(sc);
                    break;
                }
                case 2: {
                    calculateExpense.viewExpense();
                    break;
                }
                case 3: {
                    calculateExpense.categorizeExpense(sc);
                    break;
                }
                case 4: {
                    System.out.println("Total Expense: "+calculateExpense.calculateTotalExpense());
                    break;
                }
                case 5: {
                    calculateExpense.viewSummaryReport();
                    break;
                }
                case 0: {
                    System.out.println("Quiting program......");
                    System.out.println("Have a nice day!!!");
                    return;
                }

                default: {
                    System.out.println("Invalid Choice!!");
                }


            }
        }

    }
}