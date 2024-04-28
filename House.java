public class House {
    String name;
    
    /**
     * Default constructor
     */
    public House(){
        this("<Name Unknown>");
    }

    /**
     * Full constructor of House
     * @param n the name of House
     */
    public House(String n){
        this.name = n;
    }
}