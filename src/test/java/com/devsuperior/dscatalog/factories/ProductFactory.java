package com.devsuperior.dscatalog.factories;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;

import java.time.Instant;

public class ProductFactory {

    public static Product createProduct(){
        Product product = new Product(1L,"Phone","Good Phone",800.0,"https://www.apple.com/br/shop/buy-iphone", Instant.parse("2020-10-20T03:00:00Z"));
        product.getCategories().add(CategoryFactory.createCategory());
        return product;
    }

    public static ProductDTO createProductDTO(){
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }
}
