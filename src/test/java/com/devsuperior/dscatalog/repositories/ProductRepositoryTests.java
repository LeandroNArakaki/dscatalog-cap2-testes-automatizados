package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.factories.ProductFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    private long existingId;
    private long nonExistingId;
    private long countTotalProducts;


    @BeforeEach
    void setUp()  {
        existingId = 1L;
        nonExistingId = 100L;
        countTotalProducts = 25L;
    }

    @Test
    public void saveShouldPersistWithAutoIncrementWhenIdIsNull() {
        Product product = ProductFactory.createProduct();
        product.setId(null);
        product = repository.save(product);

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(countTotalProducts + 1,product.getId());
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {
        repository.deleteById(existingId);
        Optional<Product> result = repository.findById(existingId);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void shouldFindObjectWhenIdExists() {
        Optional<Product> result = repository.findById(existingId);
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    public void shouldNotFindObjectWhenIdNotExists() {
        Optional<Product> result = repository.findById(nonExistingId);
        Assertions.assertFalse(result.isPresent());
    }





}
