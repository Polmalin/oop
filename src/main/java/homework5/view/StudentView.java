package homework5.view;

import homework5.controllers.UserController;
import homework5.models.Student;

import java.util.List;


public class StudentView implements UserView {


    private final UserController<Student> controller;

    public StudentView(UserController<Student> controller) {
        this.controller = controller;
    }

    public void sendOnConsole() {
        sendOnConsole(SortType.NONE);
    }

    @Override
    public void sendOnConsole(SortType sortType) {
//        List<Student> students = controller.getAll();

        List<Student> students = getStudents(sortType);
        if (students == null || students.size() == 0) {
            System.out.println("Отсутствуют студенты для вывода");
            return;
        }

        System.out.println("===================================");
        System.out.println("Для вывода использована " + sortType);
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        students.forEach((student) -> System.out.println(student));
        students.forEach(System.out::println);
        System.out.println("===================================");
    }

    private List<Student> getStudents(SortType sortType) {
        switch (sortType) {
            case NONE:
                return controller.getAll();
            case NAME:
                return controller.getAllSortByFullName();
            case ID:
                return controller.getAllSortById();
            default:
                throw new IllegalArgumentException("unknown sortType " + sortType);
        }
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        controller.create(fullName, age, phoneNumber, groupTitle);
    }

    @Override
    public void removeUser(String fullName) {
        int removeCount = controller.remove(fullName);

        if (removeCount == 0) {
            System.out.println("Удаление не получилось.");
        } else {
            System.out.println("Удалено студентов: " + removeCount);
        }

    }
}
