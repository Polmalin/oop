package homework1;

import java.util.ArrayList;
import java.util.List;
/*
Нужно создать несколько классов животных:
1. Пес (Собака)
2. Кот (Кошка)
3. ... придумать еще парочку

Каждое животное имеет: (поля)
1. Имя (кличка)
2. Возраст
3. ... придумать еще какие-то параметры

Каждое животное может: (методы)
1. Подавать голос
2. Питаться (съедает какое-то количество еды, переданное в метод)
3. Двигаться
4. ... все, что сумеете придумать

Нужно выделить базовый тип с общими атрибутами, инкапсулировать то, что является внутренним, внурь класса.
Создать массив с животными и в цикле заставить их поесть (какое-то количество еды) и заставить подать голос.

Придумать свою структуру с наследованием по аналогии с животными и банковскими счетами.
 */
public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat("Kat", 2, "white", 3.0));
        animals.add(new Dog("Kuzya", 3, "red", 10.0));
        animals.add(new Turtle("Korzhick", 15, "green", 0.3));
        animals.add(new Parrot("Donald", 1, "blue-green-red", 1.0));
        List <Food> foods= new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            foods.add(new Food());
        }
        for (Animal animal:animals){
            animal.eat(foods);
            animal.voice();
        }
        System.out.println("foods remained: " + foods.size());
    }
}
