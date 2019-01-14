package servlet;

import dao.impl.ProductDAOImpl;
import dao.impl.ProductDirDAOImpl;
import domain.Product;
import domain.ProductDir;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/product/list")
public class ProductServlet extends HttpServlet {

    private ProductDAOImpl dao;
    private ProductDirDAOImpl dirDAO;

    @Override
    public void init() throws ServletException {
        dao = new ProductDAOImpl();
        dirDAO = new ProductDirDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String cmd = req.getParameter("cmd");
        if ("save".equals(cmd)) {
            this.saveOrUpdate(req, resp);
        } else if ("edit".equals(cmd)) {
            this.edit(req, resp);
        } else if ("delete".equals(cmd)) {
            this.delete(req, resp);
        } else {
            this.list(req, resp);
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Product> list = dao.list();
        req.setAttribute("products",list);
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req,resp);
    }

    protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String sid = req.getParameter("id");
        String productName = req.getParameter("productName");
        String dirSid = req.getParameter("productDir");
        String salePrice = req.getParameter("salePrice");
        String supplier = req.getParameter("supplier");
        String brand = req.getParameter("brand");
        String cutoff = req.getParameter("cutoff");
        String costPrice = req.getParameter("costPrice");
        ProductDir productDir = dirDAO.get(Long.valueOf(dirSid));

        Product product = new Product();
        product.setProductName(productName);
        product.setDir(productDir);
        product.setSalePrice(new BigDecimal(salePrice));
        product.setSupplier(supplier);
        product.setBrand(brand);
        product.setCutoff(Double.valueOf(cutoff));
        product.setCostPrice(new BigDecimal(costPrice));

        if(StringUtil.hasLength(sid)){
            product.setId(Long.valueOf(sid));
            dao.update(product);
        } else {
            dao.save(product);
        }
        resp.sendRedirect("/product/list");
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String sid = req.getParameter("id");
        List<ProductDir> productDirs = dirDAO.list();
        req.setAttribute("productDirs", productDirs);
        if(StringUtil.hasLength(sid)){
            Product product = dao.get(Long.valueOf(sid));
            req.setAttribute("product",product);
        }
        req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req,resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String sid = req.getParameter("id");
        dao.delete(Long.valueOf(sid));
        resp.sendRedirect("/product/list");
    }
}
