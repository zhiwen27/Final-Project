import java.util.Hashtable;

public class Item {

    private int value;
    private String name;

    public Item(){
        this("<Name Unknown>",0);
    }

    public Item(String name){
        this();
        this.name = name;
    }

    public Item(int value){
        this();
        this.value = value;
    }

    public Item(String name, int value){
        this.name = name;
        this.value = value;
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

    public String toString(){
        return "Great discovery! " + this.name + " is worth " + this.value + "!";
    }
}
