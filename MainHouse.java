import java.util.Hashtable;
import java.util.ArrayList;

import com.google.common.graph.GraphBuilder;
public class MainHouse extends House{
    private ArrayList<Floor> floors;
    private int floor;
    private int activeFloor = 1;

    public MainHouse(){
        super("Main House");
        this.floor = 4;
        this.floors = new ArrayList<>(this.floor);
    }

    public void addFloor(Floor f){
        this.floors.add(f);
    }

    public Floor floorTour(int floorNum){
        return this.floors.get(floorNum);
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