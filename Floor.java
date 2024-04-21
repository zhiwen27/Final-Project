import java.util.ArrayList;
public class Floor {
    public ArrayList<Room> rooms;
    Room activeRoom = null;

    /**
     * Constructor for Floor
     */
    public Floor(){
        this.rooms = new ArrayList<>();
    }

    /**
     * Create the ground floor: basement
     * @return the ground floor
     */
    public Floor addGoundFloor(){
        Room basement = new Room().addBasement();
        this.activeRoom = basement;
        this.rooms.add(basement);
        return this;
    }

    /**
     * Create the first floor: kitchen, living room, bedroom
     * @return the first floor
     */
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

    /**
     * Create the second floor: attic
     * @return the second floor
     */
    public Floor addSecondFloor(){
        Room attic = new Room().addAttic();
        this.activeRoom = attic;
        this.rooms.add(attic);
        return this;
    }

    /**
     * Printing of Floor
     */
    public String toString(){
        String printer = "";
        for (Room room: this.rooms){
            printer += room + "\n";
        }
        return printer;
    }

    /**
     * Go to certain room of the floor
     * @param name the room you want to go to
     * @return the target room
     */
    public Room goToRoom(String name){
        for (int i = 0; i < this.rooms.size(); i++){
            if (this.rooms.get(i).getName().contains(name)){
                this.activeRoom = this.rooms.get(i);
            }
        }
        return this.activeRoom;
    }
}
