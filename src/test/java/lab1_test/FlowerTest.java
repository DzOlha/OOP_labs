package lab1_test;

import com.opencsv.bean.CsvToBeanBuilder;
import lab1.flowers.Flower;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.exit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlowerTest {
    static Flower flower;
    static Flower[] flowers;
    @BeforeAll
    static void beforeAll() {
        String fileName = "src/main/java/lab1/flowers.csv";
        flowers = null;
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
    }
    @Test
    @DisplayName("Sort the flowers by fresh rate.")
    void testSortTheFlowersByFreshRate() {
        List<Flower> expected = Arrays.stream(flowers).toList().stream()
                .sorted(Comparator.comparingInt(Flower::getFreshRate))
                .collect(Collectors.toList());

        Arrays.sort(flowers, new Flower.CompFreshRate());
        boolean flag = true;
        int i = 0;
        for(Flower actual : flowers) {
            flag = actual.equals(expected.get(i));
            if(flag == false) break;
            i++;
        }
        assertTrue(flag);
    }
}