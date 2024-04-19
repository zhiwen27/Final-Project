import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
public class Floor {
    public ArrayList<Room> rooms;
    Room activeRoom = null;
    public Floor(){
        this.rooms = new ArrayList<>();
    }

    public Floor addGoundFloor(){
        Room basement = new Room().addBasement();
        this.activeRoom = basement;
        this.rooms.add(basement);
        return this;
    }

    public Floor addFirstFloor(){
        Room livingRoom = new Room().addLivingRoom();
        Room kitchen = new Room().addKitchen();
        Room bedroom = new Room().addBedroom();
        this.activeRoom = bedroom;
        this.rooms.add(kitchen);
        this.rooms.add(livingRoom);
        this.rooms.add(bedroom);
        return this;
    }

    public Floor addSecondFloor(){
        Room attic = new Room().addAttic();
        this.activeRoom = attic;
        this.rooms.add(attic);
        return this;
    }

    public String toString(){
        String printer = "";
        for (Room room: this.rooms){
            printer += room + "\n";
        }
        return printer;
    }

    public Room goToRoom(String name){
        for (int i = 0; i < this.rooms.size(); i++){
            if (this.rooms.get(i).getName().contains(name)){
                this.activeRoom = this.rooms.get(i);
            }
        }
        return this.activeRoom;
    }
}
