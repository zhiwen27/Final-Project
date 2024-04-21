import java.util.ArrayList;
public class Floor {
    public ArrayList<Room> rooms;
    Room activeRoom = null;
    String[] roomNames;

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
    public Room goToRoom(Floor f,String name){
        Room room = new Room();
        for (int i = 0; i < f.rooms.size(); i++){
            if (this.rooms.get(i).getName().contains(name)){
                room = f.rooms.get(i);
            }
        }
        return room;
    }

    public boolean floorOver(){
        int cnt = 0;
        for (Room r: this.rooms){
            if (r.moveableItemCollection.isEmpty()){
                cnt++;
            }
        }
        boolean floorOver = false;
        if (cnt == this.rooms.size()){
            floorOver = true;
        }
        return floorOver;
    }

    public boolean checkRoomInput(String userInput){
        this.roomNames = new String[this.rooms.size()];
        int cnt = 0;
        for (Room r: this.rooms){
            this.roomNames[cnt] = r.getName();
            cnt++;
        }
        boolean containedRequiredWord = false;
        for (int i = 0; i < this.roomNames.length; i++){
            if (userInput.contains(this.roomNames[i])){
                containedRequiredWord = true;
            }
        }
        if (containedRequiredWord == true){
            return containedRequiredWord;
        }
        else{
            throw new RuntimeException("Please enter the required word.");
        }
    }
}
