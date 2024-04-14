import java.util.Hashtable;

public class Item {

    private int value;
    private String name;
    private boolean canTake;

    public Item(){
        this("<Name Unknown>",0,false);
    }

    public Item(String name, int value){
        this();
        this.name = name;
        this.value = value;
    }

    public Item(String name, int value, boolean canTake){
        this.name = name;
        this.value = value;
        this.canTake = canTake;
    }

    public void setValue(int v){
        this.value = v;
    }

    public void setName(String n){
        this.name = n;
    }

    public int getValue(){
        return this.value;
    }

    public String getName(){
        return this.name;
    }

    public boolean canTake(){
        return this.canTake;
    }

    public String toString(){
        return "Great discovery! " + this.name + " is worth " + this.value + "!";
    }
}
