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
        this.name = "LIVING ROOM";
        Item diamond = new Item("DIAMOND", 100);
        Item chair = new Item("A WOODEN CHAIR",false);
        Item sofa = new Item("A WHITE FLUFFY SOFT SOFA",false);
        Item cushion1 = new Item("A PINK LOVELY CUSHION",5);
        Item cushion2 = new Item("JELLY RABBIT",100);
        Item key = new Item("KEY",500);
        this.itemCollection.add(diamond);
        this.itemCollection.add(chair);
        this.itemCollection.add(sofa);
        this.itemCollection.add(cushion1);
        this.itemCollection.add(cushion2);
        this.itemCollection.add(key);
        this.addMoveableItem();
        // create some new items
        return this;
    }

    public Room addKitchen(){
        this.name = "KITCHEN";
        Item table = new Item("A BIG LONG TABLE",false);
        Item candle = new Item("CANDLE", 5);
        Item knife = new Item("KNIFE",5);
        this.itemCollection.add(table);
        this.itemCollection.add(candle);
        this.itemCollection.add(knife);
        this.addMoveableItem();
        // create some new items
        return this;
    }

    public Room addBedroom(){
        this.name = "BEDROOM";
        Item bed = new Item("A BIG COMFORTABLE BED",false);
        Item necklace = new Item("A CRYSTAL NECKLACE",100);
        Item key = new Item("KEY",500);
        this.itemCollection.add(bed);
        this.itemCollection.add(necklace);
        this.itemCollection.add(key);
        this.addMoveableItem();
        // create some new items
        return this;
    }

    public Room addBasement(){
        this.name = "BASEMENT";
        Item box = new Item("BOX", 0);
        Item key = new Item("KEY",500);
        this.itemCollection.add(box);
        this.itemCollection.add(key);
        this.addMoveableItem();
        // create some new items
        return this;
    }

    public Room addAttic(){
        this.name = "ATTIC";
        Item lantern = new Item("LANTERN",50);
        Item key = new Item("KEY",500);
        this.itemCollection.add(lantern);
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