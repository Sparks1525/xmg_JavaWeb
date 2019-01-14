package servlet;

import dao.IProductDAO;
import dao.IProductDirDAO;
import dao.impl.ProductDAOImpl;
import dao.impl.ProductDirDAOImpl;
import domain.ProductDir;
import page.PageResult;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product/query")
public class PageServlet extends HttpServlet {
    private static final Long serialVersionUID = 1L;
    private IProductDAO dao;
    private IProductDirDAO dirDAO;

    @Override
    public void init() throws ServletException {
        dao = new ProductDAOImpl();
        dirDAO = new ProductDirDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer currentPage = 1;
        Integer pageSize = 3;
        // 接收用户传入的currentPage
        String sCurrentPage = req.getParameter("currentPage");
        if (StringUtil.hasLength(sCurrentPage)) {
            currentPage = Integer.valueOf(sCurrentPage);
        }
        String sPageSize = req.getParameter("pageSize");
        if(StringUtil.hasLength(sPageSize)){
            pageSize = Integer.valueOf(sPageSize);
        }
        List<ProductDir> dirs = dirDAO.list();
        req.setAttribute("dirs", dirs);
        // 调用分页查询方法
        PageResult pageResult = dao.queryPage1(currentPage, pageSize);
        req.setAttribute("pageResult",pageResult);
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
    }
}
