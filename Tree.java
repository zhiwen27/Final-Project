import java.util.Scanner;

public class Tree extends Item{

    Item fruit;
    boolean live;
    Integer numFruit = 5;
    Integer numTrees = 0;

    public Tree(Item fruit,boolean live,Integer numFruit, Integer numTrees, String name, Integer value){
        super(name, value);
        this.fruit = fruit;
        this.live = live;
        this.fruit = fruit;
        this.numFruit = numFruit;
        this.numTrees = numTrees;
    }

    /** method for watering the tree
     * increase the number of fruit.
     */
    public void water(){
        System.out.println("GROWING......");
        numFruit += 5;
    }

    /**
     * control when the tree dies
     */
    public void sick(){
        System.out.println("NO! MAGGOT IS FOUND ON YOUR TREEEEEEEEEE!");
        numFruit -= 5;
        if (numFruit <= 0){
            live = false;
            System.out.println("In memory of all these trees, you lose one of the " + this.fruit.name.toLowerCase() + " tree.");
        }
    }

    /** harvest the fruits from the tree
     * @retrun whether the action is applicable
     */
    public boolean harvest(){
        System.out.println("Good job! You have " + numFruit + " " + this.fruit.name + " before you harvest!");
        if (numFruit >= 15){
            numFruit -= 10;
            System.out.println("Now you have " + numFruit + " " + this.fruit.name + " left on the tree!");
            return true;
        }
        else{
            System.out.println("Emmm, it is not the time for harvest. Try water it again.");
            Scanner r = new Scanner(System.in);
            String i = r.nextLine().toLowerCase();
            if (i.equals("water")){
                this.water();
            }else{
                this.sick();
                System.out.println("Now you have to water it.");
            }
            return false;
        }
    }

    /**
     * print out the methods contained in the 'tree' the class
     */
    public void options(){
         System.out.println("Things you can do with a tree:\nPLANT\nWATER\nHARVEST\nSELL\n\nSee what you could get!");
    }
}