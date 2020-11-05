package com.ecommerce.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.app.dao.UserInfoDAO;
import com.ecommerce.app.entities.UserInfo;

@Repository
@Transactional
public class UserInfoDAOImpl implements UserInfoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override	
	public UserInfo getUser(String userName) {
		UserInfo userInfo = new UserInfo();
		
		List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=?1")
				.setParameter(1, userName).getResultList();
		if (!list.isEmpty()) {
			userInfo = (UserInfo) list.get(0);
		}
		return userInfo;
	}
}