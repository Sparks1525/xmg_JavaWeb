package myservlet5_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/myservlet5_cookie/cookie/get"})
public class GetServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        String username = null;

        Cookie[] myCookies = req.getCookies();
        for(Cookie myCookie : myCookies){
            String cookieName = myCookie.getName();
            String cookieValue = myCookie.getValue();
            System.out.println("cookieName:" + cookieName + ",cookieValue:" + cookieValue);
            if("username".equals(cookieName)){
                username = cookieValue;
            }
        }

        out.println("<p>GetServlet</p>");
        out.println("欢迎:" + username + "<br/>");

    }

    @Override
    public void init() throws ServletException {
        System.out.println("GetServlet init");
    }
}
