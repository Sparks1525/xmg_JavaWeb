package servlet;

import dao.IProductDAO;
import dao.impl.ProductDAOImpl;
import page.PageResult;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/query")
public class PageServlet extends HttpServlet {
    private static final Long serialVersionUID = 1L;
    private IProductDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new ProductDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer currentPage = 1;
        // 接收用户传入的currentPage
        String sCurrentPage = req.getParameter("currentPage");
        if (StringUtil.hasLength(sCurrentPage)) {
            currentPage = Integer.valueOf(sCurrentPage);
        }
        // 调用分页查询方法
        PageResult pageResult = dao.queryPage1(currentPage, 3);
        req.setAttribute("pageResult",pageResult);
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
    }
}
