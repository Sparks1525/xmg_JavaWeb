package _01.servlet;

import _01.dao.IStudentDAO;
import _01.dao.impl.StudentDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value={"/student/list"})
public class ListStudentServlet extends HttpServlet {
    private static final Long serialVersionUID = 1L;
    private IStudentDAO dao;
    @Override
    public void init() throws ServletException {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setAttribute("students",dao.list());
        req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req,resp);
    }
}
