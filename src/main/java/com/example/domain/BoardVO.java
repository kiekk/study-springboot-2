package com.example.domain;

import lombok.Data;

@Data
public class BoardVO {
	/* 그룹 번호 */
	private int groupNo;
	/* 그룹 정렬 순서 */
	private int groupOrd;
	/* 깊이 */
	private int depth;
	/* 부모 게시글 번호 */
	private Long parentBno;
	/* 게시글 번호 */
	private Long bno;
	/* 게시글 제목 */
	private String title;
	/* 게시글 내용 */
	private String content;
	/* 작성자 */
	private String writer;
	/* 작성일 */
	private String regDate;
}
