import java.util.Hashtable;
import java.util.Scanner;
import java.util.ArrayList;
public class Player {
    private String name;
    private int money;
    Hashtable<Item,Integer> inventory;
    private Room activeRoom;
    private House activeHouse;
    public ArrayList<Tree> farm = new ArrayList<Tree>();
    public Player(){
        this("<Name Unknown>");
    }
    
    /**
     * Full constructor of Player
     * @param name the name of the player
     */
    public Player(String name){
        this.money = 0;
        this.name = name;
        this.inventory = new Hashtable<>();
        this.farm = new ArrayList<Tree>();
    }
    
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

    public void sell(Item sold){
        if (inventory.containsKey(sold)){
            System.out.println("Are you going to sell this? how many of " + sold + " do you want to sell?");
            Scanner scanner = new Scanner(System.in);
            Integer Num = scanner.nextInt();
            scanner.close();
            if (Num <= inventory.get(sold)){
                inventory.put(sold, inventory.get(sold)-Num);
            }
            else{
                throw new RuntimeException("What? you do not even have that many!");
            }
        }
        else{
            throw new RuntimeException("You can not sell it before you have it.");
        }
    }

    public void plant(Tree tree){
        if (!farm.contains(tree)){
            System.out.println("Emmmm we haven't heard of that before, may be you want to try it another time");
        }else{
            System.out.println("You have had a " + tree + "!");

        }
}


    /**
     * If all the keys are taken, then the player wins the game
     * @return if the player wins
     */
    public boolean winGame(){
        if (this.inventory.get("Key") == 7){
            return true;
        }
        return false;
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

    // print inventory
}
