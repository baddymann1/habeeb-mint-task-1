package com.mint.task1.domain.product;

import com.mint.task1.domain.product.dto.AddProductDTO;
import com.mint.task1.domain.product.dto.ProductDTO;
import com.mint.task1.domain.product.dto.UpdateProductDTO;
import com.mint.task1.domain.types.ProductStatus;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductValidator {

    private final ProductRepo productRepo;

    public void validateCreate(AddProductDTO productDTO) {
        Optional<ProductEntity> entityOptional = productRepo.findByName(productDTO.getName());
       if(entityOptional.isPresent()){
           throw new IllegalStateException("Product already existed");
       }
    }


    public void validateUpdate(UpdateProductDTO productDTO) {
        ProductEntity entity = productRepo
                .findByName(productDTO.getName()).orElseThrow(()-> new EntityNotFoundException(String.format("Product -> %s not found ", productDTO.getName())));

    }
}
