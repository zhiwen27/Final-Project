import java.util.Hashtable;

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

    // public void walk: walk through edges to visit different nodes
}
