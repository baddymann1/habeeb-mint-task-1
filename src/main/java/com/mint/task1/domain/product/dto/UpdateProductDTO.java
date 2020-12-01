package com.mint.task1.domain.product.dto;

import com.mint.task1.domain.types.ProductStatus;
import com.mint.task1.domain.types.QuantityType;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductDTO implements Serializable {

    @NotBlank(message = "id cannot be null")
    private Long id ;

    @NotBlank(message = "name cannot be null")
    private String name;

    private String description;

    @NotNull(message = "quantity cannot be null")
    private Integer quantity;

    @NotNull(message = "price cannot be null")
    private BigDecimal price;

    @NotNull(message = "status cannot be null")
    private ProductStatus status;

    private QuantityType quantityType;
}
