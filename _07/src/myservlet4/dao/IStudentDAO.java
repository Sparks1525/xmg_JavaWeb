package myservlet4.dao;

import myservlet4.domain.Student;

import java.util.List;

public interface IStudentDAO {
    void save(Student studnet);
    void update(Student student);
    void delete(Long id);
    Student get(Long id);
    List<Student> list();

}
