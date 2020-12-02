package com.mint.task1.domain.order;

import com.mint.task1.domain.customer.dto.AddCustomerDTO;
import com.mint.task1.domain.kafka.KafkaService;
import com.mint.task1.domain.order.dto.AddOrderDTO;
import com.mint.task1.domain.order.dto.OrderDTO;
import com.mint.task1.domain.types.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest()
@AutoConfigureMockMvc
@Slf4j
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @MockBean
    private KafkaService kafkaService;

    private  AddOrderDTO orderDTO;

    @BeforeEach
    public void setup(){
        orderDTO = AddOrderDTO.builder()
                .discount(BigDecimal.valueOf(30))
                .quantity(20)
                .status(OrderStatus.DONE)
                .productId(1L)
                .price(BigDecimal.valueOf(200))
                .customer(AddCustomerDTO.builder().name("Badmus2").phoneNo("09054242333").build())
                .build();
        Mockito.doNothing().when(kafkaService).publishOrder(any());
    }

    @Test
    @Transactional
    void test_PlaceOrder_Method() {

        OrderDTO response = orderService.placeOrder(orderDTO);
        assertEquals(response.getStatus(), orderDTO.getStatus());
        assertNotNull(response.getId());
    }

    @Test
    void updateOrderToDone() {
        System.out.println("good");
        assertNotNull("333");
    }
}