import java.util.ArrayList;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
public class Floor {
    public MutableGraph<Room> room;
    Room activeRoom = null;
    public Floor(){
        this.room = GraphBuilder.undirected().build();
    }

    public Floor addGoundFloor(){
        Room basement = new Room().addBasement();
        Floor goundFloor = new Floor();
        goundFloor.room.addNode(basement);
        return goundFloor;
    }

    public Floor addFirstFloor(){
        Room livingRoom = new Room().addLivingRoom();
        Room kitchen = new Room().addKitchen();
        Room bedroom = new Room().addBedroom();
        Floor firstFloor = new Floor();
        firstFloor.room.putEdge(livingRoom, bedroom);
        firstFloor.room.putEdge(livingRoom, kitchen);
        return firstFloor;
    }

    public Floor addSecondFloor(){
        Room Attic = new Room().addAttic();
        Floor secondFloor = new Floor();
        secondFloor.room.addNode(Attic);
        return secondFloor;
    }

    public Boolean goToAdjacentRoom(Room start, Room end){
        if (this.room.adjacentNodes(start).equals(end)){
            this.activeRoom = end;
            return true;
        }
        else{
            System.out.println("Sorry, you cannot go to " + start.getName());
            return false;
        }
    }
}
