package web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    private String encoding;
    private Boolean forceEncoding = false;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.encoding = config.getInitParameter("encoding");
        this.forceEncoding = Boolean.valueOf(config.getInitParameter("force"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //类型转换
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        //=================================================================
        //设置编码
        //1:应用中没有编码并且我自己设置了编码
        //2:应用中已经存在了编码,但是依然要使用我自己设置的编码:强制使用
        if(hasLength(encoding)
         && (req.getCharacterEncoding() == null || forceEncoding)){
            req.setCharacterEncoding(encoding);
        }
        //放行
        chain.doFilter(req,resp);
    }

    private boolean hasLength(String str){
        return str != null && !"".equals(str.trim());
    }

    @Override
    public void destroy() {

    }
}
