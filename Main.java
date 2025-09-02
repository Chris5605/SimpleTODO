import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        boolean running = true;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to SimpleTODO!");
        System.out.println("To get started, select an action from the following list.");
        System.out.println("1. Add item");
        System.out.println("2. View list.");
        System.out.println("3. Remove item.");
        System.out.println("4: Mark an item as done.");
        System.out.println("5. Exit program.");

        while(running){
            System.out.print("Enter number here: ");
            String currLine = scanner.nextLine();

            Scanner lineScan = new Scanner(currLine);
            int answer = lineScan.nextInt();
            lineScan.close();

            if (answer == 1){
                System.out.print("Please enter item description: ");
                todoList.addItem(scanner.nextLine());
                System.out.println("Item added.");
            } else if (answer == 2){
                todoList.listItems();
            } else if (answer == 3){
                todoList.listItems();
                System.out.print("Please enter index of item you want removed: ");
                String newLine = scanner.nextLine();
                Scanner partScan = new Scanner(newLine);
                todoList.removeItem(partScan.nextInt());
                partScan.close();
                System.out.println("Item removed!");
            } else if(answer == 4){
                todoList.listItems();
                System.out.print("Please enter index of item you completed: ");
                String newLine = scanner.nextLine();
                Scanner partScan = new Scanner(newLine);
                todoList.markDone(partScan.nextInt());
                partScan.close();
                System.out.println("Item marked complete!");
            } else if(answer == 5){
                System.out.println("Thank you for using SimpleTODO");
                running = false;
            } else {
                System.out.println("Invalid answer");
            }
        }

        scanner.close();
    }
}