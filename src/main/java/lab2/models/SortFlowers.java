package lab2.models;

import java.util.Collections;
import java.util.List;

public class SortFlowers {
    public static void sortFlowers(List<Flower> flowers) {
        Collections.sort(flowers, new FlowersComparator());
    }
}
