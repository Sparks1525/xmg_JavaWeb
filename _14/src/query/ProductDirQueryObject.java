package query;

import lombok.Data;
import util.StringUtil;

@Data
public class ProductDirQueryObject extends QueryObject{

    private String dirName;

    @Override
    protected void customized() {
        if(StringUtil.hasLength(dirName)){
            super.addQuery("dirName LIKE ?","%" + dirName + "%");
        }
    }
}
