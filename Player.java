import java.util.Hashtable;
import java.util.Scanner;
import java.util.ArrayList;
public class Player {
    private String name;
    private int money;
    Hashtable<Item,Integer> inventory;
    private Room activeRoom;
    private House activeHouse;
    public Hashtable<Tree, Integer> farm;
    public ArrayList<String> f;
    public Player(){
        this("<Name Unknown>");
    }
    
    public Player(String name){
        this.money = 0;
        this.name = name;
        this.inventory = new Hashtable<>();
        this.f = new ArrayList<String>();
        this.farm = new Hashtable<Tree,Integer>();
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
        if (farm.containsKey(tree)){
            farm.put(tree, farm.get(tree) + 1);
        }
        else{
            throw new RuntimeException("We haven't heard of "+tree +" in this world.");
        }
    }
    public void recieve(Tree tree){
        inventory.put(tree, 1);
        f.add(tree.type);
    }

    public boolean winGame(){
        if (this.inventory.get("Key") == 7){
            return true;
        }
        return false;
    }
    
    public void setRoom(Room r){
        this.activeRoom = r;
    }

    public Room getRoom(){
        return this.activeRoom;
    }

    public void setHouse(House h){
        this.activeHouse = h;
    }

    public House getHouse(){
        return this.activeHouse;
    }

}
