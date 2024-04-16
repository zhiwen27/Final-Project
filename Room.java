import java.util.ArrayList;

import com.google.common.graph.*;
public class Room {
    private String name;
    ArrayList<Item> itemCollection;

    public Room(){
        this.name = "";
        this.itemCollection = new ArrayList<Item>();
    }

    public String getName(){
        return this.name;
    }

    public Room addLivingRoom(){
        this.name = "Living Room";
        Item diamond = new Item("Diamond", 100);
        Item chair = new Item("A Wooden Chair",false);
        Item sofa = new Item("A White Fluffy Soft Sofa",false);
        Item cushion1 = new Item("A Pink Lovely Cushion",5);
        Item cushion2 = new Item("Jelly Rabbit",100);
        this.itemCollection.add(diamond);
        this.itemCollection.add(chair);
        this.itemCollection.add(sofa);
        this.itemCollection.add(cushion1);
        this.itemCollection.add(cushion2);
        // create some new items and add into the kitchen
        System.out.println(this);
        return this;
    }

    public Room addKitchen(){
        this.name = "Kitchen";
        Item table = new Item("A Big Long Table",false);
        Item candle = new Item("Candle", 5);
        Item knife = new Item("Knife",5);
        this.itemCollection.add(table);
        this.itemCollection.add(candle);
        this.itemCollection.add(knife);
        // create some new items and add into the kitchen
        System.out.println(this);
        return this;
    }

    public Room addBedroom(){
        this.name = "Bedroom";
        // create some new items and add into the kitchen
        System.out.println(this);
        return this;
    }

    public Room addBasement(){
        this.name = "Basement";
        // create some new items and add into the kitchen
        System.out.println(this);
        return this;
    }

    public Room addAttic(){
        this.name = "Attic";
        return this;
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

}
