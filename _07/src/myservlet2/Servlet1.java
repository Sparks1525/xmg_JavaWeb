package myservlet2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/myservlet2/servlet1")
public class Servlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        System.out.println("myservlet2_servlet_1 service start");


        out.println("html myservlet2_servlet_1 before  <br/>");


        resp.sendRedirect("/demo7/myservlet2/servlet2");

        out.println("html myservlet2_servlet_1 after");

        out.println("html myservlet2_servlet_1 after");

        System.out.println("myservlet2_servlet_1 service end");


    }

    @Override
    public void init() throws ServletException {
        // System.out.println("Servlet1 init");
    }
}
