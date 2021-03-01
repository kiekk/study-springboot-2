package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.SMSService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/phone/")
@Log4j
@AllArgsConstructor
public class SMSController {

	private SMSService s_service;
	
	@PostMapping(value = "/checkSMS", consumes="application/json", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> checkSMS(@RequestBody String phone) {
		log.info("SMSController.checkSMS(POST)");
		log.info("phone : " + phone);
		String key = s_service.checkSMS(phone.replaceAll("-", ""));
		
		return new ResponseEntity<String>(key, HttpStatus.OK);
	}
}
