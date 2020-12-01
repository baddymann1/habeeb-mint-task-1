package com.mint.task1.domain.order;

import com.mint.task1.domain.customer.CustomerService;
import com.mint.task1.domain.customer.dto.CustomerDTO;
import com.mint.task1.domain.kafka.KafkaService;
import com.mint.task1.domain.order.dto.AddOrderDTO;
import com.mint.task1.domain.order.dto.OrderDTO;
import com.mint.task1.domain.order.dto.UpdateOrderDTO;
import com.mint.task1.domain.product.ProductService;
import com.mint.task1.domain.product.dto.ProductDTO;
import com.mint.task1.domain.product.dto.UpdateProductDTO;
import com.mint.task1.domain.types.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final CustomerService customerService;
    private final OrderValidator orderValidator;
    private final ProductService productService;
    private final KafkaService kafkaService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Bean
    public void setModelMapper() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public OrderDTO placeOrder(AddOrderDTO orderDTO) {
        OrderDTO dto;
        synchronized (this) {
            orderValidator.validateOrder(orderDTO);
            CustomerDTO customer;
            if (orderDTO.getCustomerId() != null) {
                customer = customerService.getCustomerById(orderDTO.getCustomerId());
            } else {
                customer = customerService.createCustomer(orderDTO.getCustomer());
            }
            ProductDTO productDTO = productService.getProductById(orderDTO.getProductId());
            productDTO.setQuantity(productDTO.getQuantity() - orderDTO.getQuantity());
            productService.updateProduct(modelMapper.map(productDTO, UpdateProductDTO.class));
            OrderEntity save = orderRepo.save(modelMapper.map(orderDTO, OrderEntity.class));
            dto = modelMapper.map(save, OrderDTO.class);
            dto.setCustomer(customer);

            kafkaService.publishOrder(dto);
        }
        return dto;
    }

    @Override
    public OrderDTO updateOrderToDone(Long id) {
        OrderEntity orderEntity = orderRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Id not found for order -> %s", id)));
        orderEntity.setStatus(OrderStatus.DONE);
        return modelMapper.map(orderEntity, OrderDTO.class);
    }

    @Override
    public OrderDTO updateOrder(UpdateOrderDTO orderDTO) {
        return null;
    }
}
