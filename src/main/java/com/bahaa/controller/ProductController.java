package com.bahaa.controller;

import com.bahaa.domain.Product;
import com.bahaa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bahaa on 20/06/20.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product/v1")
public class ProductController {


    private final ProductService productService;

    @GetMapping
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @GetMapping(value = "/{id}")
    public Product retrieveProduct(@PathVariable Long id) {
        return productService.retrieveProduct(id);
    }

    @PutMapping(value = "/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return this.productService.updateProduct(id, product);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return this.productService.createProduct(product);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productService.deleteProduct(id);
    }


}
