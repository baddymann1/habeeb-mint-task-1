package com.mint.task1.domain.order.dto;

import com.mint.task1.domain.customer.dto.CustomerDTO;
import com.mint.task1.domain.types.OrderStatus;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO implements Serializable {
    private Long productId;

    private Long customerId;

    private CustomerDTO customer;


    private Integer quantity;


    private BigDecimal price;

    private BigDecimal discount;


    private OrderStatus status;
}
