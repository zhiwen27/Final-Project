import java.util.Hashtable;
import java.util.Scanner;
public class Player {
    private String name;
    private int money;
    Hashtable<Item,Integer> inventory;
    private Room activeRoom;
    private House activeHouse;
    Hashtable<String, Integer> farm;
    public Player(){
        this("<Name Unknown>");
    }

    public Player(String name){
        this.money = 0;
        this.name = name;
        this.inventory = new Hashtable<>();
    }

    public void grab(Item i){
        if (i.canTake()){
            if ((this.inventory.containsKey(i))){
                System.out.println("Congratulations! You have found another " + i.getName() + " !");
                this.inventory.put(i, this.inventory.get(i) + 1);
            }
            else{
                System.out.println("Congratulations! You have discovered " + i.getName() + " !");
                this.inventory.put(i, 1);
            }
        }
        else{
            System.out.println("Sorry, " + i.getName() + " cannot be taken.");
        }
    }

    // might not be useful
    public void drop(Item i){
        if (this.inventory.containsKey(i)){
            this.inventory.remove(i);
            System.out.println("Alright, you've successfully dropped " + i.getName() + " !");
        }
        else{
            System.out.println("Sorry, you have not discovered " + i.getName() + " yet.");
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
    public void plant(String type){
        if (farm.containsKey(type)){
            farm.put(type, farm.get(type) + 1);
        }
        else{
            throw new RuntimeException("We haven't heard of "+type +" in this world.");
        }
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
