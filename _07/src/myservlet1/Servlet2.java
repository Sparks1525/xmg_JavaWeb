package myservlet1;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/myservlet1/servlet2")
public class Servlet2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        System.out.println("myservlet1_servlet_2 service start");

        out.println("html myservlet1_servlet_2 before <br/>");



        out.println("html myservlet1_servlet_2 after");

        System.out.println("myservlet1_servlet_2 service end");
    }

    @Override
    public void init() throws ServletException {

    }
}
