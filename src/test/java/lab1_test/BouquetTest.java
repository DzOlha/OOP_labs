package lab1_test;

import com.opencsv.bean.CsvToBeanBuilder;
import lab1.Bouquet;
import lab1.accessories.Accessory;
import lab1.accessories.Note;
import lab1.accessories.Ribbon;
import lab1.accessories.Wrapper;
import lab1.flowers.Flower;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;
import static org.junit.jupiter.api.Assertions.*;

public class BouquetTest {
    static Bouquet b;
    @BeforeAll
    static void beforeAll() {
        b = new Bouquet();
        Accessory[] accessories = new Accessory[3];
        accessories[0] = new Wrapper("white", 1, 0.6, 4);
        accessories[1] = new Ribbon(2.5, "red", 1);
        accessories[2] = new Note(1.5, "pink", "Best wishes!");

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
        b.setFlowers(flowers);
        b.setAccessories(accessories);
    }
    @Test
    @DisplayName("Calculation of bouquet cost.")
    void testCalculationOfTheCost(){
        assertEquals(811.4, b.calcBouquetCost());
    }
    @Test
    @DisplayName("Find flower from the interval of stem height.")
    void testFindFlowerByHeightRange() {
        ArrayList<Flower> flowersTrue = new ArrayList<Flower>();
        flowersTrue.add(new Flower("Tulip", "yellow", 6, 0.3, 70));
        flowersTrue.add(new Flower("Tulip", "pink", 10, 0.35, 70));
        flowersTrue.add(new Flower("Tulip", "red",5, 0.35, 65));

        ArrayList<Flower> flowersActual = b.findFlowerByHeightRange(0.3, 0.35);

        boolean flag = true;
        int i = 0;
        for(Flower expected : flowersTrue) {
            flag = expected.equals(flowersActual.get(i));
            if(flag == false) break;
            i++;
        }
        assertTrue(flag);
    }
}
