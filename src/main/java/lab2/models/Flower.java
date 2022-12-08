package lab2.models;

public class Flower {
    private int id;
    private String name;
    private String origin;
    private Soil soil;
    private VisualParameters visual;
    private GrowingTips tips;
    private Propagation propagation;
    public Flower(){}
    public Flower(int id, String name, String origin) {
        this.id = id;
        this.name = name;
        this.origin = origin;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
    }
    public String getOrigin(){
        return origin;
    }
    public void setOrigin(String newOrigin){
        origin = newOrigin;
    }
    public Soil getSoil(){
        return soil;
    }
    public void setSoil(String newSoil){
        switch (newSoil) {
            case "podzolic": this.soil = Soil.PODZOLIC;
            break;
            case "chernozem": this.soil = Soil.CHERNOZEM;
            break;
            case "sod-podzolic": this.soil = Soil.SOD_PODZOLIC;
            break;
            default:
                System.out.println("You entered incorrect value for soil!");
                break;
        }
    }
    public VisualParameters getVisual(){
        return visual;
    }
    public void setVisual(VisualParameters vp){
        visual = vp;
    }
    public GrowingTips getTips(){
        return tips;
    }
    public void setTips(GrowingTips gt){
        tips = gt;
    }
    public Propagation getPropagation(){
        return propagation;
    }

    public void setPropagation(String newPropagation) {
        switch (newPropagation) {
            case "cuttings": this.propagation = Propagation.CUTTINGS;
                break;
            case "leaves": this.propagation = Propagation.LEAVES;
                break;
            case "seeds": this.propagation = Propagation.SEEDS;
                break;
            default:
                System.out.println("You entered incorrect value for propagation!");
                break;
        }
    }
}
