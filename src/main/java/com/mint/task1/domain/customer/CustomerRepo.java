package com.mint.task1.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepo  extends JpaRepository<CustomerEntity, Long> {


    Optional<CustomerEntity> findByNameAndPhoneNo(String name, String phoneNo);

}
