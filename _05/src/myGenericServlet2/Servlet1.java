package myGenericServlet2;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends MyGenericServlet {


    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        service(request,response);
    }

    //专门处理HTTP的请求
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String method = req.getMethod();//获取请求方式
        if("GET".equals(method)){
            doGet(req,res);
        } else if("POST".equals(method)){
            doPost(req,res);
        }
    }

    //专门用于处理POST请求
    private void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("Servlet1.doPost");
    }

    //专门用于处理GET请求
    private void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("\"Servlet1.doGet");
    }


    @Override
    public void init() {
        System.out.println("Servlet1 子类的初始化操作");
    }

    @Override
    public String getServletName() {
        return null;
    }

    @Override
    public String getInitParameter(String s) {
        return null;
    }
}
