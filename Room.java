import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.google.common.graph.*;
public class Room {
    private String name;
    MutableGraph<Item> itemCollection;
    Item activeItem = null;

    public Room(){
        this.name = "";
        this.itemCollection = GraphBuilder.undirected().build();
    }

    public String getName(){
        return this.name;
    }
    
    public void addLivingRoom(){
        this.name = "Living Room";
    }

    public void addKitchen(){
        this.name = "Kitchen";
    }

    public void addBedroom(){
        this.name = "Bedroom";
    }

    public void addBasement(){
        this.name = "Basement";
    }

    public void addAttic(){
        this.name = "Attic";
    }

    public void addEdge(Item item1, Item item2){
        this.itemCollection.putEdge(item1, item2);
    }

    public Boolean getAdjacentItem(Item start, Item end){
        if (this.itemCollection.adjacentNodes(start).equals(end)){
            this.activeItem = end;
            return true;
        }
        else{
            System.out.println("Sorry, you cannot get " + end.getName() + " .");
            return false;
        }
    }
    public void printCollection(Item i){
        Set<Item> getter = itemCollection.adjacentNodes(i);
        System.out.println(getter);
    }

    public static void main(String[] args) {
        Room newRoom = new Room();
        newRoom.addKitchen();
        Jewelry crystal = new Jewelry();
        crystal.addCrystal();
        Jewelry gold = new Jewelry();
        gold.addGold();
        newRoom.addEdge(crystal, gold);
        newRoom.printCollection(gold);
    }
}
