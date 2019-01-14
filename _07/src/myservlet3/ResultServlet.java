package myservlet3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/myservlet3/resultservlet"})
public class ResultServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        Integer requestCount = (Integer) req.getAttribute("count");

        Integer sessionCount = (Integer) req.getSession().getAttribute("count");

        Integer servletContextCount = (Integer) this.getServletContext().getAttribute("count");

        out.println("requestCount:" + requestCount + "<br/>");
        out.println("sessionCount:" + sessionCount + "<br/>");
        out.println("servletContextCount:" + servletContextCount + "<br/>");
    }

    @Override
    public void init() throws ServletException {

    }
}
