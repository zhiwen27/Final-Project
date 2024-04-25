import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Oldman {
    int money;

    public Oldman(Integer money){
        this.money = money;
    }  

    /**
     * Choose the Mode you want to explore: SEED for farming mode and return true; SWORD for adventure mode and return false
     * @return the Mode (indicate by the boolean) chosen
     */
    public boolean choice(){
        System.out.println("Old man: Hi, I am old man. \nYou don't have to know me. But tell me, which one do you want? \nSEED on the left or the SWORD on the right? (*Please type in the correct word.)");
        Scanner scanner = new Scanner(System.in);
        String choice;
        choice = scanner.nextLine().toLowerCase();
        if (choice.equalsIgnoreCase("seed")) {
            System.out.println("Old man: Last person made the same decision.");
            return true;
        }
        else if (choice.equalsIgnoreCase("sword")){
            System.out.println("Old man: That is a quite brave decision.\nExplore your journey with this sword, young man.");
            return false;
        }
        else{
            throw new RuntimeException("Please enter the required word.");
        }
    }
    /**buy items from the player
     * @param item item that the old man bus from the player
     */
    public void buy(Item item){
        money -= item.getValue();
        if (money > 0){
            if (item.getValue() >= 100){
                System.out.println("Old man: Wow, that would be quite expansive. \nCould it be ... whatever. ");
            } else{
                System.out.println("Old man: " + item.getValue() + "dollars ! That is the highest price I can offer.");
            }}else{
                System.out.println("Old man: I really, really, really like it. But I can't afford it.\nWait! I still have the keys! 4 keys for this! Is that a deal for you?");
            }        
    }

    /**
     * Checking if the user input matches the required word
     * @param userInput user input
     * @param requiredWord required word
     * @return if the user input matches the required word
     */
    public boolean checkInput(String userInput, String requiredWord){
        if (userInput.contains(requiredWord)){
            return true;
        }
        else{
            System.out.println("Please enter the required word.");
            return false;
        }
    }

    /**
     * Guide the player through certain room; must get all the can taken item in the room to leave; cannot go back
     * @param r the room
     * @param player the player
     */
    public void guideRoom(Room r, Player player){
        System.out.println("You can take anything that you can take from this room.");
        System.out.println(r.printCollection());
        Scanner scanner = new Scanner(System.in);
        String userInput;
        if(r.moveableItemCollection.isEmpty()){
            System.out.println("There's nothing left over in this room!\nTry to explore another room!");
        }
        while(!r.moveableItemCollection.isEmpty()){
            System.out.println("\n Discover those really valueable things! \n(*Please type in the name of the item.)");
            userInput = scanner.nextLine();
            try{
                r.checkItemInput(userInput);
                Item i = new Item();
                i = r.removeItem(userInput);
                player.grab(i);
            } catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Guide through certain floor
     * @param f the floor
     */
    public void guideFloor(Floor f, Player newPlayer){
        System.out.println("Please type in the name of the room you want to explore next!\n(*Please type in the correct word.)");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine();
        if (f.checkRoomInput(userInput)){
            this.guideRoom(f.goToRoom(f,userInput), newPlayer);
        }
        else{
            throw new RuntimeException("Please enter the required word.");
        }
    }

    /**
     * Guide through Main House
     * @param mainHouse Main House
     */
    public void guideMainHouse(MainHouse mainHouse, Player newPlayer){
        System.out.println(mainHouse);
        System.out.println("You can go up and down the rooms to explore the Main House. (*You can only go to adjacent floors. Please type in GO UP or GO DOWN.)");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine().toLowerCase();
        if (this.checkInput(userInput, "up")){
            mainHouse.goUpFloor();
            this.guideFloor(mainHouse.goToFloor(mainHouse.activeFloor), newPlayer);
            System.out.println("You've now explored all the rooms on the third floor!\nTry explore other floors you haven't been to!\n");
            System.out.println(mainHouse);
            System.out.println("Type in the floor number you want to go to.\n(*Please only type in a number.)");
            int floorNum;
            floorNum = scanner.nextInt();
            mainHouse.activeFloor = floorNum;
            System.out.println(mainHouse.goToFloor(floorNum - 1));
            this.guideFloor(mainHouse.goToFloor(floorNum - 1), newPlayer);
            System.out.println("You've now explored the entire Main House!");
            // check inventory and start new story
        }
        else if (this.checkInput(userInput, "down")){
            mainHouse.goDownFloor();
            this.guideFloor(mainHouse.goToFloor(mainHouse.activeFloor), newPlayer);
            System.out.println("You've now explored all the rooms on the first floor!\nTry explore other floors you haven't been to!\n");
            System.out.println(mainHouse);
            System.out.println("Type in the floor number you want to go to.\n(*Please only type in a number.)");
            int floorNum;
            floorNum = scanner.nextInt();
            mainHouse.activeFloor = floorNum;
            System.out.println(mainHouse.goToFloor(floorNum - 1));
            this.guideFloor(mainHouse.goToFloor(floorNum - 1), newPlayer);
            System.out.println();
            System.out.println("You've now explored the entire Main House!\n");
        }
    }

    /**
     * Guide through the Corner Houses
     * @param g the game where Corner Houses are added
     * @param p the player
     */
    public void guideCornerHouse(Game g, Player p){
        //boolean continueGame = true;
        try {
            File newFile = new File("Transition.txt");
            Scanner fileReader = new Scanner(newFile);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
            System.out.println("\n");
            fileReader.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        CornerHouse newCornerHouse = new CornerHouse();
        System.out.println("Welcome to the Corner House!");
        newCornerHouse.play(p);
        /*if (p.toPlay()){
            continueGame = false;
            return continueGame;
        }
        else{
            System.out.println("\nDear " + p.getName() + ", do you want to play another round?\n(*Please type in YES or NO)");
            Scanner scanner = new Scanner(System.in);
            String userInput;
            userInput = scanner.nextLine().toUpperCase();
            if (this.checkInput(userInput, "NO")){
                continueGame = false;
            }
            else if (this.checkInput(userInput, "YES")){
                continueGame = true;
            }
        }*/
    }
}
