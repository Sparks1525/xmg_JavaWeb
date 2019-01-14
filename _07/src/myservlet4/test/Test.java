package myservlet4.test;

import myservlet4.dao.impl.StudentDAOImpl;
import myservlet4.domain.Student;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        StudentDAOImpl dao = new StudentDAOImpl();
        List<Student> students = dao.list();
        System.out.println(students);
    }
}
