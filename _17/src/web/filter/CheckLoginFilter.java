package web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        //当前正在过滤的资源
        String requestUri = req.getRequestURI();
        if(!"/login.jsp".equals(requestUri) && !"login".equals(requestUri)){
            Object user = req.getSession().getAttribute("USER_IN_SESSION");
            if(user == null){//没有登录
                resp.sendRedirect("login.jsp");
                return;
            }
        }
        chain.doFilter(req,resp);//放行
    }

    @Override
    public void destroy() {

    }
}
