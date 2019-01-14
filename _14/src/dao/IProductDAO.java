package dao;

import domain.Product;
import page.PageResult;
import query.IQuery;
import query.ProductQueryObject;

import java.util.List;

public interface IProductDAO {
    void save(Product product);

    void update(Product product);

    void delete(Long id);

    Product get(Long id);

    List<Product> list();

    List<Product> query(IQuery qo);

    /**
     * 分页查询
     * @param currentPage 当前第几页
     * @param pageSize 每页最多显示多少条数据
     * @return 封装好结果集和分页信息所有数据
     */
    PageResult queryPage1(Integer currentPage, Integer pageSize);

    PageResult query(ProductQueryObject qo);


}
