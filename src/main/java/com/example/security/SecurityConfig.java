package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.service.UserService;

import lombok.Setter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Setter(onMethod_ = @Autowired)
	private UserService u_service;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/**", "/board/list").permitAll()	//누구나 접근 허용
		.and()
		.authorizeRequests()
		.antMatchers("/board/get/**", "/board/register/**", "/board/modify/**").hasRole("ROLE_MEMBER")	//로그인 사용자만 접근 가능
		.and()
		.formLogin().loginPage("/user/login")	//로그인 페이지
		.defaultSuccessUrl("/board/list")	//로그인 성공시 리다이렉트 주소
		.and()
		.logout()						//로그아웃
		.logoutSuccessUrl("/")			//로그아웃 성공시 리다이렉트 주소
		.invalidateHttpSession(true);	//세션 제거
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
}
