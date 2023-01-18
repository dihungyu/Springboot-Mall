package com.wayne.springbootmall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wayne.springbootmall.dao.productDao;
import com.wayne.springbootmall.model.Product;
import com.wayne.springbootmall.service.productService;

@Component
public class productServiceImpl implements productService {
    @Autowired
    private productDao productDao;

    @Override
    public Product getProductById(Integer productId) {

        return productDao.getProductById(productId);
    }

}
