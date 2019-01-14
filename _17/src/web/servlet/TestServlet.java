package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("TestServlet init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("TestServlet service");
        req.setAttribute("test","--TestServlet1--");
        req.setAttribute("test","--TestServlet2--");
        req.setAttribute("test2","--TestServlet--");
        req.removeAttribute("test2");
        HttpSession session = req.getSession();
        session.setAttribute("testSession","test Session");
        req.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(req,resp);
    }
}
