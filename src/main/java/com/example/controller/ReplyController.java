package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Criteria;
import com.example.domain.ReplyPageDTO;
import com.example.domain.ReplyVO;
import com.example.service.ReplyService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/replies/")
public class ReplyController {

	@Setter(onMethod_ = @Autowired)
	private ReplyService r_service;
	
	//´ñ±Û µî·Ï
	@PostMapping(value="/new", consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO reply){
		log.info("ReplyController.create");
		return r_service.register(reply) == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : 
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//´ñ±Û ¸ñ·Ï
	@GetMapping(value="/pages/{bno}/{page}", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("bno") Long bno, @PathVariable("page") int page){
		log.info("ReplyController.getList");
		return new ResponseEntity<ReplyPageDTO>(r_service.getReplyList(new Criteria(page, 10), bno), HttpStatus.OK);
	}
	
	//´ñ±Û »èÁ¦
	@DeleteMapping(value="/{rno}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		log.info("ReplyController.remove");
		return r_service.removeReply(rno) == 1 ? new ResponseEntity<String>("success", HttpStatus.OK) :
			new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//´ñ±Û ¼öÁ¤
	@RequestMapping(value="/{rno}", consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE}, method= {RequestMethod.PATCH, RequestMethod.PUT})
	public ResponseEntity<String> modify(@PathVariable("rno") Long rno, @RequestBody ReplyVO reply){
		log.info("ReplyController.modify");
		reply.setRno(rno);
		return r_service.modify(reply) == 1 ? new ResponseEntity<String>("success", HttpStatus.OK) : 
			new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
