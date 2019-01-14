package dao.impl;

import dao.IProductDirDAO;
import dao.IResultSetHandler;
import domain.ProductDir;
import query.IQuery;
import template.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDirDAOImpl implements IProductDirDAO {

    private IResultSetHandler<List<ProductDir>> rsh = new ProductDirResultSetHandler();

    @Override
    public void save(ProductDir productDir) {
        String sql = "INSERT INTO productDir(dirName,parent_id) VALUES (?,?)";
        Object[] objects = {productDir.getDirName(), productDir.getParent_id()};
        JdbcTemplate.update(sql, objects);
    }

    @Override
    public void update(ProductDir productDir) {
        String sql = "UPDATE productdir SET dirName=?,parent_id=? WHERE id = ?";
        Object[] objects = {productDir.getDirName(), productDir.getParent_id(), productDir.getId()};
        JdbcTemplate.update(sql, objects);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM productdir WHERE id=?";
        JdbcTemplate.update(sql, id);
    }

    @Override
    public ProductDir get(Long id) {
        String sql = "SELECT * FROM productdir WHERE id =?";
        List<ProductDir> list = JdbcTemplate.query(sql, rsh, id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<ProductDir> list() {
        String sql = "SELECT * FROM productdir";
        return JdbcTemplate.query(sql, rsh);
    }

    @Override
    public List<ProductDir> query(IQuery qo) {
        String sql = "SELECT * FROM productDir" + qo.getQuery();
        return JdbcTemplate.query(sql,rsh,qo.getParameters().toArray());
    }
}

class ProductDirResultSetHandler implements IResultSetHandler<List<ProductDir>>{

    @Override
    public List<ProductDir> handler(ResultSet rs) throws SQLException {
        List<ProductDir> list = new ArrayList<>();
        while (rs.next()){
            ProductDir productDir = new ProductDir();
            Long id = rs.getLong("id");
            String dirName = rs.getString("dirName");
            Long parent_id = rs.getLong("parent_id");
            productDir.setId(id);
            productDir.setDirName(dirName);
            productDir.setParent_id(parent_id);
            list.add(productDir);
        }
        return list;
    }
}
