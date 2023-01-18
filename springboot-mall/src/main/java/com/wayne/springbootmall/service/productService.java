package com.wayne.springbootmall.service;

import com.wayne.springbootmall.dto.ProductRequest;
import com.wayne.springbootmall.model.Product;

public interface productService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
