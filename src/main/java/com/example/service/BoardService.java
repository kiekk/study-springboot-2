package com.example.service;

import java.util.List;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;

public interface BoardService {
	//전체 게시글 가져오기, 페이징 처리
	public List<BoardVO> getList(Criteria cri);
	
	//전체 게시글 개수 가져오기
	public int getTotal(Criteria cri);
	
	//게시글 가져오기
	public BoardVO get(Long bno);
	
	//게시글 수정
	public boolean modify(BoardVO board);
	
	//게시글 등록
	public void register(BoardVO board);
	
	//게시글 삭제
	public boolean remove(Long bno);

}
