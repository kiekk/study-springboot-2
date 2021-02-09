package com.example.mapper;

import java.util.List;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;

public interface BoardMapper {
	
	/*
	 * 해야 할 거
	 * 게시글 등록시 게시글 번호 가져온 후 등록하기
	 */
	
	/* 게시글 상세보기 */
	public BoardVO getBoard(Long bno);
	
	/* 게시글 목록 가져오기 */
	public List<BoardVO> getListAll(Criteria cri);
	
	/* 게시글 총 개수 가져오기 */
	public int getTotal(Criteria cri);
	
	/* 게시글 등록 */
	//public void insert(BoardVO board);
	public void insertSelectKey_bno(BoardVO board);
	
	/* 게시글 삭제 */
	public int delete(Long bno);
	
	/* 게시글 수정 */
	public int update(BoardVO board);
}
