package homework5.view;

import homework5.controllers.UserController;
import homework5.models.Teacher;

import java.util.List;


public class TeacherView implements UserView {


    private final UserController<Teacher> controller;

    public TeacherView(UserController<Teacher> controller) {
        this.controller = controller;
    }

    public void sendOnConsole() {
        sendOnConsole(SortType.NONE);
    }

    @Override
    public void sendOnConsole(SortType sortType) {
//        List<Teacher> teachers = controller.getAll();

        List<Teacher> teachers = getTeachers(sortType);
        if (teachers == null || teachers.size() == 0) {
            System.out.println("Отсутствуют учителя для вывода");
            return;
        }

        System.out.println("===================================");
        System.out.println("Для вывода использована " + sortType);
//        for (Teacher student : teachers) {
//            System.out.println(student);
//        }
//        teachers.forEach((student) -> System.out.println(student));
        teachers.forEach(System.out::println);
        System.out.println("===================================");
    }

    private List<Teacher> getTeachers(SortType sortType) {
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
            System.out.println("Удалено учителей: " + removeCount);
        }

    }
}
