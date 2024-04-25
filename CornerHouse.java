import java.util.Random;
import java.util.Scanner;

public class CornerHouse extends House{

    int randomNum;
    int chances;

    /**
     * Default Constructor
     */
    public CornerHouse(){
        super();
        this.chances = 7;
    }
    
    /**
     * Create a random number each time
     * @return the random number
     */
    public int randomNum(){
        Random random = new Random();
        int randomNum = random.nextInt(1,101);
        return randomNum;
    }

    /**
     * Create a random number for the game
     */
    public void createRandomNum(){
        this.randomNum = this.randomNum();
    }

    /**
     * Check if chances are used up
     * @return if chances are used up
     */
    public boolean checkChances(){
        return this.chances > 0;
    }

    /**
     * Check the guess with the answer
     * @param i the number the user type in
     * @return if the guess is bigger or smaller than the answer
     */
    public boolean checkAnswer(int i){
        this.chances -= 1;
        if (i == this.randomNum){
            System.out.println( "Right Guess!\n");
            return true;
        }
        else{
            if (i > this.randomNum){
                System.out.println("The guess is bigger than the answer.");
                return false;
            }
            else{
                System.out.println("The guess is smaller than the answer.");
                return false;
            }
        }
    }

    /**
     * Function to get one round of play for the CornerHosue
     */
    public Player play(Player p){
        this.createRandomNum();
        Scanner sc = new Scanner(System.in);
        Item key = new Item("Key",500);
        boolean play = false;
        while((this.checkChances()) && (!play)){
            System.out.println("Please type in a guess between 1 and 100:");
            int guess = sc.nextInt();
            play = this.checkAnswer(guess);
        }
        if (!play){
            System.out.println("GAME OVER!");
            p.setToPlay(false);
        }
        else{
            p.grab(key);
        }
        sc.close();
        return p;
    }

    /**
     * Printing of CornerHouse
     */
    public String toString(){
        return "Welcome to " + this.name + "!\n";
    }
}
