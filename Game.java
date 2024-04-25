import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import java.util.Hashtable;

public class Game {

    ArrayList<House> mapAdv;
    MutableGraph<Tree> mapFarm;

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
    static Item apple = new Item("apple",5,true);
    static Item pear = new Item("pear", 10, true);
    static Item dimond = new Item ("dimond", 100, true);


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

    static Tree appletree = new Tree(apple, true, 5, 0, "apple tree", 5);
    static Tree peartree = new Tree (pear, true,5,0, "pear tree", 10);

    /**
     * Go to the certain house on the map
     * @param houseNum the index of the house (default)
     * @return the house
     */
    public House mapTour(int houseNum){
        return this.mapAdv.get(houseNum);
    }

    public void playAdv(){
        
    }

    public static void main(String[] args) {
        System.out.println("Hi! Welcome to THE NEW WORLD! \n Do you want to start the game? \n (*Please type YES or No)");
        //boolean startGame = true;
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine().toUpperCase();
        if (userInput.contains("YES")){
            System.out.println("Great! Please create your account: \n (*Please only type the name you want)");
            userInput = sc.nextLine();
            Player newPlayer = new Player(userInput);
            System.out.println("Account created! \nHi, " + userInput + "!\n\n*****************************************************************");
            try {
                File newFile = new File("Start.txt");
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
            Oldman oldman = new Oldman(200);
            try{
                boolean modeChoice = oldman.choice();
                System.out.println("\n");
                if (modeChoice == false){
                    System.out.println("*****************************************************************");
                    Game newGame = new Game().createNewAdv();
                    newPlayer.setHouse(newGame.mapTour(0));
                    System.out.println("You're now in the Bedroom.");
                    newPlayer.setRoom(((MainHouse)newGame.mapTour(0)).goToFloor(1).activeRoom);
                    System.out.println("Feel free to explore!");
                    oldman.guideRoom(((MainHouse)newGame.mapTour(0)).goToFloor(1).activeRoom, newPlayer);
                    System.out.println("Now you have a feeling of what to do!\n\nHere are the list of rooms on the floor:");
                    System.out.println(((MainHouse)newGame.mapTour(0)).goToFloor(1));
                    boolean floorOver = false;
                    while(!floorOver){
                        oldman.guideFloor(((MainHouse)newGame.mapTour(0)).goToFloor(1),newPlayer);
                        floorOver = ((MainHouse)newGame.mapTour(0)).goToFloor(1).floorOver();
                    }
                    System.out.println("Do you want to see want you have discovered so far?\n(*Please type in YES or NO)");
                    userInput = sc.nextLine().toUpperCase();
                    if (userInput.contains("YES")){
                       newPlayer.printInventory();
                    }
                    else if (userInput.contains("NO")){
                        System.out.println("Alright, save it for the next time!\n");
                    }
                    System.out.println("You've now explored all the rooms on the second floor.\nTry explore other floors!\n");
                    oldman.guideMainHouse(((MainHouse)newGame.mapTour(0)),newPlayer);
                    oldman.guideCornerHouse(newGame,newPlayer);
                    try {
                        File newFile = new File("End.txt");
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
                    //startGame = false;
                    /*else{
                        System.out.println("Do you want to start again?");
                        //startGame = true;
                    }*/
                }
                else if (modeChoice == true){
                    newPlayer.farm.add(appletree);
                    appletree.number_of_trees += 1;
                    System.out.println("An apple tree has been added your inventory, try to plant it!\n(*Type in 'options' for more informaiton.)");
                    Scanner choice = new Scanner (System.in);
                    String c = choice. nextLine();
                    if (c.equals("options")){
                        appletree .options();
                        System.out.print("You can use 'plant'command to plant the tree. Try it!");
                        Scanner p = new Scanner(System.in);
                        String o = p.nextLine();
                        if (o.equals("plant")){
                            newPlayer.plant(appletree);
                        }
                    }
                    if (c.equals("plant")){
                        newPlayer.plant(appletree);
                    }
                    if (c.equals("water")){
                        Scanner a = new Scanner(System.in);
                        System.out.println("Please enter the tree you want to water:");
                        String r = a.nextLine();
                        for (Tree tree:newPlayer.farm){
                            if (tree.name.equals(a)){
                                tree.water();
                            }
                            else{
                                System.out.println("Can you plant that first?");
                            }
                        }
                    }
                    if (c.equals("harvest")){
                        appletree.harvest();
                    }
                    System.out.println("\n\nOK, I guess you have learned how to take care of a tree now. Here is the last gift I can give you.\nYou have received 50 dollars. MONEY WILL MAKE YOUR WAY OUT.\nYou can also sell your fruit to him. ");
                    oldman.money -= 50;
                    while (oldman.money > 0){
                        Scanner Move = new Scanner(System.in);
                        String move = Move.nextLine();
                        System.out.println("which move do you want to do next? \n Enter 'options' for more information");
                        if (move.equals("options")){
                            System.out.println("Things you can do with a tree:\n water it \n harvest it \n its fruits can be sold to the oldman. See what we would get!");
                        }
                        if (move.equals("plant")){
                            System.out.println("What kind of tree do you want to plant?");
                            Scanner tree = new Scanner(System.in);
                            String foliage = tree.nextLine();
                            for (Tree i: newPlayer.farm){
                                if (i.name.equals(foliage)){
                                    newPlayer.plant(i);
                                }
                                else{
                                    System.out.print("You do not have that tree. You can get different kinds of plants from the old man.");
                                }
                            }
                        }
                        if (move.equals("water")){
                            Scanner a = new Scanner(System.in);
                            System.out.println("Please enter the tree you want to water:");
                            String r = a.nextLine();
                            for (Tree tree:newPlayer.farm){
                                if (tree.fruit.name.equals(r)){
                                    tree.water();
                                }
                                else{
                                    System.out.println("Can you plant that first?");
                                }
                            }
                        }
                        if (move.equals("harvest")){
                            System.out.println("which tree do you want to harvest?");
                            Scanner tree = new Scanner(System.in);
                            String foliage = tree.nextLine();
                            for (Tree leaf:newPlayer.farm){
                                if (leaf.name.equals(foliage)){
                                    Boolean b = leaf.harvest();
                                    if (b){
                                        Integer a = leaf.number_of_fruit;
                                        Integer d = leaf.number_of_trees;
                                        Integer e = a * d;
                                        Integer f = newPlayer.inventory.get(leaf);
                                        newPlayer.inventory.put(leaf.fruit, f + e);
                                    }
                                }
                                else{                  
                                    System.out.println("Can you plant that first?");
                                }
                            }
                        }
                        System.out.println("\n\nOK, I guess you have learned how to take care of a tree now. Here is the last gift I can give you.\nYou have received 50 dollars. MONEY WILL MAKE YOUR WAY OUT.\nYou can also sell your fruit to him.\n click 'Enter' on your keyboard to start");
                        oldman.money -= 50;
                        while (oldman.money > 0){
                            Scanner Mov = new Scanner(System.in);
                            String mov = Mov.nextLine();
                            if (mov.equalsIgnoreCase("options")){
                                System.out.println("Things you can do with a tree:\n water it \n harvest it \n its fruits can be sold to the oldman. See what we would get!");
                            }
                            if (mov.equals("plant")){
                                System.out.println("What kind of tree do you want to plant?");
                                Scanner tree = new Scanner(System.in);
                                String foliage = tree.nextLine();
                                for (Tree i: newPlayer.farm){
                                    if (i.name.equals(foliage)){
                                        newPlayer.plant(i);
                                    }
                                    else{
                                        System.out.print("You do not have that tree. You can get different kinds of plants from the old man.");
                                    }
                                }
                            }
                            if (mov.equalsIgnoreCase("water")){
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
                            if (mov.equalsIgnoreCase("harvest")){
                                System.out.println("which tree do you want to harvest?");
                                Scanner tree = new Scanner(System.in);
                                String foliage = tree.nextLine();
                                for (Tree leaf:newPlayer.farm){
                                    if (leaf.name.equals(foliage)){
                                        Boolean b = leaf.harvest();
                                        if (b){
                                            Item t = leaf.fruit;
                                            Integer a = leaf.number_of_fruit;
                                            Integer d = leaf.number_of_trees;
                                            Integer e = a * d;
                                            Integer f = newPlayer.inventory.get(t);
                                            newPlayer.inventory.put(leaf.fruit, f + e);
                                        }
                                    }
                                    else{                  
                                        System.out.println("Can you plant that first?");
                                    }
                                }
                            }
                            if (mov.equalsIgnoreCase("sell")){
                                System.out.println("What do you want to sell?");
                                Scanner thing = new Scanner(System.in);
                                String item = thing.nextLine();
                                for (Item sold:newPlayer.inventory.keySet()){
                                    if (sold.name.equals(item)){
                                        Integer a = newPlayer.sell(sold);
                                        oldman.buy(sold);
                                        System.out.println("Old man: I still have " + oldman.money + " dollars left. I am still rich");
                                    }
                                }
                            }
                            else{
                                System.out.println("I can't hear you, could you say that again?");
                            }
                            }
                            if (oldman.money == 120 ){
                                System.out.println("Old man: Actually, youngster, compared to apple, I prefer pears.");
                                newPlayer.farm.add(peartree);
                                peartree.number_of_trees = 0;
                            } 
                        } 
                    }
                
            } catch(Exception e){
                System.out.println(e.getMessage());
            }        
            sc.close();}
        
        else{
            System.out.println("Alright! You can come back any time you want!");
            //startGame = false
        }
    }}