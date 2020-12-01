package com.mint.task1.domain.product.dto;

import com.mint.task1.domain.types.ProductStatus;
import com.mint.task1.domain.types.QuantityType;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {
    private Long id ;

    private String name;

    private String description;

    private Integer quantity;

    private BigDecimal price;

    private ProductStatus status;

    private QuantityType quantityType;
}
