import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

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

    /**
     * Create the map of the Adventure Mode
     * @return the map
     */
    public Game createNewAdv(){
        MainHouse mainHouse = new MainHouse();
        mainHouse.addFloor();
        CornerHouse northWest = new CornerHouse("NorthWest House");
        CornerHouse northEast = new CornerHouse("NorthEast House");
        CornerHouse southWest = new CornerHouse("SouthWest House");
        CornerHouse southEast = new CornerHouse("SouthEast House");
        this.mapAdv.add(mainHouse);
        this.mapAdv.add(southEast);
        this.mapAdv.add(southWest);
        this.mapAdv.add(northEast);
        this.mapAdv.add(northWest);
        return this;
    }

    static Tree appletree = new Tree("apple", true, 5);
    static Tree peartree = new Tree("pear", true, 5);
    static Tree grapetree = new Tree("grape", true, 5);
    static Tree bananatree = new Tree("banana", true, 5);

    /**
     * Go to the certain house on the map
     * @param houseNum the index of the house (default)
     * @return the house
     */
    public House mapTour(int houseNum){
        return this.mapAdv.get(houseNum);
    }

    public static void main(String[] args) {
        System.out.println("Hi! Welcome to THE NEW WORLD! \n Do you want to start the game? \n (*Please type YES or No)");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine().toUpperCase();
        if (userInput.contains("YES")){
            System.out.println("Great! Please create your account: \n (*Please only type the name you want)");
            userInput = sc.nextLine();
            Player newPlayer = new Player(userInput);
            System.out.println("Account created! \nHi, " + userInput + "!\n*****************************************************************");
            try {
                File newFile = new File("Start.txt");
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
            Oldman oldman = new Oldman(1000000000);
            try{
                boolean modeChoice = oldman.choice();
                if (modeChoice == false){
                    System.out.println("*****************************************************************");
                    Game newGame = new Game().createNewAdv();
                    newPlayer.setHouse(newGame.mapTour(0));
                    System.out.println("You're now in the Bedroom.");
                    newPlayer.setRoom(((MainHouse)newGame.mapTour(0)).goToFloor(1).activeRoom);
                    System.out.println(newPlayer.getRoom());
                    System.out.println("Feel free to explore!");
                    oldman.guideRoom(((MainHouse)newGame.mapTour(0)).goToFloor(1).activeRoom,newPlayer);
                }
                else if (modeChoice == true){
                    newPlayer.inventory.put(peartree, 1);
                    System.out.println("An apple tree has been added your inventory, try to plant it!\n(*Type in 'options' for more informaiton.)");
                    Scanner choice = new Scanner (System.in);
                    String c = choice. nextLine();
                    if (c.equals("options")){
                        peartree .options();
                    }
                    if (c.equals("plant")){
                        newPlayer.plant(peartree);
                    }
                    choice.close();
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("Alright! You can come back any time you want!");
        }
        sc.close();
    }
}