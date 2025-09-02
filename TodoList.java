import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TodoList {
    ArrayList<ListItem> list = new ArrayList<>();

    public void addItem(String item){
        list.add(new ListItem(item));
    }

    public void listItems(){
        for(int i = 0; i < list.size(); i++){
            System.out.println(i + ". " + list.get(i).getDesc() + ", " + list.get(i).isDone());
        }
    }

    public void saveList(PrintStream output){
        for(int i = 0; i < list.size(); i++){
            output.println(list.get(i).getDesc() + " , " + list.get(i).isDone());
        }
    }

    public void loadLine(String line){
        Scanner lineScanner = new Scanner(line);
        String loadDesc = "";
        String currWord = "";
        while (!currWord.equals(",")){
            loadDesc += currWord;
            currWord = lineScanner.next();
        }

        boolean loadDone = lineScanner.next().equals("true");
        list.add(new ListItem(loadDesc, loadDone));
        lineScanner.close();
    }

    public void markDone(int index){
        list.get(index).markDone();
    }

    public void removeItem(int index){
        list.remove(index);
    }
}
