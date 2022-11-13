package lab1.accessories;

public class Ribbon extends Accessory{
    private double length;
    public void setLength(double len){length = len;}
    public double getLength(){return length;}
    public Ribbon(double price, String color, double length){
        super("ribbon", price, color);
        this.length = length;
    }
}
