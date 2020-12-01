package com.mint.task1.domain.product;

import com.mint.task1.domain.types.ProductStatus;
import com.mint.task1.domain.types.QuantityType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(schema = "task1", name = "product"
)
public class ProductEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(name ="name", nullable = false)
    private String name;

    @Column(name ="description")
    private String description;


    @Column(name ="quantity", nullable = false)
    private Integer quantity;


    @Column(name ="price", nullable = false)
    private BigDecimal price;

    @Enumerated
    @Column(name ="status", nullable = false)
    private ProductStatus status;

    @Enumerated
    @Column(name ="qty_type")
    private QuantityType quantityType;


}
