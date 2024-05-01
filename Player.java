import java.util.Hashtable;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Enumeration;

public class Player {
    private String name;
    Hashtable<Item,Integer> inventory;
    private Room activeRoom;
    private House activeHouse;
    public ArrayList<Tree> farm;
    private boolean toPlay;

    /**
     * Default constructor for Player
     */
    public Player(){
        this("<Name Unknown>");
    }
    
    /**
     * Full constructor of Player
     * @param name the name of the player
     */
    public Player(String name){
        this.name = name;
        this.inventory = new Hashtable<>();
        this.farm = new ArrayList<Tree>();
        this.toPlay = true;
        this.farm = new ArrayList<Tree>();
    }
    
    /**
     * Pick up an item and put into the inventory
     * @param i
     */
    public void grab(Item i){
        if (i.canTake()){
            if ((this.inventory.containsKey(i))){
                System.out.println("Congratulations! You have found another " + i.getName() + "!");
                this.inventory.put(i, this.inventory.get(i) + 1);
            }
            else{
                System.out.println("Congratulations! You have discovered " + i.getName() + "!");
                this.inventory.put(i, 1);
            }
        }
        else{
            System.out.println("Sorry, " + i.getName() + " cannot be taken.");
        }
    }

    /**
     * Sell the tree to Old Man
     * @param sold the item sold
     * @return selling price
     */
    public Integer sell(Item sold){
        if (inventory.containsKey(sold)){
            System.out.println("Are you going to sell this? How many " + sold.name.toLowerCase() + " do you want to sell?");
            Scanner scanner = new Scanner(System.in);
            Integer num = scanner.nextInt();
            if (num <= inventory.get(sold)){
                inventory.put(sold, inventory.get(sold) - num);
                return num * sold.value;
            }
            else{
                System.out.println("What? You don't even have that many!");
                return 0;
            }
        }
        else{
            System.out.println("You cannot sell it before you have it.");
            return 0;
        }
    }

    /**
     * Plant a tree
     * @param tree the tree the player want to plant
     */
    public void plant(Tree tree){
        if (!farm.contains(tree)){
            System.out.println("Emmm we haven't heard of that before, maybe you want to try it another time");
        }else{
            System.out.println("You have planted a " + tree.name + "!");
            tree.numTrees += 1;
            this.inventory.put(tree.fruit,0);
        }
    }
    
    /**
     * Setter for current room
     * @param r the room the player is currently in
     */
    public void setRoom(Room r){
        this.activeRoom = r;
    }

    /**
     * Getter for current room
     * @return the room the player is currently in
     */
    public Room getRoom(){
        return this.activeRoom;
    }

    /**
     * Setter for current house
     * @param h the house the player is currently in
     */
    public void setHouse(House h){
        this.activeHouse = h;
    }

    /**
     * Getter for current house
     * @return the house the player is currently in
     */
    public House getHouse(){
        return this.activeHouse;
    }

    /**
     * Getter for name
     * @return name of the player
     */
    public String getName(){
        return this.name;
    }

    /**
     * Print out the inventory for Adventure Mode
     */
    public void printInventory(){
        System.out.println("You have now discovered:");
        Enumeration<Item> keys = this.inventory.keys();
        while(keys.hasMoreElements()){
          System.out.println(keys.nextElement());
        }
    }

    /**
     * Print out the inventory for Farming Mode
     */
    public void printFruit(){
        System.out.println("You now have:");
        for(Item i: this.inventory.keySet()){
            System.out.println(this.inventory.get(i) + " " + i.name);
        }
    }

    /**
     * Getter indicating if continue the game
     * @return if continue the game
     */
    public boolean toPlay(){
        return this.toPlay;
    }

    /**
     * Setter indicating if continue the game
     * @param toPlay if continue the game
     */
    public void setToPlay(boolean toPlay){
        this.toPlay = toPlay;
    }

    /**
     * Print the farm
     */
    public void printFarm(){
        System.out.println("You have a farm with " + this.farm.size() + " trees.\n");
        for (Tree t: this.farm){
            System.out.println(t);
        }
    }
}