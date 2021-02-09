package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;
import com.example.domain.PageDTO;
import com.example.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	
	private BoardService b_service;
	
	//게시글 목록 페이지
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("BoardController.list(GET)");
		model.addAttribute("list", b_service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, b_service.getTotal(cri)));
	}
	
	//게시글 등록 페이지
	@GetMapping("/register")
	public void register(@ModelAttribute("cri") Criteria cri) {
		log.info("BoardController.register(GET)");
	}
	
	//게시글 상세보기, 수정 페이지
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("BoardController.get(GET)");
		model.addAttribute("board", b_service.get(bno));
	}
	
	//게시글 등록 처리
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("BoardController.register(POST)");
		b_service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	//게시글 수정 처리
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		log.info("BoardController.modify(POST)");
		rttr.addFlashAttribute("result", b_service.modify(board) ? "success" : "fail");
		return "redirect:/board/get" + cri.makeQuery() + "&bno=" + board.getBno();
	}
	
	//게시글 삭제 처리
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {
		log.info("BoardController.remove(POST)");
		rttr.addFlashAttribute("result", b_service.remove(bno) ? "success" : "fail");
		return "redirect:/board/list" + cri.makeQuery();
	}
	
}
