package lab1;
import lab1.accessories.Accessory;
import lab1.accessories.Note;
import lab1.accessories.Ribbon;
import lab1.accessories.Wrapper;
import lab1.flowers.Chrysanthemum;
import lab1.flowers.Flower;
import lab1.flowers.Rose;
import lab1.flowers.Tulip;

public class Main {
    public static void main(String[] args) {
        Flower[] flowers = new Flower[11];
        flowers[0] = new Rose(5, 0.4, "red");
        flowers[1] = new Tulip(8, 0.25, "pink");
        flowers[2] = new Rose(4, 0.55, "white");
        flowers[3] = new Rose(10, 0.5, "white");
        flowers[4] = new Tulip(6, 0.3, "yellow");
        flowers[5] = new Chrysanthemum(9, 0.45, "white");
        flowers[6] = new Chrysanthemum(6, 0.45, "white");
        flowers[7] = new Chrysanthemum(2, 0.45, "white");
        flowers[8] = new Tulip(10, 0.35, "pink");
        flowers[9] = new Tulip(5, 0.35, "red");
        flowers[10] = new Rose(7, 0.4, "red");

        Accessory[] accessories = new Accessory[3];
        accessories[0] = new Wrapper("white", 1, 0.6, 4);
        accessories[1] = new Ribbon(2.5, "red", 1);
        accessories[2] = new Note(1.5, "pink", "Best wishes!");

        Bouquet myB = new Bouquet(flowers, accessories);
        myB.printAllBouquet();
        myB.findFlowerByHeightRange(0.3, 0.4);
    }
}
