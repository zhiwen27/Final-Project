import java.util.ArrayList;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
public class Floor {
    public MutableGraph<Room> room;
    Room activeRoom = null;
    public Floor(){
        this.room = GraphBuilder.undirected().build();
    }

    public void addRoom(Room r1,Room r2){
        room.putEdge(r1,r2);
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
