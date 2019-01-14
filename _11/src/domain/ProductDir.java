package domain;

import lombok.Data;

@Data
public class ProductDir {
    private Long Id;
    private String dirName;
    private Long parent_id;
}
