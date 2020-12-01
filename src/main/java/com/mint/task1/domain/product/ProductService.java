package com.mint.task1.domain.product;

import com.mint.task1.domain.product.dto.AddProductDTO;
import com.mint.task1.domain.product.dto.ProductDTO;
import com.mint.task1.domain.product.dto.UpdateProductDTO;

import java.util.List;


public interface ProductService {
    ProductDTO createProduct(AddProductDTO productDTO);
    ProductDTO getProductById(Long id);
    ProductDTO updateProduct(UpdateProductDTO productDTO);
    List<ProductDTO> getProductByAvailability();
}
