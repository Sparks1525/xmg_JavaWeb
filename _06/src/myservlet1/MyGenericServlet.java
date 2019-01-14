package myservlet1;

import javax.servlet.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;

public abstract class MyGenericServlet implements Servlet,ServletConfig, Serializable {

    private static final long serialVersionUID = 1L;

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

    @Override
    public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }


    public void init(){}

    @Override
    public String getServletName() {
        return this.config.getServletName();
    }

    @Override
    public ServletContext getServletContext() {
        return this.config.getServletContext();
    }

    @Override
    public String getInitParameter(String name) {
        return this.config.getInitParameter(name);
    }

    @Override
    public Enumeration getInitParameterNames() {
        return this.config.getInitParameterNames();
    }
}
