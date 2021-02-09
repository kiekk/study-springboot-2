package com.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PageDTO {
	/* 시작 페이지 */
	private int startPage;
	/* 끝 페이지 */
	private int endPage;
	/* 마지막 게시글이 있는 페이지 */
	private int realEnd;
	/* 이전, 다음 페이지 유무 */
	private boolean prev, next;
	/* 총 게시글 개수 */
	private int total;
	/* Criteria 객체 */
	private Criteria cri;
	
	/*
	 * Criteria 객체를 이용하여 페이징에 필요한 정보 처리
	 */
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int) Math.ceil(cri.getPageNum() / (float)cri.getAmount()) * 10;
		this.startPage = this.endPage - 9;
		
		this.realEnd = (int) Math.ceil((total * 1.0) / cri.getAmount());
		
		if(realEnd < this.endPage)
			this.endPage = realEnd;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
