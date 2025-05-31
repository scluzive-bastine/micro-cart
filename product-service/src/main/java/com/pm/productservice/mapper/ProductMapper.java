package com.pm.productservice.mapper;

import com.pm.productservice.dto.ProductResponseDTO;
import com.pm.productservice.model.Product;

public class ProductMapper {
    public static ProductResponseDTO toDTO(Product product) {
        ProductResponseDTO productDTO = new ProductResponseDTO();
        productDTO.setId(product.getId().toString());
        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());

        return productDTO;
    }
}
