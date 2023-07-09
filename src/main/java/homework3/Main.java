package homework3;

import homework1.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Создать класс Контейнер - Container.
//        В контейнере могут быть ящики (класс Box).
//
//        У каждого ящика есть вес.
//        У каждого контейнера есть метод "получить вес" - это сумма всех весов ящиков,
//        которые находятся в контейнере.
//
//        Класс Контейнер должен быть Comparable. Сравнивать он должен по весам контейнера
//        (чем меньше вес, тем меньше контейнер).
//        Класс ContainerCountComparator - Comparator, который сравнивает контейнеры
//        по количеству ящиков (чем меньше ящиков, тем меньше контейнер).
//        Класс контейнер должен быть Iterable - итерирование должно происходить
//        по ящикам внутри контейнера.
//
//        Container c = new Container(...);
//// ...
//        for (Box box: c) {
//        box - это контейнер
//        }
public class Main {
    public static void main(String[] args) {
        List<Container> containers = new ArrayList<>();
        {
            List<Box> boxes = new ArrayList<>();
            boxes.add(new Box(2));
            boxes.add(new Box(3));
            boxes.add(new Box(1));
            final Container container = new Container(boxes);
            for (Box box : container) {
                System.out.println(box.getWeight());
            }
            containers.add(container);
        }
        {
            List<Box> boxes = new ArrayList<>();
            boxes.add(new Box(2));
            boxes.add(new Box(1));
            containers.add(new Container(boxes));
        }
        {
            List<Box> boxes = new ArrayList<>();
            boxes.add(new Box(1));
            containers.add(new Container(boxes));
        }
        Collections.sort(containers);
        containers.sort(new ContainerCountComparator());
    }
}
