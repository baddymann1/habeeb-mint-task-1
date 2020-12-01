package com.mint.task1.domain.order;

import com.mint.task1.domain.order.dto.AddOrderDTO;
import com.mint.task1.domain.order.dto.OrderDTO;
import com.mint.task1.domain.order.dto.UpdateOrderDTO;

public interface OrderService {
    OrderDTO placeOrder(AddOrderDTO orderDTO);
    OrderDTO updateOrderToDone(Long id);
    OrderDTO updateOrder(UpdateOrderDTO orderDTO);

}
