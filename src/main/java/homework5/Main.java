package homework5;

import homework5.controllers.GroupController;
import homework5.controllers.StudentController;
import homework5.controllers.TeacherController;
import homework5.repositories.StudentRepository;
import homework5.repositories.TeacherRepository;
import homework5.services.GroupService;
import homework5.services.StudentService;
import homework5.services.TeacherService;
import homework5.view.GroupView;
import homework5.view.SortType;
import homework5.view.StudentView;
import homework5.view.TeacherView;

public class Main {

    private static StudentRepository studentRepository;
    private static StudentService studentService;
    private static StudentController studentController;

    private static TeacherRepository teacherRepository;
    private static TeacherService teacherService;
    private static TeacherController teacherController;


    public static void main(String[] args) {
        StudentView studentView = getStudentController();
        TeacherView teacherView = getTeacherController();
        GroupView groupView = getGroupView();
//        -------------------------------------------------------------------------

        studentView.create("Ivan Morozov", 18, "02", "11Б");
        studentView.create("Ivan Morozov", 18, "02", "11Б");
        studentView.create("Petr Vorobev", 19, "03", "10А");
        studentView.create("Sidor Sidorov", 20, "112", "10А");
        studentView.create("Elena Ivanova", 19, "911", "10А");
        studentView.create("Anna Morozova", 17, "01", "11А");

        teacherView.create("Людмила Толстова", 44, "08", "11Б");
        teacherView.create("Евгений Карпов", 52, "05", "11Б");
        teacherView.create("Petr Негуляев", 30, "04", "10А");
        teacherView.create("Владтитр Травкин", 46, "177", "10А");
        teacherView.create("Любовь Сидорова", 27, "811", "10А");
        teacherView.create("Юлия Морозова", 28, "33", "11А");
        
        groupView.printAllFromGroup("11А");
        studentView.sendOnConsole();
        studentView.sendOnConsole(SortType.NAME);
        studentView.sendOnConsole(SortType.ID);

        studentView.removeUser("Ivan Morozov");

        studentView.sendOnConsole();

    }

    private static TeacherView getTeacherController() {
        teacherRepository = new TeacherRepository();
        teacherService = new TeacherService(teacherRepository);
        teacherController = new TeacherController(teacherService);
        return new TeacherView(teacherController);
    }

    private static StudentView getStudentController() {
        studentRepository = new StudentRepository();
        studentService = new StudentService(studentRepository);
        studentController = new StudentController(studentService);
        return new StudentView(studentController);
    }

    private static GroupView getGroupView() {
        GroupService groupService = new GroupService(studentService, teacherService);
        GroupController groupController = new GroupController(groupService);
        return new GroupView(groupController);
    }


}
