package lab1_test;
import lab1.accessories.Wrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.System.exit;
import static org.junit.jupiter.api.Assertions.*;
public class WrapperTest {
    Wrapper wrapper;
    @BeforeEach
    void beforeEach(){
        wrapper = new Wrapper();
    }
    @Test
    @DisplayName("Calculation the price of wrapper.")
    void testCalculationOfTheWrapperPrice(){
        wrapper.setPriceForOneSquareMeter(1.5);
        wrapper.setWidth(1);
        wrapper.setHeight(0.85);
        boolean flag = wrapper.getPrice() == 1.275;
        assertTrue(flag);
    }
}
