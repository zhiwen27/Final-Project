import java.util.Hashtable;
import java.util.ArrayList;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;
public class MainHouse extends House{
    private ArrayList<Floor> floors;
    private int floor;
    private int activeFloor = 1;
    public MainHouse(){
        super("Main House");
        this.floor = 3;
        this.floors = new ArrayList<>(this.floor);
    }

    public void addFloor(){
        Floor groundFloor = new Floor().addGoundFloor();
        Floor firstFloor = new Floor().addFirstFloor();
        Floor secondFloor = new Floor().addSecondFloor();
        this.floors.add(groundFloor);
        this.floors.add(firstFloor);
        this.floors.add(secondFloor);
    }

    public void floorTour(int floorNum){
        System.out.println(this.floors.get(floorNum));
    }

    public void goUpFloor(){
        this.activeFloor += 1;
        System.out.println("You're now at Floor " + this.activeFloor + ".");
        floorTour(this.activeFloor);
    }

    public void goDownFloor(){
        this.activeFloor -= 1;
        System.out.println("You're now at Floor " + this.activeFloor + ".");
        floorTour(this.activeFloor);
    }

    public MainHouse addMainHouse(){
        MainHouse mainHouse = new MainHouse();
        mainHouse.addFloor();
        return mainHouse;
    }

    public Floor goToFloor(int floorNum){
        return this.floors.get(floorNum);
    }

    public String toString(){
        String printer = "Welcome to the Main House! \nYou're now at Floor 1.";
        for(Floor floor: this.floors){
            printer += floor;
        }
        return printer;
    }
}