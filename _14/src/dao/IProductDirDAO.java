package dao;

import domain.ProductDir;
import query.IQuery;

import java.util.List;

public interface IProductDirDAO {
    void save(ProductDir dir);
    void update(ProductDir dir);
    void delete(Long id);
    ProductDir get(Long id);
    List<ProductDir> list();
    List<ProductDir> query(IQuery qo);
}
