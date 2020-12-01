package com.mint.task1.domain.order;

import com.mint.task1.domain.customer.CustomerService;
import com.mint.task1.domain.customer.dto.CustomerDTO;
import com.mint.task1.domain.order.dto.AddOrderDTO;
import com.mint.task1.domain.order.dto.OrderDTO;
import com.mint.task1.domain.order.dto.UpdateOrderDTO;
import com.mint.task1.domain.product.ProductService;
import com.mint.task1.domain.product.dto.ProductDTO;
import com.mint.task1.domain.types.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class OrderValidator {
    
    private final OrderRepo orderRepo;
    private final CustomerService customerService;
    private final ProductService productService;
    private final ModelMapper modelMapper = new ModelMapper();

    

    public void validateOrder(AddOrderDTO orderDTO) {
        if(orderDTO.getCustomerId() != null){
            CustomerDTO customer = customerService.getCustomerById(orderDTO.getCustomerId());
            if(customer == null){
                throw new EntityNotFoundException(String.format("Customer Id -> %s not found ", orderDTO.getCustomerId()));
            }
        }else if(orderDTO.getCustomer() != null){
            CustomerDTO customer = customerService.getCustomerByNameAndPhoneNo(orderDTO.getCustomer().getName(), orderDTO.getCustomer().getPhoneNo());
            if(customer != null){
                throw new EntityNotFoundException(String.format("Customer with name -> %s and phone number -> %s already exist ", orderDTO.getCustomer().getName(), orderDTO.getCustomer().getPhoneNo()));
            }
        }

        ProductDTO productDTO = productService.getProductById(orderDTO.getProductId());
        if(productDTO.getQuantity().compareTo(orderDTO.getQuantity())< 0){
            throw new IllegalStateException(String.format("There is no enough quantity of the product (product available -> %s, product order -> %s)", productDTO.getQuantity(), orderDTO.getQuantity()));
        }

    }


}
