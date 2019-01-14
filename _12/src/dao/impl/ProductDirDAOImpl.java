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

    IResultSetHandler<List<ProductDir>> rsh = new ProductDirResultSetHandler();

    @Override
    public void save(ProductDir dir) {
        String sql = "INSERT INTO productDir(dirName,parent_id) VALUES(?,?)";
        Object[] objects = {dir.getDirName(), dir.getParent_id()};
        JdbcTemplate.update(sql, objects);
    }

    @Override
    public void update(ProductDir dir) {
        String sql = "UPDATE productDir SET dirName=?,parent_id=? WHERE id=?";
        Object[] objects = {dir.getDirName(), dir.getParent_id(), dir.getId()};
        JdbcTemplate.update(sql, objects);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM productDir WHERE id=?";
        JdbcTemplate.update(sql, id);
    }

    @Override
    public ProductDir get(Long id) {
        String sql = "SELECT * FROM productDir WHERE id = ?";
        List<ProductDir> dirs = JdbcTemplate.query(sql, rsh, id);
        return dirs.size() == 1 ? dirs.get(0) : null;
    }

    @Override
    public List<ProductDir> list() {
        String sql = "SELECT * FROM productDir";
        return JdbcTemplate.query(sql, rsh);
    }

    @Override
    public List<ProductDir> query(IQuery qo) {
        String sql = "SELECT * FROM productDir" + qo.getQuery();
        return JdbcTemplate.query(sql, rsh,qo.getParameters().toArray());
    }
}

class ProductDirResultSetHandler implements IResultSetHandler<List<ProductDir>> {

    @Override
    public List<ProductDir> handler(ResultSet rs) throws SQLException {
        List<ProductDir> list = new ArrayList<>();
        while (rs.next()) {
            Long id = rs.getLong("id");
            String dirName = rs.getString("dirName");
            Long parent_id = rs.getLong("parent_id");
            ProductDir dir = new ProductDir();
            dir.setId(id);
            dir.setDirName(dirName);
            dir.setParent_id(parent_id);
            list.add(dir);
        }
        return list;
    }
}

