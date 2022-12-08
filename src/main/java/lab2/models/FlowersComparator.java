package lab2.models;

import java.util.Comparator;

public class FlowersComparator implements Comparator<Flower> {
    @Override
    public int compare(Flower o1, Flower o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
