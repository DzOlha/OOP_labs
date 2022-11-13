package lab1.accessories;

public class Note extends Accessory{
    private String message;
    public void setMessage(String mes){message = mes;}
    public String getMessage(){return message;}

    public Note(double price, String color, String message) {
        super("note", price, color);
        this.message = message;
    }
}
