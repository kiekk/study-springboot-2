package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;
import com.example.domain.LikeVO;
import com.example.mapper.BoardMapper;
import com.example.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper b_mapper;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper r_mapper;
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		return b_mapper.getListAll(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return b_mapper.getTotal(cri);
	}

	@Override
	public BoardVO get(BoardVO board) {
		return b_mapper.getBoard(board);
	}

	@Override
	public boolean modify(BoardVO board) {
		return b_mapper.update(board) == 1 ? true : false;
	}

	@Override
	public void register(BoardVO board) {
		log.info("board : " + board);
		
		//답글 쓰기일 경우 나머지 게시글 groupNo, depth 1씩 증가
		if(board.getGroupNo() > 0) 
			b_mapper.updateGroupNoAndDepth(board);
		
		b_mapper.insertSelectKey_bno(board);
	}

	@Override
	public boolean remove(Long bno) {
		r_mapper.deleteBoardReplys(bno);
		return b_mapper.delete(bno) == 1 ? true : false;
	}
	
	@Override
	public void updateReadcount(Long bno) {
		b_mapper.updateReadcount(bno);
	}
	
	@Override
	public int updateLike(LikeVO like) {
		return b_mapper.updateLike(like);
	}
	
	@Override
	public int getLikeCount(Long bno) {
		return b_mapper.getLikeCount(bno);
	}

}
