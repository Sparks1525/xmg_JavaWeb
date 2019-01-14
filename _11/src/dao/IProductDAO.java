package dao;

import domain.Product;
import query.IQuery;

import java.util.List;

public interface IProductDAO {
    void save(Product product);
    void update(Product product);
    void delete(Long id);
    Product get(Long id);
    List<Product> list();

    List<Product> query(IQuery qo);


}
