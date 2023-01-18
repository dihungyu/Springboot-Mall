package com.wayne.springbootmall.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wayne.springbootmall.constant.ProductCategory;
import com.wayne.springbootmall.model.Product;

public class productRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        Product product = new Product();
        product.setProductId(rs.getInt("productId"));
        product.setProductName(rs.getString("productName"));

        // String categoryStr = rs.getString("category");
        // ProductCategory category = ProductCategory.valueOf(categoryStr);
        // product.setCategory(category);
        // 以上三行可以簡寫至下方這一行，功能一致
        product.setCategory(ProductCategory.valueOf(rs.getString("category")));

        product.setImageUrl(rs.getString("imageUrl"));
        product.setPrice(rs.getInt("price"));
        product.setStock(rs.getInt("stock"));
        product.setDescription(rs.getString("description"));
        product.setCreateDate(rs.getDate("createDate"));
        product.setUpdateDate(rs.getDate("updateDate"));
        return product;
    }

}
