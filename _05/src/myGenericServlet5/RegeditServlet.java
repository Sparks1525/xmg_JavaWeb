package myGenericServlet5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegeditServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        /*
            等价于
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            源码里注释有
         */
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String radio = req.getParameter("radio");
        String hobby = req.getParameter("hobby");
        String city = req.getParameter("city");
        String tt = req.getParameter("tt");

        System.out.println(username);
        System.out.println(password);
        System.out.println(radio);
        System.out.println(hobby);
        System.out.println(city);
        System.out.println(tt);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
