package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.Criteria;
import com.example.domain.ReplyVO;

public interface ReplyMapper {
	//´ñ±Û µî·Ï
	public int insert(ReplyVO reply);
	
	//´ñ±Û ¼öÁ¤
	public int update(ReplyVO reply);
	
	//´ñ±Û »èÁ¦
	public int deleteReply(Long rno);
	
	//´ñ±Û ¸ñ·Ï
	public List<ReplyVO> getReplyList(@Param("cri") Criteria cri,@Param("bno") Long bno);
	
	//´ñ±Û »ó¼¼
	public ReplyVO getReply(Long rno);
	
	//´ñ±Û ÃÑ °³¼ö
	public int getTotal(Long bno);
	
	//´ñ±Û ÀüÃ¼ »èÁ¦
	public int deleteBoardReplys(Long bno);
	
	//´ë´ñ±Û groupOrd, depth Áõ°¡
	public void updateGroupNoAndDepth(ReplyVO reply);
}
