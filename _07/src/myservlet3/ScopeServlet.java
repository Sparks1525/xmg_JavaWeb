package myservlet3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/myservlet3/scopeservlet"})
public class ScopeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");


        Integer requestCount = (Integer) req.getAttribute("count");
        if (requestCount == null) {
            req.setAttribute("count", 1);
        } else {
            req.setAttribute("count", requestCount + 1);
        }

        Integer sessionCount = (Integer) req.getSession().getAttribute("count");
        if (sessionCount == null) {
            req.getSession().setAttribute("count", 1);
        } else {
            req.getSession().setAttribute("count", sessionCount + 1);
        }


        Integer servletContextCount = (Integer) this.getServletContext().getAttribute("count");
        if (servletContextCount == null) {
            this.getServletContext().setAttribute("count", 1);
        } else {
            this.getServletContext().setAttribute("count", servletContextCount + 1);
        }

        req.getRequestDispatcher("/myservlet3/resultservlet").forward(req, resp);

    }

    @Override
    public void init() throws ServletException {

    }
}
