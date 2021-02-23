package com.example.mapper;

import java.util.List;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;
import com.example.domain.LikeVO;

public interface BoardMapper {
	
	/* 게시글 상세보기 */
	public BoardVO getBoard(LikeVO like);
	
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
	
	/* 게시글 groupNo, depth 증가 */
	public void updateGroupNoAndDepth(BoardVO board);
	
	/* 조회수 증가 */
	public void updateReadcount(Long bno);
	
	/* 좋아요 처리 */
	public int updateLike(LikeVO like);
	
	/* 좋아요 개수 가져오기 */
	public int getLikeCount(Long bno);
	
	/* 이전 게시글 가져오기 */
	public BoardVO getPrevBoard(Long bno);
	
	/* 다음 게시글 가져오기 */
	public BoardVO getNextBoard(Long bno);
	
}
