package com.ecommerce.app.dao;

import java.util.List;

import com.ecommerce.app.entities.Product;

public interface ProductDAO {
	public abstract List<Product> getAllProduct();
	public abstract Product getProductById(int productId);
	public abstract void addProduct(Product product);
	public abstract void updateProduct(Product product);
	public abstract void deleteProduct(int productId);
	public abstract boolean productExists(String productName);
}
