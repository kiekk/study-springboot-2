package com.example.service;

import com.example.domain.Criteria;
import com.example.domain.ReplyPageDTO;
import com.example.domain.ReplyVO;

public interface ReplyService {
	//´ñ±Û µî·Ï
	public int register(ReplyVO reply);
	
	//´ñ±Û ¼öÁ¤
	public int modify(ReplyVO reply);
	
	//´ñ±Û »èÁ¦
	public int removeReply(Long rno);
	
	//´ñ±Û ¸ñ·Ï
	public ReplyPageDTO getReplyList(Criteria cri, Long bno);
	
	//´ñ±Û »ó¼¼
	public ReplyVO getReply(Long rno);
	
	//´ñ±Û ÃÑ °³¼ö
	public int getTotal(Long bno);
	
	//´ñ±Û ÀüÃ¼ »èÁ¦
	public int removeBoardReplys(Long bno);
}
