package homework4;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> list = new ArrayList<>();
    private int weight;

    public void add(T t) {
        list.add(t);
        weight += t.getWeight();
    }

    public int getWeight() {
        return weight;
    }

    public void moveTo(Box<? super T> box) {
        for (T t : list) {
            box.add(t);
        }
        list.clear();
        weight=0;
    }
}
