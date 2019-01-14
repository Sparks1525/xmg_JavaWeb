package myservlet5_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value={"/myservlet5_cookie/cookie2/list"})
public class ListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        String username = null;

        Cookie[] myCookies= req.getCookies();
        for(Cookie myCookie : myCookies){
            String cookieName = myCookie.getName();
            String cookieVaule = myCookie.getValue();
            System.out.println("cookieName:" + cookieName +",cookieValue:" + cookieVaule);

            if("username".equals(cookieName)){
                username = cookieVaule;
            }
        }

        out.println("<p>ListServlet</p>");
        out.println("欢迎:" + username + "<br/>");
        for(int i = 0; i < 6; i++){
            out.println("<a href='/myservlet5_cookie/cookie/get'>一份邮件</a><br/>");
        }

    }

    @Override
    public void init() throws ServletException {
        System.out.println("ListServlet init");
    }
}
