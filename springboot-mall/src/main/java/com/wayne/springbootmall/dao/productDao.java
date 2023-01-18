package com.wayne.springbootmall.dao;

import com.wayne.springbootmall.dto.ProductRequest;
import com.wayne.springbootmall.model.Product;

public interface productDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

}
