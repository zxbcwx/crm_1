package com.atguigu.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entity.User;
import com.atguigu.crm.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Transactional(readOnly=true)
	public User getUserByName(String name , String password){
		
		User user = userMapper.getUserByName(name,password);
		
		if(user != null 
				&& user.getPassword().equals(password)
				&& user.getEnabled() == 1){
			return user;
		}
		return null;
	}
	
}
