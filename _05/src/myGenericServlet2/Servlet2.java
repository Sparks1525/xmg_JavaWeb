package myGenericServlet2;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class Servlet2 extends MyGenericServlet {



    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public void init() {
        System.out.println("Servlet2 子类的初始化操作");
    }


}
