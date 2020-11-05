package com.ecommerce.app.dao;

import com.ecommerce.app.entities.UserInfo;
public interface UserInfoDAO {
	public abstract UserInfo getUser(String userName);
}
