public class Tree {
    String type;
    boolean live;
    Integer fruit = 5;
    public Tree(String type,boolean live,Integer fruit){
        this.type = type;
        this.live = live;
        this.fruit = fruit;
        System.out.println("you have planted a " + type + " tree");
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
            System.out.println("emmmmmmm, It is not the time for harvest. Water it again.");
            return false;
        }
    }
public static void main(String[] args) {

}}
