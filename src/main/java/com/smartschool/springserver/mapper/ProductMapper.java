package com.smartschool.springserver.mapper;

import com.smartschool.springserver.dto.OrderProductDTO;
import com.smartschool.springserver.dto.ProductDTO;
import com.smartschool.springserver.model.Product;
import com.smartschool.springserver.model.SchoolProduct;

public class ProductMapper {
    private ProductMapper() {}

    public static ProductDTO mapProduct(SchoolProduct product) {
        return mapProduct(product.getPk().getProduct());
    }

    public static ProductDTO mapProduct(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setPic(product.getPic());
        return productDTO;
    }

    public static Product mapProduct(OrderProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setPic(productDTO.getPic());
        return product;
    }
}
