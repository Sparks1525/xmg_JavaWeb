package myservlet5_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/myservlet5_cookie/cookie/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");

        Cookie myCookie = new Cookie("username",username);
        myCookie.setPath("/myservlet5_cookie");
        //myCookie.setDomain(".xxx.xxx");

        resp.addCookie(myCookie);

        out.println("<p>LoginServlet</p>");
        out.println("欢迎:" + username + "<br/>");
        out.println("<a href='/myservlet5_cookie/cookie2/list'>收件箱</a>");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("LoginServlet init");
    }
}
