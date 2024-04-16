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

    public MainHouse addMainHouse(){
        MainHouse mainHouse = new MainHouse();
        mainHouse.addFloor();
        return mainHouse;
    }
}