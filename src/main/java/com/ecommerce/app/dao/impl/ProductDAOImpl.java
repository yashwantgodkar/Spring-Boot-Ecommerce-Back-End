package com.ecommerce.app.dao.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.app.dao.ProductDAO;
import com.ecommerce.app.entities.Product;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public Product getProductById(int productId) {
		return entityManager.find(Product.class, productId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProduct() {
		String HQL = "FROM Product as p ORDER BY p.productId";
		return (List<Product>) entityManager.createQuery(HQL).getResultList();
	}	
	
	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);
	}
	
	@Override
	public void updateProduct(Product product) {
		Product productFromDb = getProductById(product.getProductId());
		if(productFromDb != null){
			productFromDb.setProductName(product.getProductName());
			productFromDb.setProductDesc(product.getProductDesc());
			entityManager.flush();
		}else{
			System.out.println("product doesn't exist which u want update.");
		}
	}
		
	@Override
	public void deleteProduct(int productId) {
		Product product = getProductById(productId);
		if(product != null)
		entityManager.remove(product);
		else
			System.out.println("product doesn't exist which u want delete.");	
	}
	@Override
	public boolean productExists(String productName) {
		String hql = "FROM Product as p WHERE p.productName = ?";
		int count = entityManager.createQuery(hql).setParameter(1, productName).getResultList().size();
		return count > 0 ? true : false;
	}

}
