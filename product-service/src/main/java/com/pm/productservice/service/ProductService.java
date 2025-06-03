package com.pm.productservice.service;

import com.pm.productservice.dto.ProductRequestDTO;
import com.pm.productservice.dto.ProductResponseDTO;
import com.pm.productservice.exception.ProductNotFoundException;
import com.pm.productservice.mapper.ProductMapper;
import com.pm.productservice.model.Product;
import com.pm.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> getProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(ProductMapper::toDTO).toList();
    }


    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product newProduct = productRepository.save(ProductMapper.toModel(productRequestDTO));

        return ProductMapper.toDTO(newProduct);
    }

    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO productRequestDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with Id: " + id));

        product.setTitle(productRequestDTO.getTitle());
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());
        product.setImageUrl(productRequestDTO.getImageUrl());
        Product updatedProduct = productRepository.save(product);
        return ProductMapper.toDTO(updatedProduct);

    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

}
