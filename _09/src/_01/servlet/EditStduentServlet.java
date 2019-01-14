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

@WebServlet(value = {"/student/edit"})
public class EditStduentServlet extends HttpServlet {
    private static final Long serialVersionUID = 1L;
    private IStudentDAO dao;
    @Override
    public void init() throws ServletException {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("id");
        if(hasLength(uid)){
            Student student = dao.get(Long.valueOf(uid));
            req.setAttribute("student",student);
        }
        req.getRequestDispatcher("/WEB-INF/views/student/edit.jsp").forward(req,resp);
    }

    private boolean hasLength(String str){
        return str != null && "".equals(str.trim());
    }

}
