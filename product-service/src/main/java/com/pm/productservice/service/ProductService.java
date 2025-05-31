package com.pm.productservice.service;

import com.pm.productservice.dto.ProductResponseDTO;
import com.pm.productservice.mapper.ProductMapper;
import com.pm.productservice.model.Product;
import com.pm.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> getProducts () {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(ProductMapper::toDTO).toList();
    }
}
