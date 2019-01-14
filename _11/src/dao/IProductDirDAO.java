package dao;
import domain.ProductDir;
import query.IQuery;

import java.util.List;

public interface IProductDirDAO {
    void save(ProductDir productDir);
    void update(ProductDir productDir);
    void delete(Long id);
    ProductDir get(Long id);
    List<ProductDir> list();
    List<ProductDir> query(IQuery qo);
}
