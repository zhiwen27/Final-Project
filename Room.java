import java.util.ArrayList;
public class Room {
    private String name;
    ArrayList<Item> itemCollection;
    ArrayList<Item> moveableItemCollection;
    String[] itemNames;

    public Room(){
        this.name = "";
        this.itemCollection = new ArrayList<Item>();
        this.moveableItemCollection = new ArrayList<Item>();
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
        Item key = new Item("Key",500);
        this.itemCollection.add(diamond);
        this.itemCollection.add(chair);
        this.itemCollection.add(sofa);
        this.itemCollection.add(cushion1);
        this.itemCollection.add(cushion2);
        this.itemCollection.add(key);
        this.addMoveableItem();
        // create some new items and add into the kitchen
        //System.out.println(this);
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
        this.addMoveableItem();
        // create some new items and add into the kitchen
        //System.out.println(this);
        return this;
    }

    public Room addBedroom(){
        this.name = "Bedroom";
        Item bed = new Item("A big comfortable bed",false);
        Item key = new Item("Key",500);
        this.itemCollection.add(bed);
        this.itemCollection.add(key);
        this.addMoveableItem();
        // create some new items and add into the kitchen
        //System.out.println(this);
        return this;
    }

    public Room addBasement(){
        this.name = "Basement";
        Item box = new Item("Box", 0);
        Item key = new Item("Key",500);
        this.itemCollection.add(box);
        this.itemCollection.add(key);
        this.addMoveableItem();
        // create some new items and add into the kitchen
        //System.out.println(this);
        return this;
    }

    public Room addAttic(){
        this.name = "Attic";
        Item key = new Item("Key",500);
        this.itemCollection.add(key);
        this.addMoveableItem();
        return this;
    }

    public void addItem(Item i){
        this.itemCollection.add(i);
    }

    public Item removeItem(String name){
        Item item = new Item();
        for(int i = 0; i < this.itemCollection.size(); i++){
            if (this.itemCollection.get(i).getName().contains(name) && (this.itemCollection.get(i).canTake() == true)){
                item = this.itemCollection.get(i);
                this.itemCollection.remove(this.itemCollection.get(i));
                this.moveableItemCollection.remove(item);
            }
            else if (this.itemCollection.get(i).getName().contains(name) && (this.itemCollection.get(i).canTake() == false)){
                throw new RuntimeException("Sorry, " + this.itemCollection.get(i).getName() + " cannot be taken.");
            }
        }
        return item;
    }

    public String printCollection(){
        String s = "The " + this.name + " now has:\n";
        for (Item i: this.itemCollection){
            s += "**" + i.getName() + "**\n";
        }
        return s;
    }

    public ArrayList<Item> addMoveableItem(){
        for (Item i: this.itemCollection){
            if (i.canTake() == true){
                this.moveableItemCollection.add(i);
            }
        }
        return this.moveableItemCollection;
    }

    public boolean checkItemInput(String userInput){
        this.itemNames = new String[this.itemCollection.size()];
        int cnt = 0;
        for (Item i: this.itemCollection){
            this.itemNames[cnt] = i.getName();
            cnt++;
        }
        boolean containedRequiredWord = false;
        for (int i = 0; i < this.itemNames.length; i++){
            if (userInput.contains(this.itemNames[i])){
                containedRequiredWord = true;
            }
        }
        if (containedRequiredWord == true){
            return containedRequiredWord;
        }
        else{
            throw new RuntimeException("Please enter the required word.");
        }
    }

    public String toString(){
        return "Welcome! This is " + this.name + ".\n" + this.printCollection();
    }
    
}
