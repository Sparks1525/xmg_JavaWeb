package myservlet1;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class MyHttpServlet extends MyGenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        service(request,response);
    }



    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String method = req.getMethod();
        if("GET".equals(method)){
            doGet(req,res);
        } else if("POST".equals(method)){
            doPost(req,res);
        }

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

    }
}
