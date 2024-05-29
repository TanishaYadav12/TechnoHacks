import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private static class ToDoItem {
        String description;
        boolean isDone;

        ToDoItem(String description) {
            this.description = description;
            this.isDone = false;
        }

        void markAsDone() {
            this.isDone = true;
        }

        @Override
        public String toString() {
            return description + (isDone ? " [Done]" : "");
        }
    }

    private static ArrayList<ToDoItem> toDoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    viewToDoList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    editItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    markItemAsDone();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nTo-Do List Application");
        System.out.println("1. View To-Do List");
        System.out.println("2. Add Item");
        System.out.println("3. Edit Item");
        System.out.println("4. Delete Item");
        System.out.println("5. Mark Item as Done");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void viewToDoList() {
        if (toDoList.isEmpty()) {
            System.out.println("\nYour to-do list is empty.");
        } else {
            System.out.println("\nTo-Do List:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    private static void addItem() {
        System.out.print("\nEnter the item to add: ");
        scanner.nextLine();  // Consume the newline left-over
        String item = scanner.nextLine();
        toDoList.add(new ToDoItem(item));
        System.out.println("Item added.");
    }

    private static void editItem() {
        if (toDoList.isEmpty()) {
            System.out.println("\nYour to-do list is empty. Nothing to edit.");
            return;
        }
        viewToDoList();
        System.out.print("\nEnter the number of the item to edit: ");
        int itemNumber = getUserChoice();
        if (itemNumber > 0 && itemNumber <= toDoList.size()) {
            System.out.print("Enter the new content for the item: ");
            scanner.nextLine();  // Consume the newline left-over
            String newItem = scanner.nextLine();
            toDoList.get(itemNumber - 1).description = newItem;
            System.out.println("Item updated.");
        } else {
            System.out.println("Invalid item number.");
        }
    }

    private static void deleteItem() {
        if (toDoList.isEmpty()) {
            System.out.println("\nYour to-do list is empty. Nothing to delete.");
            return;
        }
        viewToDoList();
        System.out.print("\nEnter the number of the item to delete: ");
        int itemNumber = getUserChoice();
        if (itemNumber > 0 && itemNumber <= toDoList.size()) {
            toDoList.remove(itemNumber - 1);
            System.out.println("Item deleted.");
        } else {
            System.out.println("Invalid item number.");
        }
    }

    private static void markItemAsDone() {
        if (toDoList.isEmpty()) {
            System.out.println("\nYour to-do list is empty. Nothing to mark as done.");
            return;
        }
        viewToDoList();
        System.out.print("\nEnter the number of the item to mark as done: ");
        int itemNumber = getUserChoice();
        if (itemNumber > 0 && itemNumber <= toDoList.size()) {
            toDoList.get(itemNumber - 1).markAsDone();
            System.out.println("Item marked as done.");
        } else {
            System.out.println("Invalid item number.");
        }
    }
}
