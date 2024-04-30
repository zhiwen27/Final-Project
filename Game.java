import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

public class Game {

    ArrayList<House> mapAdv;
    MutableGraph<Tree> mapFarm;

    static Item apple = new Item("APPLE",5,true);
    static Item pear = new Item("PEAR", 10, true);
    static Tree appletree = new Tree(apple, true, 5, 0, "APPLE TREE", 5);
    static Tree peartree = new Tree (pear, true,5,0, "PEAR TREE", 10);

    /**
     * Constructor for Game
     */
    public Game(){
        this.mapAdv = new ArrayList<>();
        this.mapFarm = GraphBuilder.undirected().build();
    }

    /**
     * Printing of the map of the Adventure Mode
     */
    public String toString(){
        String s = "";
        for(House house: this.mapAdv){
            s += house;
        }
        return s;
    }

    /**
     * Create the map of the Adventure Mode
     * @return the map
     */
    public Game createNewAdv(){
        MainHouse mainHouse = new MainHouse();
        mainHouse.addFloor();
        this.mapAdv.add(mainHouse);
        return this;
    }

    /**
     * Go to the certain house on the map
     * @param houseNum the index of the house (default)
     * @return the house
     */
    public House mapTour(int houseNum){
        return this.mapAdv.get(houseNum);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to THE NEW WORLD!\n");
        try {
            File newFile = new File("Cheatsheet.md");
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
        System.out.println("Do you want to start the game?\n(*Please enter YES or No.)");
        Scanner sc = new Scanner(System.in);
        boolean startGame;
        String userInput = sc.nextLine().toUpperCase();
        if (userInput.contains("YES")){
            startGame = true;
            System.out.println("Great! Please create your account:\n(*Please only enter the name you want.)");
            userInput = sc.nextLine();
            Player newPlayer = new Player(userInput);
            String name = userInput;
            System.out.println("Account created! \nHi, " + userInput + "!");
            while(startGame){
                System.out.println("\n**********************************************************************************************************************************");
                try {
                    File newFile = new File("Start.txt");
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
                Oldman oldman = new Oldman(200);
                try{
                    boolean modeChoice = oldman.choice();
                    // Adventure Mode
                    if (modeChoice == false){
                        Game newGame = new Game().createNewAdv();
                        newPlayer.setHouse(newGame.mapTour(0));
                        System.out.println("\n**********************************************************************************************************************************");        
                        System.out.println("You're now in the Bedroom.");
                        newPlayer.setRoom(((MainHouse)newGame.mapTour(0)).goToFloor(1).activeRoom);
                        System.out.println("Feel free to explore!\n");
                        oldman.guideRoom(((MainHouse)newGame.mapTour(0)).goToFloor(1).activeRoom, newPlayer);
                        System.out.println("Now you have a feeling of what to do!\n\nHere are the list of rooms on the floor:");
                        System.out.println(((MainHouse)newGame.mapTour(0)).goToFloor(1));
                        boolean floorOver = false;
                        while(!floorOver){
                            try{
                                oldman.guideFloor(((MainHouse)newGame.mapTour(0)).goToFloor(1),newPlayer);
                                floorOver = ((MainHouse)newGame.mapTour(0)).goToFloor(1).floorOver();
                            } catch (RuntimeException e){
                                System.out.println(e.getMessage());
                            }
                        }
                        System.out.println("\nYou've now explored all the rooms on the second floor.\nTry explore other floors!\n");
                        try{
                            oldman.guideMainHouse(((MainHouse)newGame.mapTour(0)),newPlayer);
                        } catch(RuntimeException e){
                            System.out.println(e.getMessage());
                            oldman.guideMainHouse(((MainHouse)newGame.mapTour(0)),newPlayer);
                        }
                        boolean continueGame;
                        continueGame = oldman.guideCornerHouse(newGame,newPlayer);
                        if ((!continueGame) && (newPlayer.toPlay())){
                            startGame = false;
                        }
                        else if ((!continueGame) && (!newPlayer.toPlay())){
                            startGame = false;
                            System.out.println("Alright! You can come back any time you want!");
                        }
                        newPlayer = new Player(name);
                    }
                    // Farming Mode 
                    else if (modeChoice == true){
                        startGame = false;
                        System.out.println("\n**********************************************************************************************************************************");
                        newPlayer.farm.add(appletree);
                        appletree.numTrees += 1;
                        System.out.println("An APPLE TREE has been added your inventory, try plant it!\n(*Enter 'OPTIONS' for more informaiton.)");
                        Scanner choice = new Scanner (System.in);
                        String c = choice.nextLine().toLowerCase();
                        if (c.equals("options")){
                            appletree.options();
                            System.out.print("You can use 'PLANT' command to plant the tree. Try it!\n");
                            String o = choice.nextLine().toLowerCase();
                            if (o.equals("plant")){
                                newPlayer.plant(appletree);
                            }
                        }
                        else{
                            startGame = true;
                            throw new RuntimeException("Please enter the required word.\n");
                        }
                        /*if (c.equals("plant")){
                            newPlayer.plant(appletree);
                        }
                        if (c.equals("water")){
                            Scanner a = new Scanner(System.in);
                            System.out.println("Please enter the tree you want to water:");
                            String r = a.nextLine();
                            for (Tree tree:newPlayer.farm){
                                if (tree.name.equals(r)){
                                    tree.water();
                                }
                                else{
                                    System.out.println("Can you plant that first?");
                                }
                            }
                        }
                        if (c.equals("harvest")){
                            appletree.harvest();
                        }*/
                        System.out.println("\n\nOK, I guess you have learned how to take care of a tree now. Here is the last gift I can give you: You have received $50.\nMeanwhile, you can also sell your fruit to Old Man.\nRemember: MONEY WILL MAKE YOUR WAY OUT.\n(*Enter 'OPTIONS' if you still need help!)\n");
                        oldman.money -= 50;
                        while (oldman.money > 0){
                            if (oldman.money <= 120){
                                System.out.println("Old man: Actually, youngster, compared to APPLEs, I prefer PEARs.");
                                newPlayer.farm.add(peartree);
                                peartree.numTrees = 0;
                            }
                            System.out.println("Enter what you want to do next!");
                            String mov = choice.nextLine().toLowerCase();
                            switch(mov){
                                case "options":{
                                    System.out.println("Things you can do with a tree:\nPLANT\nWATER\nHARVEST\nSELL\n");
                                    System.out.println("Types of trees on the farm:\nAPPLE TREE; Fruit: APPLE\nPEAR TREE; Fruit: PEAR\n");
                                    break;
                                }
                                case "plant":{
                                    System.out.println("What kind of tree do you want to plant?");
                                    String foliage = choice.nextLine().toUpperCase();
                                    boolean haveTree = false;
                                    for (Tree i: newPlayer.farm){
                                        if (i.name.equals(foliage)){
                                            newPlayer.plant(i);
                                            haveTree = true;
                                            break;
                                        }
                                    }
                                    if (haveTree == false){
                                        System.out.print("You do not have that tree. Please enter the name of the tree you have.\n");
                                    }
                                    break;
                                }
                                case "water":{
                                    System.out.println("Please enter the tree you want to water:");
                                    String r = choice.nextLine().toUpperCase();
                                    boolean haveTree = false;
                                    for (Tree tree:newPlayer.farm){
                                        if (tree.name.equals(r)){
                                            tree.water();
                                            haveTree = true;
                                            break;
                                        }
                                    }
                                    if (haveTree == false){
                                        System.out.println("You cannot water it yet. Plant the tree first!");
                                    }
                                    break; 
                                }
                                case "harvest":{
                                    System.out.println("Which tree do you want to harvest?");
                                    String foliage = choice.nextLine().toUpperCase();
                                    boolean haveTree = false;
                                    boolean canHarvest;
                                    for (Tree leaf:newPlayer.farm){
                                        if (leaf.name.equals(foliage)){
                                            haveTree = true;
                                            canHarvest = leaf.harvest();
                                            if (canHarvest){
                                                Item fruit = leaf.fruit;
                                                Integer numFruit = leaf.numFruit;
                                                Integer numTrees = leaf.numTrees;
                                                Integer numFruitTotal = numFruit * numTrees;
                                                Integer numFruitOld = newPlayer.inventory.get(fruit);
                                                newPlayer.inventory.put(leaf.fruit, numFruitOld + numFruitTotal);
                                                break;
                                            }
                                        }
                                    }
                                    if (haveTree == false){       
                                        System.out.println("You cannot harvest it yet. Try plant it first!");
                                    }
                                    break;
                                }
                                case "sell":{
                                    System.out.println("Which fruit do you want to sell?");
                                    String item = choice.nextLine().toUpperCase();
                                    boolean haveFruit = false;
                                    for (Item sold:newPlayer.inventory.keySet()){
                                        if (sold.name.equals(item)){
                                            Integer a = newPlayer.sell(sold);
                                            oldman.buy(a);
                                            haveFruit = true;
                                            System.out.println("Old man: I have " + oldman.money + " dollars left. I am still rich!");
                                        }
                                    }
                                    if (haveFruit == false){
                                        System.out.println("Sorry, you don't have that fruit yet. Please enter the correct word.");
                                    }
                                    break;
                                }
                                case "inventory":{
                                    startGame = true;
                                    newPlayer.printInventory();
                                }
                            }
                        }
                    }
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }        
            }
            sc.close();
        }
        else{
            System.out.println("Alright! You can come back any time you want!");
        }
    }
}