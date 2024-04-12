import com.google.common.graph.*;
public class Room {
    private String name;
    MutableGraph<Item> itemCollection;

    public Room(){
        this.name = "";
        this.itemCollection = GraphBuilder.undirected().build();
    }

    public void addLivingRoom(){
        this.name = "Living Room";
    }

    public void addKitchen(){
        this.name = "Kitchen";
    }

    public void addBedroom(){
        this.name = "Bedroom";
    }

    public void addBasement(){
        this.name = "Basement";
    }

    public void addAttic(){
        this.name = "Attic";
    }

    public void addEdge(Item item1, Item item2){
        this.itemCollection.putEdge(item1, item2);
    }
}
