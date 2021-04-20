package com.platzi.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.platzi.market.domain.Product;

public interface ProductRepository {
	
	List<Product> getAll();
	Optional<List<Product>> getByCategory(int categoryId);
	Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete (int productId);
}
