package duks.feudalismminecraftgame.Purchseables;

public abstract class Purchseable {
    protected int price;
    protected String name;
    protected String description;

    public int getPrice(){
        return this.price;
    }

    public String toString(){
        return this.description;
    }
}
