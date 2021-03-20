package com.managmentcampainapp.demo.controller;

import com.managmentcampainapp.demo.entity.ProductOwner;
import com.managmentcampainapp.demo.service.productOwnerService.ProductOwnerService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProductOwnerController {

    private final ProductOwnerService productOwnerService;

    public ProductOwnerController(ProductOwnerService productOwnerService) {
        this.productOwnerService = productOwnerService;
    }

    @GetMapping("/product-owner/{productOwnerId}")
    @ResponseStatus(OK)
    public ProductOwner getProductOwnerById(@PathVariable Long productOwnerId) {
        return productOwnerService.findProductOwnerById(productOwnerId);
    }
}
