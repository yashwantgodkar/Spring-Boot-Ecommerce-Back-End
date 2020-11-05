package com.ecommerce.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.dao.ProductDAO;
import com.ecommerce.app.entities.Product;
import com.ecommerce.app.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public Product getProductById(int productId) {
		Product product = productDAO.getProductById(productId);
		return product;
	}
	
	@Override
	public List<Product> getAllProducts(){
		return productDAO.getAllProduct();
	}
	
	@Override
	public  boolean addProduct(Product product){
       if (productDAO.productExists(product.getProductName())) {
    	   return false;
       } else {
    	   productDAO.addProduct(product);
    	   return true;
       }
	}
	
	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}
	
	@Override
	public void deleteProduct(int productId) {
		productDAO.deleteProduct(productId);
	}
}
