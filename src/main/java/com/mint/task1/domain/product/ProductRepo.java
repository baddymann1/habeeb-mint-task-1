package com.mint.task1.domain.product;

import com.mint.task1.domain.types.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findById(Long id);
    Optional<ProductEntity> findByName(String name);
    List<ProductEntity> findByStatus(ProductStatus status);
}
