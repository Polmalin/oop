package homework3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Container implements Comparable<Container>, Iterable<Box> {
    private List<Box> boxes;

    public int getWeight() {
        int weight = 0;
        for (Box box : boxes) {
            weight += box.getWeight();
        }
        return weight;
    }

    @Override
    public int compareTo(Container container) {
        return getWeight() - container.getWeight();
    }

    @Override
    public Iterator<Box> iterator() {
        return boxes.iterator();
    }

    @Override
    public void forEach(Consumer<? super Box> action) {
        boxes.forEach(action);
    }

    @Override
    public Spliterator<Box> spliterator() {
        return boxes.spliterator();
    }
}
