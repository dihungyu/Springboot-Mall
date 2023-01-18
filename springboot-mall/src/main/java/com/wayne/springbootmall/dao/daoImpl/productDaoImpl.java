package com.wayne.springbootmall.dao.daoImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.wayne.springbootmall.dao.productDao;
import com.wayne.springbootmall.dto.ProductRequest;
import com.wayne.springbootmall.model.Product;
import com.wayne.springbootmall.rowmapper.productRowMapper;

@Component
public class productDaoImpl implements productDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {
        String sql = "Select * from product where productId = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        List<Product> list = namedParameterJdbcTemplate.query(sql, map, new productRowMapper());
        if (list.size() > 0) {
            return list.get(0);

        } else {
            return null;
        }

    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product(productName, category, imageUrl, price, stock, description, createDate, updateDate) VALUES (:productName, :category, :imageUrl, :price, :stock, :description, :createDate, :updateDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        Date now = new Date();
        map.put("createDate", now);
        map.put("updateDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        return keyHolder.getKey().intValue();
    }
}