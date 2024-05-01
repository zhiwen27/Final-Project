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

    /**
     * Getter for the name of the room
     * @return the name of the room
     */
    public String getName(){
        return this.name;
    }

    /**
     * Add a living room with default items
     * @return the new living room
     */
    public Room addLivingRoom(){
        this.name = "LIVING ROOM";
        Item diamond = new Item("DIAMOND", 100);
        Item sofa = new Item("A WHITE FLUFFY SOFT SOFA",false);
        Item cushion = new Item("A PINK LOVELY CUSHION",5);
        Item doll = new Item("JELLY RABBIT",100);
        Item key = new Item("KEY",500);
        this.itemCollection.add(sofa);
        this.itemCollection.add(cushion);
        this.itemCollection.add(diamond);
        this.itemCollection.add(doll);
        this.itemCollection.add(key);
        this.addMoveableItem();
        return this;
    }

    /**
     * Add a kitchen with default items
     * @return the new kitchen
     */
    public Room addKitchen(){
        this.name = "KITCHEN";
        Item table = new Item("A BIG LONG TABLE",false);
        Item candle = new Item("CANDLE", 5);
        Item knife = new Item("KNIFE",5);
        Item chair = new Item("A WOODEN CHAIR",false);
        this.itemCollection.add(table);
        this.itemCollection.add(candle);
        this.itemCollection.add(knife);
        this.itemCollection.add(chair);
        this.addMoveableItem();
        return this;
    }

    /**
     * Add a bedroom with default items
     * @return the new bedroom
     */
    public Room addBedroom(){
        this.name = "BEDROOM";
        Item bed = new Item("A BIG COMFORTABLE BED",false);
        Item necklace = new Item("A CRYSTAL NECKLACE",100);
        Item key = new Item("KEY",500);
        this.itemCollection.add(bed);
        this.itemCollection.add(necklace);
        this.itemCollection.add(key);
        this.addMoveableItem();
        return this;
    }

    /**
     * Add a basement with default items
     * @return the new basement
     */
    public Room addBasement(){
        this.name = "BASEMENT";
        Item chandelier = new Item("A BROKEN GORGEOUS CHANDELIER",false);
        Item box = new Item("EMPTY BOX", 0);
        Item key = new Item("KEY",500);
        this.itemCollection.add(chandelier);
        this.itemCollection.add(box);
        this.itemCollection.add(key);
        this.addMoveableItem();
        // create some new items
        return this;
    }

    /**
     * Add an attic with default items
     * @return the new attic
     */
    public Room addAttic(){
        this.name = "ATTIC";
        Item bed = new Item("A FOLDING BED",false);
        Item lantern = new Item("LANTERN",50);
        Item key = new Item("KEY",500);
        this.itemCollection.add(bed);
        this.itemCollection.add(lantern);
        this.itemCollection.add(key);
        this.addMoveableItem();
        return this;
    }

    /**
     * Add an item to the room
     * @param i the item you want to add
     */
    public void addItem(Item i){
        this.itemCollection.add(i);
    }

    /**
     * Remove an item from the room
     * @param name the nam of the item user wants to remove
     * @return the item that has been removed
    */
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

    /**
     * Print the items inside the room
     * @return the printing
     */
    public String printCollection(){
        String s = "The " + this.name + " now has:\n";
        for (Item i: this.itemCollection){
            s += "**" + i.getName() + "**\n";
        }
        return s;
    }

    /**
     * Add removeable items in another arraylist where the player pick up the items from
     * @return the collection of removable items
     */
    public ArrayList<Item> addMoveableItem(){
        for (Item i: this.itemCollection){
            if (i.canTake() == true){
                this.moveableItemCollection.add(i);
            }
        }
        return this.moveableItemCollection;
    }

    /**
     * Check if the user input is contained in the item collection of the room
     * @param userInput the user input
     * @return if the user input is in the item collection
     */
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

    /**
     * Printing of Room
     */
    public String toString(){
        return "Welcome! This is " + this.name + ".\n" + this.printCollection();
    }
    
}