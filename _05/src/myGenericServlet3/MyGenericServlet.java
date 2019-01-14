package myGenericServlet3;

import javax.servlet.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;

public abstract class MyGenericServlet implements  Servlet,ServletConfig, Serializable {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        this.init();
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    public ServletContext getServletContext(){
        return this.config.getServletContext();

    }

    @Override
    public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;

    public Enumeration<String> getInitParameterNames(){
       return this.config.getInitParameterNames();
    }

    public String getInitParameterName(String name){
        return this.config.getInitParameter(name);
    }

    public void init(){}

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

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
