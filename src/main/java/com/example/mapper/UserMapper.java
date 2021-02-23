package com.example.mapper;

import com.example.domain.UserVO;

public interface UserMapper {
	//중복 확인
	public int checkId(String id);
	
	//회원 가입
	public int insert(UserVO user);
	
	//로그인
	public int login(UserVO user);
}
