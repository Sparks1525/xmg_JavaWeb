package myGenericServlet1;

import javax.servlet.*;
import java.util.Enumeration;

public abstract class MyGenericServlet implements Servlet {

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

    public Enumeration<String> getInitParameterNames(){
       return this.config.getInitParameterNames();
    }

    public String getInitParameterName(String name){
        return this.config.getInitParameter(name);
    }

    public void init(){}


}
