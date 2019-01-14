package _01.dao.impl;

import _01.dao.IResultSetHandler;
import _01.dao.IStudentDAO;
import _01.domain.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {
    @Override
    public void save(Student student) {
        String sql = "INSERT INTO student(name,age) VALUES (?,?)";
        Object[] objects = {student.getName(), student.getAge()};
        JdbcTemplate.update(sql, objects);
    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE student SET name=?,age=? WHERE id=?";
        Object[] objects = {student.getName(), student.getAge(), student.getId()};
        JdbcTemplate.update(sql, objects);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM student WHERE id= ?";
        JdbcTemplate.update(sql, id);
    }

    @Override
    public Student get(Long id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        List<Student> list = JdbcTemplate.query(sql, new StudentResultSetHandler(), id);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Student> list() {
        String sql = "SELECT * FROM student";
        return JdbcTemplate.query(sql, new StudentResultSetHandler());
    }
}

class StudentResultSetHandler implements IResultSetHandler<List<Student>> {
    @Override
    public List<Student> handler(ResultSet rs) throws SQLException {
        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            list.add(student);
        }
        return list;
    }
}
