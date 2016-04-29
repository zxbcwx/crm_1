package com.atguigu.crm.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.atguigu.crm.entity.User;

public interface UserMapper {
	
	@Select("SELECT u.id ,u.enabled , u.name,password,r.name as \"role.name\""
			+ "from users u "
			+ "Left outer join roles r "
			+ "on u.role_id = r.id "
			+ "where u.name= #{name}")
	public User getUserByName(@Param("name")String name ,@Param("password")String password);

}
