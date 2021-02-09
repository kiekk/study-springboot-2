package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;
import com.example.mapper.BoardMapper;

import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper b_mapper;
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		return b_mapper.getListAll(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return b_mapper.getTotal(cri);
	}

	@Override
	public BoardVO get(Long bno) {
		return b_mapper.getBoard(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return b_mapper.update(board) == 1 ? true : false;
	}

	@Override
	public void register(BoardVO board) {
		b_mapper.insertSelectKey_bno(board);
	}

	@Override
	public boolean remove(Long bno) {
		return b_mapper.delete(bno) == 1 ? true : false;
	}

}
