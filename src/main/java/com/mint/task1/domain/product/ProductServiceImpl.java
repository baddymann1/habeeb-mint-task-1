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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;
    private final ProductValidator productValidator;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProductDTO createProduct(AddProductDTO productDTO) {
        productValidator.validateCreate(productDTO);
        ProductEntity save = productRepo.save(modelMapper.map(productDTO, ProductEntity.class));
        return modelMapper.map(save, ProductDTO.class);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        ProductEntity entity = productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Id not found for product -> %s", id)));
        return modelMapper.map(entity, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(UpdateProductDTO productDTO) {
        productValidator.validateUpdate(productDTO);
        ProductEntity save = productRepo.save(modelMapper.map(productDTO, ProductEntity.class));
        return modelMapper.map(save, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getProductByAvailability() {
        List<ProductEntity> productEntityList = productRepo.findByStatus(ProductStatus.AVAILABLE);
        return productEntityList.stream().map(entity -> modelMapper.map(entity, ProductDTO.class)).collect(Collectors.toList());
    }
}
