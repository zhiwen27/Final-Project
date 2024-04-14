import java.util.Hashtable;
import java.util.ArrayList;

import com.google.common.graph.GraphBuilder;
public class MainHouse{
    private String name;
    private ArrayList<Floor> structure;
    private int floor;
    private int activeFloor = 1;

    public MainHouse(){
        this.name = "Main House";
        this.floor = 4;
        this.structure = new ArrayList<>(this.floor);
    }

    public Floor floorTour(int floorNum){
        return this.structure.get(floorNum);
    }

    public void goUpFloor(){
        this.activeFloor += 1;
        floorTour(this.activeFloor);
    }

    public void goDownFloor(){
        this.activeFloor -= 1;
        floorTour(this.activeFloor);
    }
}