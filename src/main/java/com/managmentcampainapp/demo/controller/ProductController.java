package com.managmentcampainapp.demo.controller;

import com.managmentcampainapp.demo.entity.Product;
import com.managmentcampainapp.demo.service.productService.ProductService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product-owner/{productOwnerId}/product/{productId}")
    @ResponseStatus(OK)
    public Product getProductById(@PathVariable Long productOwnerId,
                                  @PathVariable Long productId) {
        return productService.findProductById(productId);
    }
}
