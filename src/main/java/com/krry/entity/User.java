package com.krry.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * @Document(collection = "user")这个注解和Hibernate的注解Entiry非常相似，
 * 就是定义一个文档，对象MongoDB存储的Collection（表）的名称是user
 * @Id指该字段是主键，不能缺少
 * @Field("username")指该字段映射MongoDB的实际字段，如果一致可以省略、
 *
 * User
 * @author krry
 * @version 1.0.0
 *
 */
@Document(collection = "user")
public class User {

	//主键
	@Id
	private String id;
	//用户名
	@Field("username")
	private String username;
	//密码
	private String password;
	//建时间
	private String createTime;
	
	public User() {
		
	}
	
	public User(String username,String password,String createTime) {
		this.username = username;
		this.password = password;
		this.createTime = createTime;
	}
	 
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	 
	
	 public String getId() {
		 return id;
	 }
	
	 public void setId(String id) {
		 this.id = id;
	 }
	
	 public String getUsername() {
		 return username;
	 }
	
	 public void setUsername(String username) {
		 this.username = username;
	 }
	
	 public String getPassword() {
		 return password;
	 }
	
	 public void setPassword(String password) {
		 this.password = password;
	 }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", createTime=" + createTime + "]";
	}
	
	 

}