package myservlet6_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/myservlet6_session/cookie/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");

//        Cookie myCookie = new Cookie("username",username);
//        myCookie.setPath("/demo6/myservlet5_cookie");
//        //myCookie.setDomain(".xxx.xxx");
//        resp.addCookie(myCookie);

        HttpSession mySession = req.getSession(); //等价于req.getSession(true);
        mySession.setAttribute("username",username);

        //销毁Session对象
//        mySession.invalidate();

        //删除Session中指定属性名的值
//        mySession.removeAttribute("username");

        //超时管理 超时销毁Session /秒
//        mySession.setMaxInactiveInterval(60);

        out.println("<p>LoginServlet</p>");
        out.println("欢迎:" + username + "<br/>");
        out.println("<a href='/myservlet6_session/cookie2/list'>收件箱</a>");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("LoginServlet init");
    }
}
