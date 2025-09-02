public class ListItem {
    String itemDesc;
    boolean isDone;
    
    public ListItem(String itemDesc){
        this.itemDesc = itemDesc;
        isDone = false;
    }

    public ListItem(String itemDesc, boolean isDone){
        this.itemDesc = itemDesc;
        this.isDone = isDone;
    }

    public void changeDesc(String itemDesc){
        this.itemDesc = itemDesc;
    }

    public String getDesc(){
        return itemDesc;
    }

    public boolean isDone(){
        return isDone;
    }

    public void markDone(){
        isDone = true;
    }
}
