package com.smartschool.springserver.service;

import com.smartschool.springserver.dto.ProductDTO;
import com.smartschool.springserver.mapper.ProductMapper;
import com.smartschool.springserver.model.Product;
import com.smartschool.springserver.model.School;
import com.smartschool.springserver.model.SchoolProduct;
import com.smartschool.springserver.repository.ProductRepository;
import com.smartschool.springserver.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    public ProductDTO getProductById(int id) {
        Product product = productRepository.findById(id).get();
        return ProductMapper.mapProduct(product);
    }

    public List<ProductDTO> getProducts() {
        List<Product> products = new ArrayList<>();
        Streamable.of(productRepository.findAll()).forEach(products::add);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for(Product product : products) {
            productDTOs.add(ProductMapper.mapProduct(product));
        }
        return productDTOs;
    }
}
