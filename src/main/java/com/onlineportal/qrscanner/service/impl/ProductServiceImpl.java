package com.onlineportal.qrscanner.service.impl;

import com.onlineportal.qrscanner.entity.ProductEntity;
import com.onlineportal.qrscanner.repository.ProductRepository;
import com.onlineportal.qrscanner.requestDto.ProductDto;
import com.onlineportal.qrscanner.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> getProducts() {
        var data = this.productRepository.findAll();
        return data;
    }

    @Override
    public ProductEntity createProducts(ProductDto productDto) {
        var product = this.productRepository.findByName(productDto.getName());
        if (product.isPresent()) {
            throw new RuntimeException("Product Already Exist");
        }
        // Save to MySQL
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDto.getName());
        productEntity.setPrice(productDto.getPrice());
        ProductEntity savedProduct = this.productRepository.save(productEntity);

//        // Save to Elasticsearch
//        ProductElasticEntity productElasticEntity = new ProductElasticEntity();
//        productElasticEntity.setId(savedProduct.getId()); // Assuming MySQL and Elasticsearch have the same IDs
//        productElasticEntity.setName(savedProduct.getName());
//        productElasticEntity.setPrice(savedProduct.getPrice());
//        this.productElasticRepository.save(productElasticEntity);

        return savedProduct;
    }

//    @Override
//    public List<ProductElasticEntity> searchProducts(String keyword) {
//        return productElasticRepository.findByNameContaining(keyword);
//    }
}
