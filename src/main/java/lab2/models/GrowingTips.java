package lab2.models;

public class GrowingTips {
    public double temperature;
    public boolean is_lightingRequire;
    public double watering;
    public GrowingTips(){}
    public GrowingTips(double temp, boolean lightRequire, double watering){
        this.temperature = temp;
        this.is_lightingRequire = lightRequire;
        this.watering = watering;
    }
}