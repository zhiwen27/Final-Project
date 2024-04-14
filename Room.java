import java.util.ArrayList;

import com.google.common.graph.*;
public class Room {
    private String name;
    ArrayList<Item> itemCollection;

    public Room(){
        this.name = "";
        this.itemCollection = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void addLivingRoom(){
        this.name = "Living Room";
        Item gold1 = new Item("Gold 1", 100);
        // create some new items and add into the kitchen
        System.out.println(this);
    }

    public void addKitchen(){
        this.name = "Kitchen";
        
        Item candle = new Item("Candle", 5);
        // create some new items and add into the kitchen
        System.out.println(this);
    }

    public void addBedroom(){
        this.name = "Bedroom";
        // create some new items and add into the kitchen
        System.out.println(this);
    }

    public void addBasement(){
        this.name = "Basement";
        // create some new items and add into the kitchen
        System.out.println(this);
    }

    public void addAttic(){
        this.name = "Attic";
    }

    public void addItem(Item i){
        this.itemCollection.add(i);
    }

    public void removeItem(Item i){
        this.itemCollection.remove(i);
    }

    public String printCollection(){
        String s = "The " + this.name + " now has:\n";
        for (Item i: this.itemCollection){
            s += "**" + i.getName() + "**\n";
        }
        return s;
    }

    public String toString(){
        return "Welcome! This is " + this.name + ".\n" + this.printCollection();
    }

    public static void main(String[] args) {
        Room newRoom = new Room();
        newRoom.addKitchen();
    }
}
