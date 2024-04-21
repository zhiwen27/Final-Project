import java.util.ArrayList;

public class MainHouse extends House{
    private ArrayList<Floor> floors;
    private int floor;
    int activeFloor;

    /**
     * Constructor for MainHouse: set name to be "Main House" with 3 floors
     */
    public MainHouse(){
        super("Main House");
        this.floor = 3;
        this.floors = new ArrayList<>(this.floor);
    }

    /**
     * Add all the floors into Main House
     */
    public void addFloor(){
        Floor groundFloor = new Floor().addGoundFloor();
        Floor firstFloor = new Floor().addFirstFloor();
        Floor secondFloor = new Floor().addSecondFloor();
        this.floors.add(groundFloor);
        this.floors.add(firstFloor);
        this.floors.add(secondFloor);
    }

    /**
     * Print out certain floor
     * @param floorNum the floor you want to go to
     */
    public void floorTour(int floorNum){
        System.out.println(this.floors.get(floorNum));
    }

    /**
     * Go to certain floor
     * @param floorNum the floor you want to go to
     * @return the floor
     */
    public Floor goToFloor(int floorNum){
        return this.floors.get(floorNum);
    }

    /**
     * Go up 1 floor and print out the floor
     */
    public void goUpFloor(){
        this.activeFloor += 1;
        System.out.println("You're now at Floor " + this.activeFloor + ".");
        floorTour(this.activeFloor);
    }

    /**
     * Go down 1 floor and print out the floor
     */
    public void goDownFloor(){
        this.activeFloor -= 1;
        System.out.println("You're now at Floor " + this.activeFloor + ".");
        floorTour(this.activeFloor);
    }

    /**
     * Create the Main House
     * @return the Main House
     */
    public MainHouse addMainHouse(){
        MainHouse mainHouse = new MainHouse();
        mainHouse.activeFloor = 2;
        mainHouse.addFloor();
        return mainHouse;
    }

    /**
     * Printing for floor
     */
    public String toString(){
        String printer = "Welcome to the Main House! \nYou're now at Floor 1.";
        for(Floor floor: this.floors){
            printer += floor;
        }
        return printer;
    }
}