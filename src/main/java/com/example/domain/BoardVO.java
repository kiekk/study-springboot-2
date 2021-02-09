package com.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardVO {
	/* 그룹 번호 */
	private int groupNo;
	/* 그룹 정렬 순서 */
	private int groupOrd;
	/* 깊이 */
	private int depth;
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
