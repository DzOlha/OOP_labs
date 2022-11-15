package lab1.accessories;

public class Wrapper extends Accessory{
    private double width;//in meters
    private double height;//in meters
    private double priceForOneSquareMeter;
    public void setWidth(double w){
        if(w > 0)
            width = w;
        else {
            System.out.println("Width must be positive number!");
        }
    }
    public void setHeight(double h){
        if(h > 0)
            height = h;
        else {
            System.out.println("Height must be positive number!");
        }
    }
    public void setPriceForOneSquareMeter(double p){
        if(p > 0)
            priceForOneSquareMeter = p;
        else System.out.println("Price for one square meter must be positive number!");
    }
    public double getWidth(){return width;}
    public double getHeight(){return height;}
    public double getPriceForOneSquareMeter(){return priceForOneSquareMeter;}

    public Wrapper(){}
    public Wrapper(String color, double width, double height, double priceForOneSquareMeter){
        super("Wrapper", priceForOneSquareMeter, color);
        setHeight(height);
        setWidth(width);
        setPriceForOneSquareMeter(priceForOneSquareMeter);
        setPrice(priceForOneSquareMeter * (height * width));
    }

    @Override
    public double getPrice() {
        return priceForOneSquareMeter * (height * width);
    }
}
