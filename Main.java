import java.util.Scanner;
import java.io.*;

import javax.swing.*;

public class Main{
    public static void main(String[] args) throws FileNotFoundException{ 
        TodoList todoList = new TodoList();

        boolean running = true;

        Scanner scanner = new Scanner(System.in);

        JFrame frame = new JFrame("SimpleTODO");
        initFrame(frame);

        printMenu();

        while(running){
            System.out.print("Enter number here: ");

            int answer = scanner.nextInt();
            scanner.nextLine();

            switch (answer) {
                case 1:
                    System.out.print("Please enter item description: ");
                    todoList.addItem(scanner.nextLine());
                    System.out.println("Item added.");
                    break;
                case 2: 
                    todoList.listItems();
                    break;
                case 3:
                    todoList.listItems();
                    System.out.print("Please enter index of item you want removed: ");
                    todoList.removeItem(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Item removed!");
                    break;
                case 4:
                    todoList.listItems();
                    System.out.print("Please enter index of item you completed: ");
                    todoList.markDone(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Item marked complete!");
                    break;
                case 5:
                    PrintStream output = new PrintStream("SaveData.csv");
                    todoList.saveList(output);
                    System.out.println("List saved!");
                    break;
                case 6:
                    Scanner fileInput = new Scanner(new File("SaveData.csv"));
                    while(fileInput.hasNextLine()){
                        String nextLine = fileInput.nextLine();
                        todoList.loadLine(nextLine);
                    }
                    fileInput.close();
                    System.out.println("List imported!");
                    break;
                case 7: 
                    System.out.println("Thank you for using SimpleTODO");
                    running = false;
                    break;
                default: 
                    System.out.println("Please enter an integer between 1 and 7.");
            }
        }
        scanner.close();
    }

    public static void printMenu(){
        System.out.println("Welcome to SimpleTODO!");
        System.out.println("To get started, select an action from the following list.");
        System.out.println("1. Add item.");
        System.out.println("2. View list.");
        System.out.println("3. Remove item.");
        System.out.println("4: Mark an item as done.");
        System.out.println("5. Save TODO list.");
        System.out.println("6. Import previous TODO list.");
        System.out.println("7. Exit program.");
    }

    public static void initFrame(JFrame frame){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("test");
        frame.getContentPane().add(label);
        frame.setSize(825,540);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
    }
}