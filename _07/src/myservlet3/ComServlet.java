package myservlet3;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/myservlet3/comservlet"})
public class ComServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        ServletContext servletContext1 = req.getServletContext();

        ServletContext servletContext2 = this.getServletContext();

        ServletContext servletContext3 = getServletConfig().getServletContext();

        ServletContext servletContext4 = req.getSession().getServletContext();

        String strURL = servletContext1.getRealPath("/WEB-INF/inwebinf.jsp");

        PrintWriter out = resp.getWriter();

        out.println(strURL);

        System.out.println("strURL:" + strURL);

    }

    @Override
    public void init() throws ServletException {

    }
}
