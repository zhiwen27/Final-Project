import java.util.Scanner;
public class Oldman {
    int money;

    public Oldman(Integer money){
        this.money = money;
    }  

    public boolean choice(){
        System.out.println("Hi, I am old man. \nYou don't have to know me. But tell me, which one do you want? \nSEED on the left or the SWORD on the right?");
        Scanner scanner = new Scanner(System.in);
        String choice;
        choice = scanner.nextLine().toLowerCase();
        while(this.checkInput(choice, "seed") || (this.checkInput(choice, "sword"))){
            if (choice.equalsIgnoreCase("seed")) {
                System.out.println("Last person made the same decision.");
                return true;
            }else if (choice.equalsIgnoreCase("sword")){
                System.out.println("That is a quite brave decision.\nExplore your journey with this sword, young man.");
                return false;
            }
        }
        throw new RuntimeException("Please enter the required word.");
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

    public boolean checkInput(String userInput, String requiredWord){
        if (userInput.contains(requiredWord)){
            return true;
        }
        else{
            System.out.println("Please enter the required word.");
            return false;
        }
    }

    public Room guideRoom(Room r, Player player){
        System.out.println("You can take anything that you can take from this room.");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine().toLowerCase();
        while(!r.itemCollection.isEmpty()){
            System.out.println("\n Discover those really valueable things! \n(*Please type in the name of the item.)");
            try{
                r.checkItemInput(userInput);
                r.removeItem(userInput);
                player.grab(r.removeItem(userInput));
            } catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        return r;
    }

    public Floor guideFloor(Floor f){
        System.out.println("Please tell me which room you want to explore next.");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine().toLowerCase();
        f.goToRoom(userInput);
        return f;
    }

    public MainHouse guideMainHouse(MainHouse mainHouse){
        System.out.println("You can go up and down the rooms to explore the Main House. (*You can only go to adjacent floors. Please type in GO UP or GO DOWN.)");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine().toLowerCase();
        if (this.checkInput(userInput, "up")){
            mainHouse.goUpFloor();
        }
        else if (this.checkInput(userInput, "down")){
            mainHouse.goDownFloor();
        }
        return mainHouse;
    }
}