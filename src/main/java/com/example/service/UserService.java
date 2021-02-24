package com.example.service;

import com.example.domain.UserVO;

public interface UserService {
	
	//중복 확인
	public int checkId(String id);
	
	//회원 가입
	public int register(UserVO user);
	
	//로그인
	public UserVO login(UserVO user);
}
