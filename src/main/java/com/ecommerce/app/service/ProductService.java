package com.ecommerce.app.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.ecommerce.app.entities.Product;

public interface ProductService {
	
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
	 public abstract List<Product> getAllProducts();
	 
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
	 public abstract Product getProductById(int productId);
	 
	 @Secured ({"ROLE_ADMIN"})
	 public abstract boolean addProduct(Product product);
	 
	 @Secured ({"ROLE_ADMIN"})
	 public abstract void updateProduct(Product product);
	 
	 @Secured ({"ROLE_ADMIN"})
	 public abstract void deleteProduct(int productId);
}
