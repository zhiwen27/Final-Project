import java.util.Scanner;

public class Tree extends Item{

    Item fruit;
    boolean live;
    Integer number_of_fruit = 5;
    Integer number_of_trees = 0;

    public Tree(Item fruit,boolean live,Integer number_of_fruit, Integer number_of_trees, String name, Integer value){
        super(name, value);
        this.fruit = fruit;
        this.live = live;
        this.fruit = fruit;
        this.number_of_fruit = number_of_fruit;
        this.number_of_trees = number_of_trees;
    }

    /** method for watering the tree
     * increase the number of fruit.
     */
    public void water(){
        System.out.println("GROWING.........");
        number_of_fruit += 5;
    }

    /**
     * control when the tree dies
     */
    public void sick(){
        System.out.println("NO!MAGGOT IS FOUND ON YOUR TREEEEEEEEEE");
        number_of_fruit -= 5;
        if (number_of_fruit <= 0){
            live = false;
            System.out.println("In memory of all these trees, you lose one of the " + this.fruit.name + "tree.");
        }
    }

    /** harvest the fruits from the tree
     * @retrun whether the action is applicable
     */
    public boolean harvest(){
        if (number_of_fruit >= 15){
            number_of_fruit -= 10;
            System.out.println("There are " + fruit + " " + this.fruit.name + "s left ");
            return true;
        }
        else{
            System.out.println("emmmmmmm, It is not the time for harvest. Try water it again.");
            Scanner r = new Scanner(System.in);
            String i = r.nextLine();
            if (i.equals("water")){
                this.water();
            }else{
                this.sick();
                System.out.println("now you have to water it.");
            }
            return false;
        }
    }

    /**
     * print out the methods contained in the 'tree' the class
     */
    public void options(){
         System.out.println("Things you can do with a tree:\n water it \n harvest it \n its fruits can be sold to the oldman. See what we would get!");
    }
}