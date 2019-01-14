package myGenericServlet1;

import javax.servlet.*;
import java.io.IOException;

public class Servlet1 extends MyGenericServlet {


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() {
        System.out.println("Servlet1 子类的初始化操作");
    }
}
