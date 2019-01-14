package dao.impl;

import dao.IProductDAO;
import dao.IResultSetHandler;
import domain.Product;
import domain.ProductDir;
import template.JdbcTemplate;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAOImpl implements IProductDAO {

    private IResultSetHandler<List<Product>> rsh = new ProductResultSetHandler();

    @Override
    public void save(Product product) {
        String sql = "INSERT INTO product(productName,dir_id,salePrice,supplier,brand,cutoff,costPrice) VALUES (?,?,?,?,?,?,?)";
        Object[] objects = {product.getProductName(),
                product.getDir().getId(),
                product.getSalePrice(),
                product.getSupplier(),
                product.getBrand(),
                product.getCutoff(),
                product.getCostPrice()};
        JdbcTemplate.update(sql, objects);
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE product SET productName=?,dir_id=?,salePrice=?,supplier=?,brand=?,cutoff=?,costPrice=? WHERE id=?";
        Object[] objects = {product.getProductName(),
                product.getDir().getId(),
                product.getSalePrice(),
                product.getSupplier(),
                product.getBrand(),
                product.getCutoff(),
                product.getCostPrice(),
                product.getId()
        };
        JdbcTemplate.update(sql, objects);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM product WHERE id= ?";
        JdbcTemplate.update(sql, id);
    }

    @Override
    public Product get(Long id) {
        String sql = "SELECT * FROM product WHERE id=?";
        List<Product> list = JdbcTemplate.query(sql, rsh, id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<Product> list() {
        String sql = "SELECT * FROM product";
        return JdbcTemplate.query(sql, rsh);
    }
}

class ProductResultSetHandler implements IResultSetHandler<List<Product>> {

    private Map<Long, ProductDir> cache = new HashMap<>();

    private ProductDirDAOImpl dirDAO = new ProductDirDAOImpl();


    @Override
    public List<Product> handler(ResultSet rs) throws SQLException {
        List<Product> list = new ArrayList<>();
        while (rs.next()){
            Long id = rs.getLong("id");
            String productName = rs.getString("productName");
            BigDecimal salePrice = rs.getBigDecimal("salePrice");
            String supplier = rs.getString("supplier");
            String brand = rs.getString("brand");
            double cutoff = rs.getDouble("cutoff");
            BigDecimal costPrice = rs.getBigDecimal("costPrice");
            Long dir_id = rs.getLong("dir_id");
            ProductDir productDir = cache.get(dir_id);
            if(productDir == null){
                productDir = dirDAO.get(dir_id);
                cache.put(dir_id,productDir);
            }
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setProductName(rs.getString("productName"));
            product.setBrand(rs.getString("brand"));
            product.setSupplier(rs.getString("supplier"));
            product.setSalePrice(rs.getBigDecimal("salePrice"));
            product.setCostPrice(rs.getBigDecimal("costPrice"));
            product.setCutoff(rs.getDouble("cutoff"));
            product.setDir(productDir);
            list.add(product);
        }
        return list;
    }
}
