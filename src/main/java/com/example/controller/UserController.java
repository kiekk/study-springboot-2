package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.UserVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/user/*")
public class UserController {

	
	/* 회원가입 페이지로 이동 */
	@GetMapping("/signup")
	public void signup() {
		log.info("UserController.signup(GET)");
	}
	
	/* 회원가입 처리 */
	@PostMapping("/signup")
	public String signup(UserVO user, RedirectAttributes rttr) {
		log.info("UserController.signup(POST)");
		log.info("UserVO : " + user);
		
		//회원 가입 로직
		
		
		rttr.addFlashAttribute("result", "success");
		return "redirect:/user/login";
	}
	
	/* 로그인 페이지로 이동 */
	@GetMapping("/login")
	public void login() {
		log.info("UserController.login(GET)");
	}
	
	/* 로그인 처리 */
	@PostMapping("/login")
	public String login(UserVO user, RedirectAttributes rttr) {
		log.info("UserController.login(POST)");
		log.info("UserVO : " + user);
		
		//로그인 로직
		
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/list";
		
	}
}
