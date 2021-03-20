package com.managmentcampainapp.demo.repository;

import com.managmentcampainapp.demo.entity.ProductOwner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductOwnerRepository extends CrudRepository<ProductOwner, Long> {
}
