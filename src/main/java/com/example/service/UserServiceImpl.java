package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.UserVO;
import com.example.mapper.UserMapper;

import lombok.Setter;


@Service
public class UserServiceImpl implements UserService {

	@Setter(onMethod_ = @Autowired)
	private UserMapper u_mapper;
	
	@Override
	public int checkId(String id) {
		return u_mapper.checkId(id);
	}
	
	@Override
	public int register(UserVO user) {
		return u_mapper.insert(user);	
	}
	@Override
	public int login(UserVO user) {
		return u_mapper.login(user);
	}
}
