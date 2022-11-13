package lab1.accessories;

public class Accessory {
    private double price;
    private String color;
    private String name;
    public void setPrice(double p){price = p;}
    public void setColor(String c){color = c;}

    public void setName(String name) {this.name = name;}

    public double getPrice(){return price;}
    public String getColor(){return color;}
    public String getName() {return name;}

    public Accessory(String name, double price, String color){
        this.name = name;
        this.price = price;
        this.color = color;
    }
    public String toString(){
        return " Accessory name: " + name + "\n Color: " + color + "\n Price: " + price;
    }
}

