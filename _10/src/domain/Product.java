package domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private String productName;
    private String brand;
    private String supplier;
    private BigDecimal salePrice;
    private BigDecimal costPrice;
    private Double cutoff;
    ProductDir dir;
}
