package lab1.accessories;

public class Accessory {
    protected double price;
    protected String color;
    protected String name;
    public void setPrice(double p){
        if(p > 0)
            price = p;
        else System.out.println("Price must be positive number!");
    }
    public void setColor(String c){color = c;}

    public void setName(String name) {this.name = name;}

    public double getPrice(){return price;}
    public String getColor(){return color;}
    public String getName() {return name;}

    public Accessory(){}
    public Accessory(String name, double price, String color){
        this.name = name;
        setPrice(price);
        this.color = color;
    }
    public String toString(){
        return " Accessory name: " + name + "\n Color: " + color + "\n Price: " + price;
    }
}

