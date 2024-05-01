import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oldman {
    int money;

    /**
     * Constructor for Oldman
     * @param money
     */
    public Oldman(Integer money){
        this.money = money;
        
    }  

    /**
     * Choose the Mode you want to explore: SEED for farming mode and return true; SWORD for adventure mode and return false
     * @return the Mode (indicate by the boolean) chosen
     */
    public boolean choice(){
        System.out.println("Old man: Hi, I am old man. \nYou don't have to know me. But tell me, which one do you want? \nSEED on the left or the SWORD on the right? (*Please enter the correct word.)");
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
    
    /**
     * Buy items from the player
     * @param item item that the old man bus from the player
     * @return if the player win the game
     */
    public boolean buy(Integer a){
        if (money > a){
            money -= a;
            System.out.println("I have enough fortune to buy this");
            return true;
        }else{
            System.out.println("Old man: I really, really, really like it. But I can't afford it.\nWait! I still have the keys! 4 keys for this! Here you are!");
            System.out.println("\n**********************************************************************************************************************************");
            try {
                File newFile = new File("End2.txt");
                Scanner fileReader = new Scanner(newFile);
                while (fileReader.hasNextLine()) {
                    String data = fileReader.nextLine();
                    System.out.println(data);
                }
                System.out.println();
                fileReader.close(); 
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return false;
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
        System.out.println("You can take anything you can take from this room.");
        System.out.println(r.printCollection());
        Scanner scanner = new Scanner(System.in);
        String userInput;
        if(r.moveableItemCollection.isEmpty()){
            System.out.println("There's nothing left over in this room! Try explore another room!");
        }
        while(!r.moveableItemCollection.isEmpty()){
            System.out.println("\nDiscover those really valueable things! \n(*Please enter the name of the item.)");
            userInput = scanner.nextLine().toUpperCase();
            if(userInput.contains("INVENTORY")){
                    player.printInventory();
            }
            else{
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
    }

    /**
     * Guide through certain floor
     * @param f the floor
     */
    public void guideFloor(Floor f, Player newPlayer){
        System.out.println("\nPlease enter the name of the room you want to explore next!\n(*Please enter the correct word.)");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine().toUpperCase();
        if (userInput.contains("INVENTORY")){
            newPlayer.printInventory();
            System.out.println("Please enter the name of the room you want to explore next!\n(*Please enter the correct word.)");
            userInput = scanner.nextLine().toUpperCase();
            if (f.checkRoomInput(userInput)){
                this.guideRoom(f.goToRoom(f,userInput), newPlayer);
            }
            else{
                throw new RuntimeException("Please enter the required word.");
            }
        }
        else{
            if (f.checkRoomInput(userInput)){
                this.guideRoom(f.goToRoom(f,userInput), newPlayer);
            }
            else{
                throw new RuntimeException("Please enter the required word.");
            }
        }
    }

    /**
     * Guide through Main House
     * @param mainHouse Main House
     */
    public void guideMainHouse(MainHouse mainHouse, Player newPlayer){
        System.out.println(mainHouse);
        System.out.println("You can go up and down the rooms to explore the Main House.\n(*You can only go to adjacent floors. Please enter GO UP or GO DOWN.)");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine().toUpperCase();
        if (userInput.contains("UP")){
            mainHouse.goUpFloor();
            this.guideFloor(mainHouse.goToFloor(mainHouse.activeFloor), newPlayer);
            System.out.println("You've now explored all the rooms on the third floor! Try explore other floors you haven't been to!");
            System.out.println(mainHouse);
            System.out.println("Enter the floor number you want to go to.\n(*Please only enter a number between 1-3.)");
            int floorNum;
            floorNum = scanner.nextInt();
            while(floorNum != 1){
                if(floorNum == 3){
                    for (Room r: mainHouse.goToFloor(floorNum - 1).rooms){
                        System.out.println(r.printCollection());
                        System.out.println("There's nothing left over on this floor! Try explore another floor!");
                    }
                    System.out.println("Enter the floor number you want to go to.\n(*Please only enter a number between 1-3.)");
                    floorNum = scanner.nextInt();
                }
                else if(floorNum == 2){
                    for (Room r: mainHouse.goToFloor(floorNum - 1).rooms){
                        System.out.println(r.printCollection());
                        System.out.println("There's nothing left over on this floor! Try explore another floor!");
                    }
                    System.out.println("Enter the floor number you want to go to.\n(*Please only enter a number between 1-3.)");
                    floorNum = scanner.nextInt();
                }
                else{
                    System.out.println("Please only enter a number between 1-3.");
                    floorNum = scanner.nextInt();
                }
            }
            mainHouse.activeFloor = floorNum;
            System.out.println("Floor " + floorNum + " has:\n" + mainHouse.goToFloor(floorNum - 1));
            this.guideFloor(mainHouse.goToFloor(floorNum - 1), newPlayer);
            System.out.println("\nYou've now explored the entire Main House!");
            System.out.println("Do you want to see want you have discovered so far?\n(*Please enter YES or NO)");
            scanner.nextLine();
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.contains("YES")){
               newPlayer.printInventory();
            }
            else if (userInput.contains("NO")){
                System.out.println("Alright, save it for the next time!");
            }
        }
        else if (userInput.contains("DOWN")){
            mainHouse.goDownFloor();
            this.guideFloor(mainHouse.goToFloor(mainHouse.activeFloor), newPlayer);
            System.out.println("You've now explored all the rooms on the first floor! Try explore other floors you haven't been to!");
            System.out.println(mainHouse);
            System.out.println("Enter the floor number you want.\n(*Please only enter a number between 1-3.)");
            int floorNum;
            floorNum = scanner.nextInt();
            while(floorNum != 3){
                if(floorNum == 1){
                    for (Room r: mainHouse.goToFloor(floorNum).rooms){
                        System.out.println(r.printCollection());
                        System.out.println("There's nothing left over on this floor! Try explore another floor!");
                    }
                    System.out.println("Enter the floor number you want to go to.\n(*Please only enter a number between 1-3.)");
                    floorNum = scanner.nextInt();
                }
                else if(floorNum == 2){
                    for (Room r: mainHouse.goToFloor(floorNum).rooms){
                        System.out.println(r.printCollection());
                        System.out.println("There's nothing left over on this floor! Try explore another floor!");
                    }
                    System.out.println("Enter the floor number you want.\n(*Please only enter a number between 1-3.)");
                    floorNum = scanner.nextInt();
                }
                else{
                    System.out.println("Please only enter a number between 1-3.");
                    floorNum = scanner.nextInt();
                }
            }
            mainHouse.activeFloor = floorNum;
            System.out.println("Floor " + floorNum + " has:\n" + mainHouse.goToFloor(floorNum - 1));
            this.guideFloor(mainHouse.goToFloor(floorNum - 1), newPlayer);
            System.out.println();
            System.out.println("\nYou've now explored the entire Main House!");
            System.out.println("Do you want to see want you have discovered so far?\n(*Please enter YES or NO)");
            scanner.nextLine();
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.contains("YES")){
               newPlayer.printInventory();
            }
            else if (userInput.contains("NO")){
                System.out.println("Alright, save it for the next time!");
            }
        }
        else{
            throw new RuntimeException("Please enter the required word.\n");
        }
    }

    /**
     * Guide through the Corner House
     * @param g the game where Corner Houses are added
     * @param p the player
     */
    public boolean guideCornerHouse(Game g, Player p){
        boolean continueGame = true;
        System.out.println("\n**********************************************************************************************************************************");
        try {
            File newFile = new File("Transition.txt");
            Scanner fileReader = new Scanner(newFile);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
            fileReader.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("\n**********************************************************************************************************************************");
        CornerHouse newCornerHouse = new CornerHouse();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Corner House!");
        newCornerHouse.play(p);
        String userInput;
        if(p.toPlay()){
            System.out.println("Do you want to see want you have discovered so far?\n(*Please enter YES or NO)");
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.contains("YES")){
                p.printInventory();
            }
            else if (userInput.contains("NO")){
                System.out.println("Alright!");
            }
            System.out.println("\n**********************************************************************************************************************************");
            try {
                File newFile = new File("End.txt");
                Scanner fileReader = new Scanner(newFile);
                while (fileReader.hasNextLine()) {
                    String data = fileReader.nextLine();
                    System.out.println(data);
                }
                fileReader.close(); 
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println("**********************************************************************************************************************************\n");
            continueGame = false;
        }
        else{
            System.out.println("Sorry, " + p.getName() + ". Do you want to play another round?\n(*Please enter YES or No)");
            userInput = scanner.nextLine().toUpperCase();
            if(userInput.contains("NO")){
                continueGame = false;
            }
        }
        return continueGame;
    }
}