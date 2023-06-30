package homework1;

import java.util.Iterator;
import java.util.List;

public class Turtle extends Animal {
    public Turtle(String name, int age, String color, double weight) {
        super(name, age, color, weight);
    }

    @Override
    public void voice() {
        System.out.println("silence");
    }

    @Override
    public void eat(List<Food> foods) {
        int size = Math.min(1, foods.size());
        foods.subList(0, size).clear();
        System.out.println("the turtle ate " + size + " foods");
    }

    @Override
    public void move() {
        System.out.println("the turtle moved");
    }

    @Override
    public void palm() {
        System.out.println("the turtle is looking lost");
    }
}
