import java.util.*;

class Expense {
    String name;
    double amount;
    String category;

    Expense(String name, double amount, String category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    public String toString() {
        return name + " - Rs." + amount + " [" + category + "]";
    }
}

public class ExpenseTracker {
    private static List<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. View Total");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addExpense(sc);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    deleteExpense(sc);
                    break;
                case 4:
                    viewTotal();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addExpense(Scanner sc) {
        System.out.print("Enter expense name: ");
        String name = sc.nextLine();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        expenses.add(new Expense(name, amount, category));
        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }
        System.out.println("\n--- All Expenses ---");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + ". " + expenses.get(i));
        }
    }

    private static void deleteExpense(Scanner sc) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to delete.");
            return;
        }
        viewExpenses();
        System.out.print("Enter expense number to delete: ");
        int index = sc.nextInt();
        if (index < 1 || index > expenses.size()) {
            System.out.println("Invalid index!");
            return;
        }
        expenses.remove(index - 1);
        System.out.println("Expense deleted successfully!");
    }

    private static void viewTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        System.out.println("Total Expenses: Rs." + total);
    }
}
