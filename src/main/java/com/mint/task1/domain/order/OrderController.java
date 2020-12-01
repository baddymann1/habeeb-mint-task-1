package com.mint.task1.domain.order;

import com.mint.task1.config.ApiResponseBase;
import com.mint.task1.domain.order.dto.AddOrderDTO;
import com.mint.task1.domain.order.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/order")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponseBase<OrderDTO>> createProduct(AddOrderDTO dto) {
        ApiResponseBase<OrderDTO> pagedApiResponseBase = new ApiResponseBase<>();
        pagedApiResponseBase.setResponse(orderService.placeOrder(dto));
        return new ResponseEntity<>(pagedApiResponseBase, HttpStatus.OK);
    }
}
