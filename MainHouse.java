import java.util.Hashtable;
import java.util.ArrayList;

import com.google.common.graph.GraphBuilder;
public class MainHouse{
    private String name;
    private ArrayList<Floor> structure;
    private int floor;
    private int activeFloor = -1;

    public MainHouse(){
        this.name = "Main House";
        this.floor = 4;
        this.structure = new ArrayList<>(this.floor);
    }

    public MainHouse enter() {
        if (this.activeFloor != -1) {
            throw new RuntimeException("You are already inside the Main House.");
        }
        this.activeFloor = 1;
        System.out.println("Welcome to the Main House!");
        return this;
    }

    public void roomTour(){
        
    }
    public void goUpFloor(){

    }
}