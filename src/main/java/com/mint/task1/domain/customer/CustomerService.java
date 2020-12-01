package com.mint.task1.domain.customer;

import com.mint.task1.domain.customer.dto.AddCustomerDTO;
import com.mint.task1.domain.customer.dto.CustomerDTO;
import com.mint.task1.domain.customer.dto.UpdateCustomerDTO;

public interface CustomerService {
    CustomerDTO createCustomer(AddCustomerDTO customerDTO);
    CustomerDTO getCustomerById(Long id);
    CustomerDTO updateCustomer(UpdateCustomerDTO customerDTO);
    CustomerDTO getCustomerByNameAndPhoneNo(String name, String phoneNo);
}
