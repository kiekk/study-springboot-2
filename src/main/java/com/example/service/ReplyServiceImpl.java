package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Criteria;
import com.example.domain.ReplyPageDTO;
import com.example.domain.ReplyVO;
import com.example.mapper.ReplyMapper;

import lombok.Setter;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper r_mapper;
	
	@Override
	public int register(ReplyVO reply) {
		return r_mapper.insert(reply);
	}

	@Override
	public int modify(ReplyVO reply) {
		return r_mapper.update(reply);
	}

	@Override
	public int removeReply(Long rno) {
		return r_mapper.deleteReply(rno);
	}

	@Override
	public ReplyPageDTO getReplyList(Criteria cri, Long bno) {
		return new ReplyPageDTO(r_mapper.getTotal(bno), r_mapper.getReplyList(cri, bno));
	}

	@Override
	public ReplyVO getReply(Long rno) {
		return r_mapper.getReply(rno);
	}

	@Override
	public int getTotal(Long bno) {
		return r_mapper.getTotal(bno);
	}

	@Override
	public int removeBoardReplys(Long bno) {
		return r_mapper.deleteBoardReplys(bno);
	}

}
