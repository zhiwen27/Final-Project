import com.google.common.graph.*;
public class Room {
    private String name;
    MutableGraph<Item> itemCollection;

    public Room(String name){
        this.name = name;
        this.itemCollection = GraphBuilder.undirected().build();
    }

    public void addEdge(Item item1, Item item2){
        this.itemCollection.putEdge(item1, item2);
    }
}
