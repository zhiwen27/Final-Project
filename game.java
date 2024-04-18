import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

public class Game {

    ArrayList<House> mapAdv;
    MutableGraph<Tree> mapFarm;
    public Game(){
        this.mapAdv = new ArrayList<>();
        this.mapFarm = GraphBuilder.undirected().build();
    }

    public String toString(){
        String s = "";
        for(House house: this.mapAdv){
            s += house;
        }
        return s;
    }

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

    public static void main(String[] args) {
        System.out.println("Hi! Welcome to THE NEW WORLD! \n Do you want to start the game? \n (*Please type YES or No)");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine().toUpperCase();
        if (userInput.contains("YES")){
            System.out.println("Great! Please create your account: \n (*Please only type the name you want)");
            userInput = sc.nextLine();
            Player newPlayer = new Player(userInput);
            System.out.println("Account created! \n*****************************************************************");
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
                System.out.println("");
            if (oldman.choice() == true) {
                System.out.println("Okay, Lets plant an apple tree first!");
            }

            if (oldman.choice() == false){
                System.out.println("*****************************************************************");
                Game newGame = new Game().createNewAdv();
                newPlayer.setHouse(newGame.mapAdv.get(0));
                System.out.println(newGame.mapAdv.get(0));
            }
        }
        else{
            System.out.println("Alright! You can come back any time you want!");
        }

        sc.close();
    }
}