import java.util.Scanner;
import java.io.*;

public class Main{
    public static void main(String[] args) throws FileNotFoundException{ 
        TodoList todoList = new TodoList();

        boolean running = true;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to SimpleTODO!");
        System.out.println("To get started, select an action from the following list.");
        System.out.println("1. Add item.");
        System.out.println("2. View list.");
        System.out.println("3. Remove item.");
        System.out.println("4: Mark an item as done.");
        System.out.println("5. Save TODO list.");
        System.out.println("6. Import previous TODO list.");
        System.out.println("7. Exit program.");

        while(running){
            System.out.print("Enter number here: ");

            int answer = scanner.nextInt();
            scanner.nextLine();

            if (answer == 1){
                System.out.print("Please enter item description: ");
                todoList.addItem(scanner.nextLine());
                System.out.println("Item added.");
            } else if (answer == 2){
                todoList.listItems();
            } else if (answer == 3){
                todoList.listItems();
                System.out.print("Please enter index of item you want removed: ");
                todoList.removeItem(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Item removed!");
            } else if(answer == 4){
                todoList.listItems();
                System.out.print("Please enter index of item you completed: ");
                todoList.markDone(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Item marked complete!");
            } else if(answer == 5){
                PrintStream output = new PrintStream("SaveData.csv");
                todoList.saveList(output);
                System.out.println("List saved!");
            } else if(answer == 6){
                Scanner fileInput = new Scanner(new File("SaveData.csv"));
                while(fileInput.hasNextLine()){
                    String nextLine = fileInput.nextLine();
                    todoList.loadLine(nextLine);
                }
                fileInput.close();
                System.out.println("List imported!");
            } else if(answer == 7){
                System.out.println("Thank you for using SimpleTODO");
                running = false;
            } else {
                System.out.println("Invalid answer");
            }
        }

        scanner.close();
    }
}