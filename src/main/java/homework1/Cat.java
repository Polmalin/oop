package homework1;

import java.util.Iterator;
import java.util.List;

public class Cat extends Animal {
    public Cat(String name, int age, String color, double weight) {
        super(name, age, color, weight);
    }

    @Override
    public void voice() {
        System.out.println("meow");
    }

    @Override
    public void eat(List<Food> foods) {
        int size = Math.min(3, foods.size());
        foods.subList(0, size).clear();
        System.out.println("the cat ate " + size + " foods");
    }

    @Override
    public void move() {
        System.out.println("the cat moved");
    }

    @Override
    public void palm() {
        System.out.println("the cat gave its palm");
    }
}
