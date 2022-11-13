package lab1.accessories;

public class Wrapper extends Accessory{
    private double width;//in meters
    private double height;//in meters
    private int priceForOneSquareMeter;
    public void setWidth(int w){width = w;}
    public void setHeight(int h){height = h;}
    public void setPriceForOneSquareMeter(int p){priceForOneSquareMeter = p;}
    public double getWidth(){return width;}
    public double getHeight(){return height;}
    public int getPriceForOneSquareMeter(){return priceForOneSquareMeter;}

    public Wrapper(String color, double width, double height, int priceForOneSquareMeter){
        super("wrapper", priceForOneSquareMeter*height*width, color);
        this.priceForOneSquareMeter = priceForOneSquareMeter;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPrice() {
        return priceForOneSquareMeter*height*width;
    }
}
