import java.util.ArrayList;

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

    public void markDone(int index){
        list.get(index).markDone();
    }

    public void removeItem(int index){
        list.remove(index);
    }
}
