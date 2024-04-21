public class Tree extends Item{
    String type;
    boolean live;
    Integer fruit = 5;
    public Tree(String type,boolean live,Integer fruit){
        this.type = type;
        this.live = live;
        this.fruit = fruit;
    }
    public void water(){
        System.out.println("GROWING.........");
        fruit += 5;
    }
    public void sick(){
        System.out.println("NO!MAGGOT IS FOUND ON YOUR TREEEEEEEEEE");
        fruit -= 5;
        if (fruit <= 0){
            live = false;
            System.out.println("In memory of all these trees, you lose one of the " + this.type + "tree.");
        }}
    public boolean harvest(){
        if (fruit >= 15){
            fruit -= 10;
            System.out.println("There are " + fruit + " " + type + "s left ");
            return true;
        }
        else{
            System.out.println("emmmmmmm, It is not the time for harvest. Try water it again.");
            return false;
        }
    }
    public void options(){
         System.out.println("Things you can do with a tree:\n water it \n harvest it \n its fruits can be sold to the oldman. See what we would get!");
    }
    }
