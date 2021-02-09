package com.example.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Criteria {
	/* 현재 페이지 번호 */
	private int pageNum;
	/* 한 페이지에 보여줄 페이지 수 */
	private int amount;
	
	/* 검색 기준 */
	private String type;
	/* 검색어 */
	private String keyword;
	
	/* 기본 값 설정 */
	public Criteria() {
		this(1, 10);
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	/*
	 * 검색기준이 없을 경우 빈 배열, 있을 경우 각 단어별로 split
	 */
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	public String makeQuery() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.amount)
				.queryParam("type", this.type)
				.queryParam("keyword", this.keyword);
		
		return builder.toUriString();
	}
}
