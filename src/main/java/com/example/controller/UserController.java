package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.UserVO;
import com.example.service.UserService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/user/*")
public class UserController {

	@Setter(onMethod_ = @Autowired)
	private UserService u_service;
	
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
		String result = "";
		if(u_service.register(user) == 1)
			result = "success";
		else
			result = "fail";
		
		rttr.addFlashAttribute("result", result);
		return "redirect:/user/login";
	}
	
	/* 로그인 페이지로 이동 */
	@GetMapping("/login")
	public void login() {
		log.info("UserController.login(GET)");
	}
	
	/* 로그인 처리 */
	@PostMapping("/login")
	public String login(UserVO user, RedirectAttributes rttr, Model model, HttpSession session) {
		log.info("UserController.login(POST)");
		log.info("UserVO : " + user);
		
		//로그인 로직
		if(u_service.login(user) == 1) {
			session.setAttribute("user", user.getId());
			rttr.addFlashAttribute("result", "success");
			return "redirect:/board/list";			
		}else {
			model.addAttribute("result", "fail");
			return null;			
		}
		
	}
	
	//아이디 중복 체크
	@PostMapping("/checkId")
	public ResponseEntity<String> checkId(@RequestBody String id){
		log.info("UserController.checkId(POST)");
		log.info("id : " + id);
		
		return (u_service.checkId(id) == 0) ? new ResponseEntity<String>("success", HttpStatus.OK) : 
			new ResponseEntity<String>("fail", HttpStatus.OK);
	}
}
