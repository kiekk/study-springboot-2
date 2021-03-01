package com.example.service;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
@Log4j
public class SMSServiceImpl implements SMSService {
	
	private static final String API_KEY = "NCSFEIROUZ4JH3GZ";
	private static final String API_SECRET = "VJ1QLZJFFZ3HFNWU1SGAS4FZKCWCAM4U";

	@Override
	public String checkSMS(String phone) {

		log.info("SMSServiceImpl.checkSMS");
		log.info("phone : " + phone);
		Message coolsms = new Message(API_KEY, API_SECRET);
		Random rand = new Random();
        String key = "";
        for(int i=0; i<4; i++) {
            String randNum = Integer.toString(rand.nextInt(10));
            key += randNum;
        }
       	HashMap<String, String> params = new HashMap<>();
       	params.put("to", phone);	//수신자
       	params.put("from", "01072930509");	//발신자
       	params.put("text", "안녕하세요 테스트 입니다.\n인증번호는 [ " + key + " ] 입니다.");	//내용
       	params.put("type", "SMS");	//타입
        params.put("app_version", "JAVA SDK v2.2"); // application name and version
       	
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			log.info("Obj : " + obj.toString());
		} catch (CoolsmsException e) {
			e.printStackTrace();
		}
		
		return key;
	}

}
