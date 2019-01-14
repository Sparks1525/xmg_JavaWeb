package myservlet4.servlet;

import myservlet4.dao.impl.StudentDAOImpl;
import myservlet4.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = {"/myservlet4/student"})
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        StudentDAOImpl dao = new StudentDAOImpl();
        List<Student> students = dao.list();
        System.out.println(students);

        req.setAttribute("students",students);
        req.getRequestDispatcher("/studentlist.jsp").forward(req,resp);

    }
    @Override
    public void init() throws ServletException {

    }
}
