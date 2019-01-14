package myservlet3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/cookie/myservlet3"}, initParams = {
        @WebInitParam(name = "mycookie_name", value = "mycookie_vaule")})
public class MyServlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();


        String username = req.getParameter("username");
        out.println("欢迎" + username + "<br/>");
        out.println("<a href='/mailbox.html'>收件箱</a>");

    }

    @Override
    public void init() throws ServletException {
        System.out.println("my init");
    }
}
