package myservlet6_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/myservlet6_session/cookie/get"})
public class GetServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        HttpSession mySession = req.getSession();

        String username = (String) mySession.getAttribute("username");

        out.println("<p>GetServlet</p>");
        out.println("欢迎:" + username + "<br/>");

    }

    @Override
    public void init() throws ServletException {
        System.out.println("GetServlet init");
    }
}
