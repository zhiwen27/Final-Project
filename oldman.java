import java.util.Scanner;
public class Oldman {
    int money;
    String choice;
    public Oldman(Integer money){
        this.money = money;
        this.choice = choice;
    }  

    public boolean choice(){
        System.out.println("Hi, I am old man. \nYou don't have to know me. But tell me, which do you want? \nSEED on the left or the SWORD on the right?");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextLine().toLowerCase();
        while (!(choice.equalsIgnoreCase("seed") || choice.equalsIgnoreCase("sword"))) {
            System.out.println("Are you playing me as a fool, little pickle?\nI would give you another chance. MAKE YOUR DECISION");
            Scanner s = new Scanner(System.in);
            choice = s.nextLine();
        }if (choice.equalsIgnoreCase("seed")) {
            System.out.println("Last person made the same decision.");
            return true;
        }if (choice.equalsIgnoreCase("sword")) {
            System.out.println("That is a quite brave decision.\nExplore your journey with this sword, young man.");
            return false;
        }
        return false;
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
}