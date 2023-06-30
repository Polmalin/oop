package homework1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public abstract class Animal {
    private String name;
    private int age;
    private String color;
    private double weight;

    public Animal(String name, int age, String color, double weight) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }

    public abstract void voice();

    public abstract void eat(List<Food> foods );

    public abstract void move();

    public abstract void palm();
}
