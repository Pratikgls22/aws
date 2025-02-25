package com.onlineportal.qrscanner.service;

import com.onlineportal.qrscanner.entity.ProductEntity;
import com.onlineportal.qrscanner.requestDto.ProductDto;

import java.util.List;


public interface ProductService {

    List<ProductEntity> getProducts();

    ProductEntity createProducts(ProductDto productDto);

//    List<ProductElasticEntity> searchProducts(String keyword);
}
