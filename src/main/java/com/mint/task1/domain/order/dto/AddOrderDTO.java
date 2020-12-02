package com.mint.task1.domain.order.dto;

import com.mint.task1.domain.customer.dto.AddCustomerDTO;
import com.mint.task1.domain.customer.dto.CustomerDTO;
import com.mint.task1.domain.types.OrderStatus;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddOrderDTO implements Serializable {

    @NotBlank(message = "productId cannot be null")
    private Long productId;


    private Long customerId;

    private AddCustomerDTO customer;

    @NotNull(message = "quantity cannot be null")
    private Integer quantity;

    @NotNull(message = "price cannot be null")
    private BigDecimal price;


    private BigDecimal discount;

    @NotNull(message = "status cannot be null")
    private OrderStatus status;

    private LocalDate orderDate;

    private LocalTime orderTime;
}
