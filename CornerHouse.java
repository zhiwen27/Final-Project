import javax.print.DocFlavor.STRING;

import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class CornerHouse extends House{

    int randomNum;
    int chances;

    public CornerHouse(){
        super();
        this.chances = 7;
    }

    public CornerHouse(String n){
        super(n);
        this.chances = 7;
    }

    public int randomNum(){
        Random random = new Random();
        int randomNum = random.nextInt(100);
        return randomNum;
    }

    public void createRandomNum(){
        this.randomNum = this.randomNum();
    }

    public boolean checkChances(){
        return this.chances > 0;
    }

    public boolean checkAnswer(int i){
        this.chances -= 1;
        if (i == this.randomNum){
            System.out.println( "Right Guess!");
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

    public void play(){
        this.createRandomNum();
        Scanner sc = new Scanner(System.in);
        boolean play = false;
        while((this.checkChances()) && (!play)){
            System.out.println("Please type in a guess between 1 and 100:");
            int guess = sc.nextInt();
            play = this.checkAnswer(guess);
        }
        if (!play){
            System.out.println("GAME OVER!");
        }
    }

    public String toString(){
        return "Welcome to " + this.name + "!\n";
    }
}
