package homework5.services;

import homework5.models.Teacher;
import homework5.models.Teacher;
import homework5.repositories.UserRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TeacherService implements UserService<Teacher> {

    private final UserRepository<Teacher> teacherRepository;

    public TeacherService(UserRepository<Teacher> teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        teacherRepository.create(new Teacher(fullName, age, phoneNumber, groupTitle));
    }

    @Override
    public List<Teacher> getAll() {
        var teachers = teacherRepository.getAll();
        Collections.sort(teachers);
        return teachers;
    }

    public List<Teacher> getAllSortByFullName() {
        var teachers = teacherRepository.getAll();
/*        teachers.sort(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });*/
//        teachers.sort((o1, o2) -> o1.getFullName().compareTo(o2.getFullName()));
        teachers.sort(Comparator.comparing(Teacher::getFullName));

        return teachers;
    }

    public List<Teacher> getAllSortById() {
        var teachers = teacherRepository.getAll();
        teachers.sort(Comparator.comparing(Teacher::getId));
        return teachers;
    }


    @Override
    public int remove(String fullName) {
        return teacherRepository.remove(fullName);
    }

    @Override
    public List<Teacher> getAllByTitile(String groupTitle) {
        return teacherRepository.getAllByGroupTitle(groupTitle);
    }
}
