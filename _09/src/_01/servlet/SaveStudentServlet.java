package _01.servlet;

import _01.dao.IStudentDAO;
import _01.dao.impl.StudentDAOImpl;
import _01.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/student/save"})
public class SaveStudentServlet extends HttpServlet {
    private static final Long serialVersionUID = 1L;
    private IStudentDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Student student = new Student();
        String name = req.getParameter("name");
        int age = Integer.valueOf(req.getParameter("age"));
        student.setName(name);
        student.setAge(age);
        String sid = req.getParameter("id");
        if(hasLength(sid)){
            student.setId(Long.valueOf(sid));
            dao.update(student);
        } else {
            dao.save(student);
        }

        resp.sendRedirect("/student/list");
    }

    private boolean hasLength(String str){
        return str != null && !"".equals(str.trim());
    }
}
