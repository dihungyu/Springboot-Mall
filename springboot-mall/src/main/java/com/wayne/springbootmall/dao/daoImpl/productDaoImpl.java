package com.wayne.springbootmall.dao.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.wayne.springbootmall.dao.productDao;
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
}