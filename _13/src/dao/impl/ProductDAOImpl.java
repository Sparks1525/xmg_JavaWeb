package dao.impl;

import dao.IProductDAO;
import dao.IProductDirDAO;
import dao.IResultSetHandler;
import domain.Product;
import domain.ProductDir;
import page.PageResult;
import query.IQuery;
import template.JdbcTemplate;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAOImpl implements IProductDAO {

    IResultSetHandler<List<Product>> rsh = new ProductResultSetHandler();

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

    @Override
    public List<Product> baseQuery(IQuery qo) {
        String sql = "SELECT * FROM product" + qo.getQuery(true);
        return JdbcTemplate.query(sql, rsh, qo.getParameters().toArray());
    }

    @Override
    public PageResult queryPage1(Integer currentPage, Integer pageSize) {
        String baseSql = "SELECT * FROM product LIMIT ?,?";
        List<Product> listData = JdbcTemplate.query(baseSql, rsh,
                (currentPage - 1) * pageSize, pageSize);
        String countSql = "SELECT COUNT(*) FROM product";
        Integer totalCount = JdbcTemplate.query(countSql, new IResultSetHandler<Long>() {
            @Override
            public Long handler(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    return rs.getLong(1);
                }
                return 0L;
            }
        }).intValue();
        return new PageResult(listData, totalCount, currentPage, pageSize);
    }

    @Override
    public PageResult query(IQuery qo) {
        //查询结果集
        String baseSql= "SELECT * FROM product" + qo.getQuery(true) + " LIMIT ?,?";
        List<Object> newParams = new ArrayList<>(qo.getParameters());
        newParams.add((qo.getCurrentPage() - 1) * qo.getPageSize());
        newParams.add(qo.getPageSize());
        List<Product> listData = JdbcTemplate.query(baseSql,rsh,newParams.toArray());
        // ------------------------------------------
        // 查询结果总数
        String countSql = "SELECT COUNT(*) FROM product" + qo.getQuery(false);

        Integer totalCount = JdbcTemplate.query(countSql, new IResultSetHandler<Long>() {
            @Override
            public Long handler(ResultSet rs) throws SQLException {
                if(rs.next()){
                    return rs.getLong(1);
                }
                return 0L;
            }
        },qo.getParameters().toArray()).intValue();
        return new PageResult(listData,totalCount,qo.getCurrentPage(), qo.getPageSize());
    }
}

class ProductResultSetHandler implements IResultSetHandler<List<Product>> {

    Map<Long, ProductDir> cache = new HashMap<>();
    IProductDirDAO dirDAO = new ProductDirDAOImpl();

    @Override
    public List<Product> handler(ResultSet rs) throws SQLException {
        List<Product> list = new ArrayList<>();
        while (rs.next()) {
            Long id = rs.getLong("id");
            String productName = rs.getString("productName");
            Long dir_id = rs.getLong("dir_id");
            BigDecimal salePrice = rs.getBigDecimal("salePrice");
            String supplier = rs.getString("supplier");
            String brand = rs.getString("brand");
            Double cutoff = rs.getDouble("cutoff");
            BigDecimal costPrice = rs.getBigDecimal("costPrice");

            ProductDir dir = cache.get(dir_id);
            if (dir == null) {
                dir = dirDAO.get(dir_id);
                cache.put(dir_id, dir);
            }

            Product product = new Product();
            product.setId(id);
            product.setCostPrice(costPrice);
            product.setCutoff(cutoff);
            product.setBrand(brand);
            product.setSupplier(supplier);
            product.setSalePrice(salePrice);
            product.setProductName(productName);
            product.setDir(dir);

            list.add(product);
        }
        return list;
    }
}
