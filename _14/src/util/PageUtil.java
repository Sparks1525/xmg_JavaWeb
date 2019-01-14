package util;

import dao.IResultSetHandler;
import domain.Product;
import page.PageResult;
import query.ProductQueryObject;
import template.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PageUtil {
    private PageUtil(){}
    public static PageResult query(ProductQueryObject qo, String tableName, IResultSetHandler rsh) {
        //查询结果集
        String baseSql= "SELECT * FROM " + tableName + qo.getQuery(true) + " LIMIT ?,?";
        List<Object> newParams = new ArrayList<>(qo.getParameters());
        newParams.add((qo.getCurrentPage() - 1) * qo.getPageSize());
        newParams.add(qo.getPageSize());
        List<Product> listData = (List) JdbcTemplate.query(baseSql,rsh,newParams.toArray());
        // ------------------------------------------
        // 查询结果总数
        String countSql = "SELECT COUNT(*) FROM " + tableName + qo.getQuery(false);

        System.out.println(qo.getParameters());

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
