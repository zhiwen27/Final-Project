import java.util.Hashtable;
import java.util.Scanner;
public class Player {
    private String name;
    private int money;
    Hashtable<Item,Integer> inventory;

    public Player(){
        this("<Name Unknown>");
    }

    public Player(String name){
        this.money = 0;
        this.name = name;
        this.inventory = new Hashtable<>();
    }

    public void grab(Item i){
        if (this.inventory.containsKey(i)){
            System.out.println("Congratulations! You have found another " + i.getName() + " !");
            this.inventory.put(i, this.inventory.get(i) + 1);
        }
        else{
            System.out.println("Congratulations! You have discovered " + i.getName() + " !");
            this.inventory.put(i, 1);
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
            }else{
                throw new RuntimeException("What? you do not even have that many!");
            }
    }else{
        throw new RuntimeException("You can not sell it before you have it.");
    }


    // public void walk: walk through edges to visit different nodes
}}
