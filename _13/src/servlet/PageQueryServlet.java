package servlet;

import dao.IProductDAO;
import dao.IProductDirDAO;
import dao.impl.ProductDAOImpl;
import dao.impl.ProductDirDAOImpl;
import domain.ProductDir;
import page.PageResult;
import query.ProductQueryObject;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

// 高级查询+分页
@WebServlet("/product/pageQuery")
public class PageQueryServlet extends HttpServlet {
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

        ProductQueryObject qo = new ProductQueryObject();
        this.request2Obj(req,qo);
        req.setAttribute("qo",qo);
        PageResult pageResult = dao.query(qo);
        List<ProductDir> dirs = dirDAO.list();
        req.setAttribute("dirs", dirs);
        req.setAttribute("pageResult",pageResult);
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
    }

    protected void request2Obj(HttpServletRequest req, ProductQueryObject qo)
            throws ServletException, IOException {
        String productName = req.getParameter("productName");
        String minSalePrice = req.getParameter("minSalePrice");
        String maxSalePrice = req.getParameter("maxSalePrice");
        String dirId = req.getParameter("dirId");
        String keyword = req.getParameter("keyword");

        if (StringUtil.hasLength(productName)) {
            qo.setName(productName);
        }
        if (StringUtil.hasLength(minSalePrice)) {
            qo.setMinSalePrice(new BigDecimal(minSalePrice));
        }
        if (StringUtil.hasLength(maxSalePrice)) {
            qo.setMaxSalePrice(new BigDecimal(maxSalePrice));
        }
        if (StringUtil.hasLength(dirId)) {
            qo.setDirId(Long.valueOf(dirId));
        }
        if (StringUtil.hasLength(keyword)) {
            qo.setKeyword(keyword);
        }

        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        if(StringUtil.hasLength(currentPage)){
            qo.setCurrentPage(Integer.valueOf(currentPage));
        }
        if(StringUtil.hasLength(pageSize)){
            qo.setPageSize(Integer.valueOf(pageSize));
        }
    }

}
