package com.managmentcampainapp.demo.service.productOwnerService;

import com.managmentcampainapp.demo.entity.ProductOwner;
import com.managmentcampainapp.demo.exception.IdNotFoundException;
import com.managmentcampainapp.demo.repository.ProductOwnerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductOwnerServiceImpl implements ProductOwnerService {

    ProductOwnerRepository productOwnerRepository;

    public ProductOwnerServiceImpl(ProductOwnerRepository productOwnerRepository) {
        this.productOwnerRepository = productOwnerRepository;
    }

    @Override
    public ProductOwner findProductOwnerById(Long id) {

        return productOwnerRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id, ProductOwner.class.getSimpleName()));
    }
}
