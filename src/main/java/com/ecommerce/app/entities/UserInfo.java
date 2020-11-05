package com.ecommerce.app.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="username",length=50,nullable=false)
	private String userName;
	
	@Column(name="password",length=800,nullable=false)
	private String password;
	
	@Column(name="role",length=50)	
	private String role;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
