package lab1;
import com.opencsv.bean.CsvToBeanBuilder;
import lab1.accessories.Accessory;
import lab1.accessories.Note;
import lab1.accessories.Ribbon;
import lab1.accessories.Wrapper;
import lab1.flowers.Flower;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/lab1/flowers.csv";
        Flower[] flowers = null;
        try {
            FileReader csvReader = new FileReader(fileName);
            List<Flower> beans = new CsvToBeanBuilder(csvReader)
                    .withType(Flower.class)
                    .build()
                    .parse();

            flowers = new Flower[beans.size()];
            beans.toArray(flowers);

        } catch (FileNotFoundException e) {
            System.out.println("File with flowers not found!");
            exit(-1);
        }

        Accessory[] accessories = new Accessory[3];
        accessories[0] = new Wrapper("white", 1, 0.5, 4);
        accessories[1] = new Ribbon(2.5, "red", 1);
        accessories[2] = new Note(1.5, "pink", "Best wishes!");

        Bouquet myB = new Bouquet(flowers, accessories);
        myB.printAllBouquet();
        myB.findFlowerByHeightRange(0.3, 0.4);
    }
}
