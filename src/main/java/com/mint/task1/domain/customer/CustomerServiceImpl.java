package com.mint.task1.domain.customer;

import com.mint.task1.domain.customer.dto.AddCustomerDTO;
import com.mint.task1.domain.customer.dto.CustomerDTO;
import com.mint.task1.domain.customer.dto.UpdateCustomerDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public CustomerDTO createCustomer(AddCustomerDTO customerDTO) {
        CustomerEntity save = customerRepo.save(modelMapper.map(customerDTO, CustomerEntity.class));
        return modelMapper.map(save, CustomerDTO.class);
    }


    @Override
    public CustomerDTO getCustomerById(Long id) {
        Optional<CustomerEntity> entityOptional = customerRepo.findById(id);
        return entityOptional.map(customerEntity -> modelMapper.map(customerEntity, CustomerDTO.class)).orElse(null);
    }
    @Override
    public CustomerDTO getCustomerByNameAndPhoneNo(String name, String phoneNo) {
        Optional<CustomerEntity> entityOptional = customerRepo.findByNameAndPhoneNo(name, phoneNo);
        return entityOptional.map(customerEntity -> modelMapper.map(customerEntity, CustomerDTO.class)).orElse(null);
    }

    @Override
    public CustomerDTO updateCustomer(UpdateCustomerDTO customerDTO) {
        CustomerEntity update = customerRepo.save(modelMapper.map(customerDTO, CustomerEntity.class));
        return modelMapper.map(update, CustomerDTO.class);
    }
}
