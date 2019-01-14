package myservlet1;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class MyServlet implements Servlet {


    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //this.showConfigInfo();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    public void showConfigInfo() {

        System.out.println("----------------------Begin-------------------------");


        System.out.println(".....ServletContext.....");
        //getServletContextName返回应用的名称，这里的名称是web.xml里面配置的display-name，如果没配置则返回null
        String servletContextName = getServletConfig().getServletContext().getServletContextName();
        String serverInfo = getServletConfig().getServletContext().getServerInfo();
        String contextPath = getServletConfig().getServletContext().getContextPath();
        System.out.println("servletContextName:" + servletContextName);
        System.out.println("serverInfo:" + serverInfo);
        System.out.println("contextPath:" + contextPath);

        Enumeration<String> contextInitParameterNames = getServletConfig().getServletContext().getInitParameterNames();
        while (contextInitParameterNames.hasMoreElements()){
            String cipName = contextInitParameterNames.nextElement();
            String cipVaule = getServletConfig().getServletContext().getInitParameter(cipName);
            System.out.println("cipName:" + cipName + ",cipVaule:" + cipVaule);
        }


        System.out.println(".....ServletConfig.....");
        String servletName = getServletConfig().getServletName();
        String nameValue = getServletConfig().getInitParameter("name");
        String ageValue = getServletConfig().getInitParameter("age");
        System.out.println("servletName:" + servletName);
        System.out.println("nameValue:" + nameValue + ",ageValue:" + ageValue);
        Enumeration<String> initParameterNames = getServletConfig().getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String ipName = initParameterNames.nextElement();
            String inValue = getServletConfig().getInitParameter(ipName);
            System.out.println("ipName:" + ipName + ",inValue:" + inValue);
        }

        System.out.println("----------------------End-------------------------");
    }
}
