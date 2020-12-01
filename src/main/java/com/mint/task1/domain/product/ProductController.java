package com.mint.task1.domain.product;


import com.mint.task1.config.ApiResponseBase;
import com.mint.task1.domain.product.dto.AddProductDTO;
import com.mint.task1.domain.product.dto.ProductDTO;
import com.mint.task1.domain.product.dto.UpdateProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api(value = "Demand draft liquidates Controller", protocols = "https", description = "For demand draft liquidates Operations.")
@RequestMapping("/api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

private final ProductService productService;

//private final KafkaTemplate<String, ProductDTO> kafkaTemplate;

    @GetMapping("/available")
    public ResponseEntity<ApiResponseBase<List<ProductDTO>>> findByAvailability() {
        ApiResponseBase<List<ProductDTO>> pagedApiResponseBase = new ApiResponseBase<>();
        pagedApiResponseBase.setResponse(productService.getProductByAvailability());
//        kafkaTemplate.send("Kafka_Task1", pagedApiResponseBase.getResponse().get(0));
        return new ResponseEntity<>(pagedApiResponseBase, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponseBase<ProductDTO>> createProduct(AddProductDTO dto) {
        ApiResponseBase<ProductDTO> pagedApiResponseBase = new ApiResponseBase<>();
        pagedApiResponseBase.setResponse(productService.createProduct(dto));
        return new ResponseEntity<>(pagedApiResponseBase, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponseBase<ProductDTO>> updateProduct(UpdateProductDTO dto) {
        ApiResponseBase<ProductDTO> pagedApiResponseBase = new ApiResponseBase<>();
        pagedApiResponseBase.setResponse(productService.updateProduct(dto));
        return new ResponseEntity<>(pagedApiResponseBase, HttpStatus.OK);
    }

}
