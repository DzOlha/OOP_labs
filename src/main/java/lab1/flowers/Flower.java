package lab1.flowers;

import java.util.Comparator;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class Flower {
    @CsvBindByPosition(position = 0)
    private String name;
    @CsvBindByPosition(position = 1)
    private String color;
    @CsvBindByPosition(position = 2)
    private int freshRate;//from 1 to 10
    @CsvBindByPosition(position = 3)
    private double height;//in meters up to 1
    @CsvBindByPosition(position = 4)
    private double price;
    public void setFreshRate(int fr){
        if(fr >= 1 && fr <= 10)
            freshRate = fr;
        else {
            System.out.println("Fresh rate must be the number from [1; 10] interval!");
        }
    }
    public void setHeight(double h){
        if(h > 1) {
            System.out.println("Height must not be greater than 1!");
            return;
        }
        height = h;
    }
    public void setColor(String c){color = c;}
    public void setName(String n){name = n;}
    public void setPrice(double p){
        if(p > 0)
            price = p;
        else System.out.println("Price must be positive number!");
    }

    public int getFreshRate(){return freshRate;}
    public double getHeight(){return height;}
    public String getColor(){return color;}
    public String getName() {return name;}
    public double getPrice(){return price;}

    public Flower(){}
    public Flower(String name, String color, int freshRate, double height, double price){
        this.name = name;
        this.color = color;
        setFreshRate(freshRate);
        setHeight(height);
        setPrice(price);
    }
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Flower)){
            return false;
        }
        Flower t = (Flower) o;
        return name.equals(t.name)
                && color.equals(t.color)
                && freshRate == t.freshRate
                && height == t.height
                && price == t.price;
    }
    public static class CompFreshRate implements Comparator<Flower> {
        @Override
        public int compare(Flower a, Flower b) {
            return a.getFreshRate() - b.getFreshRate();
        }
    }
    public String toString(){
        return "Flower name: " + name + "\n Color: " + color + "\n FreshRate: "
                + freshRate + "\n Height: " + height + "\n Price: " + price;
    }
}
