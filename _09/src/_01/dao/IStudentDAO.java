package _01.dao;

import _01.domain.Student;

import java.util.List;

public interface IStudentDAO {
    void save(Student student);
    void update(Student student);
    void delete(Long id);
    Student get(Long id);
    List<Student> list();
}
