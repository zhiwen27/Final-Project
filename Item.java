public class Item {

    private int value;
    public String name;
    private boolean canTake;

    /**
     * Default Constructor
     */
    public Item(){
        this("<Name Unknown>",0,true);
    }

    /**
     * Constructor for name and value of Item
     * @param name the name of Item
     * @param value the value of Item
     */
    public Item(String name, int value){
        this();
        this.name = name;
        this.value = value;
    }

    /**
     * Constructor for name of Item and indicate whether it can be taken
     * @param name the name of Item
     * @param canTake indicate whether Item can be taken
     */
    public Item(String name, boolean canTake){
        this();
        this.name = name;
        this.canTake = canTake;
    }

    /**
     * Full constructor for Item
     * @param name the name of Item
     * @param value the value of Item
     * @param canTake indicate whether Item can be taken
     */
    public Item(String name, int value, boolean canTake){
        this.name = name;
        this.value = value;
        this.canTake = canTake;
    }

    /**
     * Setter for value
     * @param v the value of Item
     */
    public void setValue(int v){
        this.value = v;
    }

    /**
     * Setter for name
     * @param n the name of Item
     */
    public void setName(String n){
        this.name = n;
    }

    /**
     * Getter for value
     * @return the value of Item
     */
    public int getValue(){
        return this.value;
    }

    /**
     * Getter for name
     * @return the name of Item
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter for canTake
     * @return whether Item can be taken
     */
    public boolean canTake(){
        return this.canTake;
    }

    /**
     * Setter for canTake
     * @param canTake whether Item can be taken
     */
    public void setCanTake(boolean canTake){
        this.canTake = canTake;
    }

    /**
     * Printing of Item
     */
    public String toString(){
        return "Great discovery! " + this.name + " is worth " + this.value + "!";
    }
}
