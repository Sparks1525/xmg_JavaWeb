package query;

import lombok.Data;

@Data
public class ProductDirQueryObject extends QueryObject {

    private String dirName;
    @Override
    protected void customized() {
        super.addQuery("dirName Like ?", dirName);
    }
}
