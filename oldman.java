import java.util.Scanner;
public class oldman {
    int money;
    String choice;
    public oldman(Integer money){
        this.money = money;
        this.choice = choice;
    }  

    public void choice(){
        System.out.println("Hi, I am old man. \nYou don't have to know me. But tell me, which do you want? \nSeed on the left or the sword on the right?");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextLine();

        while (!(choice.equalsIgnoreCase("seed") || choice.equalsIgnoreCase("sword"))) {
            System.out.println("Are you playing me as a fool, little pickle?\nI would give you another chance. MAKE YOUR DECISION");
            Scanner s = new Scanner(System.in);
            choice = s.nextLine();
        }if (choice.equalsIgnoreCase("seed")) {
            System.out.println("Last person made the same decision.");
        }if (choice.equalsIgnoreCase("sword")) {
            System.out.println("That is a quite brave decision.\nExplore your journey with this sword, young man.");}
        }


    public void buy(Item item){
        money -= item.getValue();
        if (money > 0){
            if (item.getValue() >= 100){
                System.out.println("Wow, that would be quite expansive. \nCould it be ... whatever. ");
            } else{
                System.out.println(item.getValue() + "dollars ! That is the highest price I can offer.");
            }}else{
                System.out.println("I really, really, really like it. But I can't afford it.\nWait! I still have the keys! 4 keys for this! Is that a deal for you?");
            }        
    }
    public static void main(String[] args) {
        oldman Hagrid = new oldman(100);
        Hagrid.buy(new Item("Gold", 80384));
    }
}