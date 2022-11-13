package lab1.flowers;

import java.util.Comparator;

public class Flower {
    private int freshRate;//from 1 to 10
    private double height;//in meters up to 1
    private String color;
    private String name;
    private int price;
    public void setFreshRate(int fr){freshRate = fr;}
    public void setHeight(double h){height = h;}
    public void setColor(String c){color = c;}
    public void setName(String n){name = n;}
    public void setPrice(int p){price = p;}

    public int getFreshRate(){return freshRate;}
    public double getHeight(){return height;}
    public String getColor(){return color;}
    public String getName() {return name;}
    public int getPrice(){return price;}

    public Flower(int freshRate, double height, String color, String name, int price){
        this.freshRate = freshRate;
        this.height = height;
        this.color = color;
        this.name = name;
        this.price = price;
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
