package com.managmentcampainapp.demo.service.productService;

import com.managmentcampainapp.demo.entity.Product;
import com.managmentcampainapp.demo.exception.IdNotFoundException;
import com.managmentcampainapp.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new IdNotFoundException(id, Product.class.getSimpleName()));
    }
}
