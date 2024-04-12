import java.util.Hashtable;

public class Jewelry extends Item{

    public Jewelry(){
        super();
    }

    public void addGold(){
        this.setName("Gold");
        this.setValue(100);
    }

    public void addSilver(){
        this.setName("Silver");
        this.setValue(50);
    }

    public void addDiamond(){
        this.setName("Diamond");
        this.setValue(150);
    }

    public void addCrystal(){
        this.setName("Crystal");
        this.setValue(80);
    }

    public static void main(String[] args) {
        Jewelry j = new Jewelry();
        j.addCrystal();
        System.out.println(j);
    }
}
