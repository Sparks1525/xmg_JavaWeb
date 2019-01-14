package servlet;

import dao.IProductDAO;
import dao.IProductDirDAO;
import dao.impl.ProductDAOImpl;
import dao.impl.ProductDirDAOImpl;
import domain.Product;
import domain.ProductDir;
import query.IQuery;
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

@WebServlet("/product/list")
public class ProductServlet extends HttpServlet {
    private static final Long serialVersionUID = 1L;
    private IProductDAO dao;
    private IProductDirDAO dirDAO;


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
        if ("edit".equals(cmd)) {
            this.edit(req, resp);
        } else if ("save".equals(cmd)) {
            this.saveOrUpdate(req, resp);
        } else if ("delete".equals(cmd)) {
            this.delete(req, resp);
        } else if ("query".equals(cmd)) {
            this.query(req, resp);
        } else {
            this.list(req, resp);
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Product> products = dao.list();
        List<ProductDir> dirs = dirDAO.list();
        req.setAttribute("dirs", dirs);
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String sid = req.getParameter("id");
        if (StringUtil.hasLength(sid)) {
            Product product = dao.get(Long.valueOf(sid));
            req.setAttribute("product", product);
        }
        List<ProductDir> dirs = dirDAO.list();
        req.setAttribute("dirs", dirs);
        req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);
    }

    protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String sid = req.getParameter("id");
        String productName = req.getParameter("productName");
        String dir_id = req.getParameter("dir_id");
        String salePrice = req.getParameter("salePrice");
        String supplier = req.getParameter("supplier");
        String brand = req.getParameter("brand");
        String cutoff = req.getParameter("cutoff");
        String costPrice = req.getParameter("costPrice");

        ProductDir dir = dirDAO.get(Long.valueOf(dir_id));
        Product product = new Product();
        product.setProductName(productName);
        product.setDir(dir);
        product.setSalePrice(new BigDecimal(salePrice));
        product.setSupplier(supplier);
        product.setBrand(brand);
        product.setCutoff(Double.valueOf(cutoff));
        product.setCostPrice(new BigDecimal(costPrice));
        if (StringUtil.hasLength(sid)) {
            product.setId(Long.valueOf(sid));
            dao.update(product);
        } else {
            dao.save(product);
        }
        resp.sendRedirect("/demo12/product/list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String sid = req.getParameter("id");
        dao.delete(Long.valueOf(sid));
        resp.sendRedirect("/demo12/product/list");
    }

    protected void query(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String productName = req.getParameter("productName");
        String minSalePrice = req.getParameter("minSalePrice");
        String maxSalePrice = req.getParameter("maxSalePrice");
        String dirId = req.getParameter("dirId");
        String keyword = req.getParameter("keyword");
        IQuery qo = new ProductQueryObject();

        if (StringUtil.hasLength(productName)) {
            ((ProductQueryObject) qo).setName(productName);
        }
        if (StringUtil.hasLength(minSalePrice)) {
            ((ProductQueryObject) qo).setMinSalePrice(new BigDecimal(minSalePrice));
        }
        if (StringUtil.hasLength(maxSalePrice)) {
            ((ProductQueryObject) qo).setMaxSalePrice(new BigDecimal(maxSalePrice));
        }
        if (StringUtil.hasLength(dirId)) {
            ((ProductQueryObject) qo).setDirId(Long.valueOf(dirId));
        }
        if (StringUtil.hasLength(keyword)) {
            ((ProductQueryObject) qo).setKeyword(keyword);
        }

        List<ProductDir> dirs = dirDAO.list();
        List<Product> products = dao.query(qo);
        req.setAttribute("products", products);
        req.setAttribute("qo", qo);
        req.setAttribute("dirs", dirs);
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
    }
}
