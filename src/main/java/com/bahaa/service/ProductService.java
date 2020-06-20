package com.bahaa.service;

import com.bahaa.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bahaa on 20/06/20.
 */
@Service
@AllArgsConstructor
public class ProductService {

    private static List<Product> products = Arrays.asList(
            new Product(1l, LocalDate.now(), null, "Whal supper tapper", 2L, 2.2),
            new Product(2l, LocalDate.now(), null, "Whal elite pro", 30L, 2.2),
            new Product(3l, LocalDate.now(), null, "Andis Master", 19L, 2.2)
    );


    public List<Product> listProducts() {
        return products;
    }


    public Product retrieveProduct(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("product not found"));
    }


    public Product updateProduct(Long id, Product product) {
        Product saveProduct = products.stream().filter(item -> item.getId().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("product not found"));
        BeanUtils.copyProperties(saveProduct, product);
        return product;
    }


    public void deleteProduct(Long id) {
        if (ObjectUtils.isEmpty(products)){
            throw new IllegalArgumentException("No Products exist");
        }
        if (!products.removeIf(product -> product.getId().equals(id))) {
            throw new IllegalArgumentException("product not found");
        }
    }

    public Product createProduct(Product product) {
        Long id = products.stream().max(Comparator.comparing(Product::getId)).get().getId();
        product.setId(++id);
        products.add(product);
        return  product;
    }
}
