package com.smartschool.springserver.controller;

import com.smartschool.springserver.dto.ProductDTO;
import com.smartschool.springserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}/products")
    public ProductDTO getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/getproducts")
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }
}
