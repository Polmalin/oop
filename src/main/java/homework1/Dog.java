package homework1;

import java.util.Iterator;
import java.util.List;

public class Dog extends Animal {
    public Dog(String name, int age, String color, double weight) {
        super(name, age, color, weight);
    }

    @Override
    public void voice() {
        System.out.println("bark");
    }

    @Override
    public void eat(List<Food> foods) {
        int size = Math.min(5, foods.size());
        foods.subList(0, size).clear();
        System.out.println("the dog ate " + size + " foods");
    }

    @Override
    public void move() {
        System.out.println("the dog moved");
    }

    @Override
    public void palm() {
        System.out.println("the dog gave its palm");
    }
}
