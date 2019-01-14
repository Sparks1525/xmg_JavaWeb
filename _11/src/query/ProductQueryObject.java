package query;

import lombok.Data;
import util.StringUtil;

import java.math.BigDecimal;

@Data
public class ProductQueryObject extends QueryObject {
    private String name;
    private BigDecimal minSalePrice;
    private BigDecimal maxSalePrice;
    private Long dirId;
    private String keyword;

    @Override
    protected void customized() {
        if (StringUtil.hasLength(name)) {
            super.addQuery("productName LIKE ?", "%" + name + "%");
        }
        if (minSalePrice != null) {
            super.addQuery("salePrice >= ?", minSalePrice);
        }
        if (maxSalePrice != null) {
            super.addQuery("salePrice <= ?", maxSalePrice);
        }
        if (dirId != null && dirId != -1) {
            super.addQuery("dir_id=?", dirId);
        }
        if (StringUtil.hasLength(keyword)) {
            super.addQuery("productName LIKE ? OR brank LIKE ?", "%" + keyword + "%", "%" + keyword + "%");
        }
        setOrderBy("dir_id", OrderBy.DESC);
        setOrderBy("salePrice", OrderBy.ASC);
    }
}
