package _01.javabean1;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        Cookie cookie = new Cookie("username","laowang");
        resp.addCookie(cookie);
        cookie.setValue("laoli");
        resp.addCookie(cookie);
        cookie.setMaxAge(0);
        cookie.setPath("");
        cookie.setDomain("");

        javax.servlet.jsp.PageContext pageContext;
        Student student = new Student();



        HttpSession session = req.getSession(true);
        session.setAttribute("username","username");
        session.invalidate();
        session.setMaxInactiveInterval(60);
        session.removeAttribute("username");
        session.getServletContext();

        req.getRequestDispatcher("").forward(req,resp);

        resp.sendRedirect("");

    }

    @Override
    public void init() throws ServletException {

    }
}
